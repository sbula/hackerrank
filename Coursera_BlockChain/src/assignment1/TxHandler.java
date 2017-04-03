package assignment1;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class TxHandler {

	private UTXOPool myUtxoPool;
	
    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */
    public TxHandler(UTXOPool utxoPool) {
    	myUtxoPool = new UTXOPool(utxoPool);
    }

    /**
     * @return true if:
     * (1) all outputs claimed by {@code tx} are in the current UTXO pool, 
     * (2) the signatures on each input of {@code tx} are valid, 
     * (3) no UTXO is claimed multiple times by {@code tx},
     * (4) all of {@code tx}s output values are non-negative, and
     * (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
     *     values; and false otherwise.
     */
    public boolean isValidTx(Transaction tx) {
    	ArrayList<Transaction.Input> inputList = tx.getInputs();
    	Set<UTXO> claimedUtxo = new TreeSet<UTXO>();
    	double inputValueSum = 0d;
		for (int i = 0; i < inputList.size(); i++) {
			Transaction.Input in = inputList.get(i);
        	// (1) all outputs claimed by {@code tx} are in the current UTXO pool
    		UTXO inUTXO = new UTXO(in.prevTxHash, in.outputIndex);
    		if (!myUtxoPool.contains(inUTXO)) {
    			return false;
    		}

        	// (2) the signatures on each input of {@code tx} are valid
    		Transaction.Output prevOut = myUtxoPool.getTxOutput(inUTXO);
    		if(prevOut == null) {
    			continue;
    		}
    		PublicKey pubKey = prevOut.address;
    		byte[] sig = in.signature;
    		byte[] rawData = tx.getRawDataToSign(i);
    		if(rawData == null || sig == null) {
    			return false;
    		}
    		if (!Crypto.verifySignature(pubKey, rawData, sig)) {
    			return false;
    		}
    		
        	// (3) no UTXO is claimed multiple times by {@code tx}
			if (claimedUtxo.contains(inUTXO)) {
				return false;
			}
			claimedUtxo.add(inUTXO);
			
			// (5) sum up all the input values
			inputValueSum += prevOut.value;
    	}
    	
		// (4) all of {@code tx}s output values are non-negative
		double outputValueSum = 0d;
    	for(Transaction.Output out : tx.getOutputs()) {
    		if(out.value < 0) {
    			return false;
    		}

			// (5) sum up all the output values
    		outputValueSum += out.value;
    	}
    	
    	// (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output values
    	return (inputValueSum >= outputValueSum);
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
    	
    	List<Transaction> acceptedTXs = new ArrayList<Transaction>();
    	for(Transaction tx : possibleTxs) {
    		if (isValidTx(tx)) {
    			acceptedTXs.add(tx);
    			
    			// add the new outputs
    			byte[] txHash = tx.getHash();
    			for (int i=0; i < tx.getOutputs().size(); i++) {
    				myUtxoPool.addUTXO(new UTXO(txHash, i), tx.getOutput(i));
    			}
    			
    			// remove the consumed outputs
    			for (int i = 0; i < tx.getInputs().size(); i++) {
    				Transaction.Input in = tx.getInputs().get(i);
    	    		UTXO inUTXO = new UTXO(in.prevTxHash, in.outputIndex);
    	    		myUtxoPool.removeUTXO(inUTXO);
    			}
    			
    		}
    	}
    	
    	return acceptedTXs.toArray(new Transaction[acceptedTXs.size()]);
    }

}
