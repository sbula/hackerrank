package assignment2;

import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
	private double p_graph;
	private double p_malicious;
	private double p_txDistribution;
	private int numRounds;
	
	private Set<Transaction> pendingTransactions;
	
	private boolean[] followees;
	private boolean[] blacklist;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
    	this.p_graph = p_graph;
    	this.p_malicious = p_malicious;
    	this.p_txDistribution = p_txDistribution;
    	this.numRounds = numRounds;
    	this.pendingTransactions = new HashSet<Transaction>();
    }

    public void setFollowees(boolean[] followees) {
    	this.followees = followees.clone();
    	this.blacklist = new boolean[followees.length];
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        this.pendingTransactions.addAll(pendingTransactions);
    }

    public Set<Transaction> sendToFollowers() {
        Set<Transaction> tmp = this.pendingTransactions;
        this.pendingTransactions = new HashSet<Transaction>();
    	return tmp;
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
    	boolean[] receivedMsgFrom = new boolean[followees.length];
    	for (Candidate cand : candidates) {
    		if (!blacklist[cand.sender] && followees[cand.sender]) {
    			pendingTransactions.add(cand.tx);
    			receivedMsgFrom[cand.sender] = true;
    		}
    	}
    	
    	for (int i=0; i<followees.length; i++) {
    		blacklist[i] = blacklist[i] || (followees[i] && !receivedMsgFrom[i]);
    	}
    }
}
