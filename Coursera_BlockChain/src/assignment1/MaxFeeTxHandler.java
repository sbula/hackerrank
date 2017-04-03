package assignment1;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MaxFeeTxHandler {
	private UTXOPool myUtxoPool;
	
    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */
    public MaxFeeTxHandler(UTXOPool utxoPool) {
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
    	return isValidTx(tx, myUtxoPool);
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
    	// rearrange possibleTxs to make sure transactions with inputs from transactions to be confirmed first can be executed
    	Transaction[] resolvedTxs = resolveDependencies(possibleTxs, myUtxoPool);
    	
    	// map the solution set to an int array (0 ==> not selected, 1 ==> selected, 2 ==> not evaluated yet)
    	int[] baseArray = new int[resolvedTxs.length];
    	for (int i=0; i<resolvedTxs.length; i++) {
    		baseArray[i] = 2;
    	}
    	
    	double[] feeArray = computeFees(resolvedTxs, myUtxoPool);
    	int[] resTxArray = handleTxs(resolvedTxs, myUtxoPool, baseArray, 0, feeArray, 0);
    	
    	
    	// check and process the transactions
    	int counter = 0;
    	for(int i=0;i<resTxArray.length;i++){
    		if (resTxArray[i] == 1) counter++;
    	}

    	Transaction[] acceptedTxs = new Transaction[counter];
    	int index=0;
    	for(int i=0;i<resTxArray.length;i++){
    		if (resTxArray[i] == 1 && isValidTx(resolvedTxs[i])) {
    			acceptedTxs[index++] = resolvedTxs[i];

    			// add the new outputs
    			byte[] txHash = resolvedTxs[i].getHash();
    			for (int k=0; k < resolvedTxs[i].getOutputs().size(); k++) {
    				myUtxoPool.addUTXO(new UTXO(txHash, k), resolvedTxs[i].getOutput(k));
    			}

    			// remove the consumed outputs
    			for (int k = 0; k < resolvedTxs[i].getInputs().size(); k++) {
    				Transaction.Input in = resolvedTxs[i].getInputs().get(k);
    				UTXO inUTXO = new UTXO(in.prevTxHash, in.outputIndex);
    				myUtxoPool.removeUTXO(inUTXO);
    			}
    		}
    	}

    	return acceptedTxs;
    }
    
    private boolean isValidTx(Transaction tx, UTXOPool utxoPool) {
    	ArrayList<Transaction.Input> inputList = tx.getInputs();
    	Set<UTXO> claimedUtxo = new TreeSet<UTXO>();
    	double inputValueSum = 0d;
		for (int i = 0; i < inputList.size(); i++) {
			Transaction.Input in = inputList.get(i);
        	// (1) all outputs claimed by {@code tx} are in the current UTXO pool
    		UTXO inUTXO = new UTXO(in.prevTxHash, in.outputIndex);
    		if (!utxoPool.contains(inUTXO)) {
    			return false;
    		}

        	// (2) the signatures on each input of {@code tx} are valid
    		Transaction.Output prevOut = utxoPool.getTxOutput(inUTXO);
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
    
    private int[] handleTxs(Transaction[] txs, UTXOPool myUtxoPool, int[] baseArray, int index, double[] feeArray, double upperMinBound) {
    	// return the input baseArray if the end is reached
    	if (index >= baseArray.length || baseArray[index] < 2) {
    		return baseArray;
    	}
    	
    	// check the transactions, accept it if possible and go on with the next in array
    	UTXOPool utxoPoolInclude = new UTXOPool(myUtxoPool);
    	int[] txsInclude = Arrays.copyOf(baseArray, baseArray.length);

    	// check and process the transactions
    	txsInclude[index] = 1;
    	if (isValidTx(txs[index], utxoPoolInclude) && isPossibleMax(txsInclude, feeArray, upperMinBound)) {
        	upperMinBound = computeUpperMinFee(txsInclude, feeArray, upperMinBound);
        	
    		// remove the consumed outputs from the local utxo pool
    		for (int k = 0; k < txs[index].getInputs().size(); k++) {
    			Transaction.Input in = txs[index].getInputs().get(k);
    			UTXO inUTXO = new UTXO(in.prevTxHash, in.outputIndex);
    			utxoPoolInclude.removeUTXO(inUTXO);
    		}
    		// add the new outputs to the local utxo pool
    		byte[] txHash = txs[index].getHash();
    		for (int k=0; k < txs[index].getOutputs().size(); k++) {
    			utxoPoolInclude.addUTXO(new UTXO(txHash, k), txs[index].getOutput(k));
    		}
    		
    		txsInclude = handleTxs(txs, utxoPoolInclude, txsInclude, index+1, feeArray, upperMinBound);
    	} else {
    		for (int i=0; i<txsInclude.length; i++) {
    			txsInclude[i] = 0;
    		}
    	}
    	

    	// check the transactions, accept it if possible and go on with the next in array
    	UTXOPool utxoPoolExclude = new UTXOPool(myUtxoPool);
    	int[] txsExclude = Arrays.copyOf(baseArray, baseArray.length);

    	// do not accept the transaction and continue
    	txsExclude[index] = 0;
    	if (isPossibleMax(txsExclude, feeArray, upperMinBound)) {
    		txsExclude = handleTxs(txs, utxoPoolExclude, txsExclude, index+1, feeArray, upperMinBound);
    	} else {
    		for (int i=0; i<txsExclude.length; i++) {
    			txsExclude[i] = 0;
    		}
    	}
    	
    	//compute the complete fee for both branches
		double includeFee = 0d;
		double excludeFee = 0d;
    	for (int i=0; i<txsInclude.length; i++) {
    		includeFee += (txsInclude[i] == 1) ? feeArray[i] : 0d;
    		excludeFee += (txsExclude[i] == 1) ? feeArray[i] : 0d;
    	}
    	
    	return (includeFee > excludeFee) ? txsInclude : txsExclude;
    }
    
	private boolean isPossibleMax(int[] txArray, double[] feeArray, double upperMinBound) {
		double maxPosFee = 0d;
    	for (int i=0; i < txArray.length; i++) {
    		maxPosFee += (txArray[i]>0  && feeArray[i]>0) ? feeArray[i] : 0d;
    	}
    	
    	return maxPosFee >= upperMinBound;
	}
	
	private double computeUpperMinFee(int[] txArray, double[] feeArray, double upperMinBound) {
		double minFee = 0d;
    	for (int i=0; i < txArray.length; i++) {
    		minFee += (txArray[i] == 1) ? feeArray[i] : 0d;
    	}
    	
    	return (upperMinBound > minFee) ? upperMinBound : minFee;
	}
    
    /**
     * 
     * @param txs
     * @param utxoPool
     * @return the tx fee if it is a valid tx, Integer.MIN_VALUE else
     */
    private double[] computeFees(Transaction[] txs, UTXOPool utxoPool) {
    	// make a pool copy
    	UTXOPool poolCopy = new UTXOPool(utxoPool);
		
		// add the new outputs to the poolCopy
    	for (int i=0; i<txs.length; i++) {
    		byte[] txHash = txs[i].getHash();
    		for (int k=0; k < txs[i].getOutputs().size(); k++) {
    			poolCopy.addUTXO(new UTXO(txHash, k), txs[i].getOutput(k));
    		}
    	}
    	
    	// compute the fee for all transactions
    	double[] feeArray = new double[txs.length];
    	for (int i=0; i<feeArray.length; i++) {
    		feeArray[i] = 0d;
    	}
    	
    	for  (int i=0; i<txs.length; i++) {
    		if (!isValidTx(txs[i], poolCopy)) {
    			feeArray[i] = Integer.MIN_VALUE;
    			continue;
    		}
    		ArrayList<Transaction.Input> inputList = txs[i].getInputs();
    		for (int k=0; k < inputList.size(); k++) {
    			Transaction.Input in = inputList.get(k);
    			UTXO inUTXO = new UTXO(in.prevTxHash, in.outputIndex);
    			
    			Transaction.Output prevOut = poolCopy.getTxOutput(inUTXO);
    			feeArray[i] += prevOut.value;
    		}
    		
    		for(Transaction.Output out : txs[i].getOutputs()) {
    			feeArray[i] -= out.value;
    		}
    	}
    	return feeArray;
    }

    private Transaction[] resolveDependencies(Transaction[] txs, UTXOPool utxoPool) {
    	UTXOPool poolCopy = new UTXOPool(utxoPool);
    	List<Transaction> validTxList = new LinkedList<Transaction>();
    	List<Transaction> pufferList = new LinkedList<Transaction>();
    	
    	// add all valid transactions to validTxList and their output UTXO to the local pool
    	// invalid transactions will be added to pufferList and we try to add them later once again
    	for(int i=0; i<txs.length; i++) {
    		if(isValidTx(txs[i], poolCopy)) {
    			validTxList.add(txs[i]);
				byte[] txHash = txs[i].getHash();
				for (int k=0; k < txs[i].getOutputs().size(); k++) {
					poolCopy.addUTXO(new UTXO(txHash, k), txs[i].getOutput(k));
				}
    		} else {
    			pufferList.add(txs[i]);
    		}	
    	}
    	
    	// try to add the previous invalid transactions as there might be new outputs available to be consumed...
    	int pufLen = txs.length;
    	while (pufferList.size() < pufLen) {
    		pufLen = pufferList.size();
    		LinkedList<Transaction> newPufList = new LinkedList<Transaction>();
    		for (Transaction tx : pufferList) {
    			if (isValidTx(tx, poolCopy)) {
    				byte[] txHash = tx.getHash();
    				for (int k=0; k < tx.getOutputs().size(); k++) {
    					poolCopy.addUTXO(new UTXO(txHash, k), tx.getOutput(k));
    				}
    				validTxList.add(tx);
    			} 
			}
			
    		pufferList.clear();
    		pufferList.addAll(newPufList);
    	}
    	
    	Transaction[] resolvedTxs = new Transaction[validTxList.size()];
    	resolvedTxs =validTxList.toArray(resolvedTxs);
    	
    	return resolvedTxs;
    }
    
}