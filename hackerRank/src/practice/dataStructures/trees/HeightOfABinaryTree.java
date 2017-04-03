package practice.dataStructures.trees;

public class HeightOfABinaryTree {
	// you only have to complete the function given below.  
	// Node is defined as  

	class Node {
	    int data;
	    Node left;
	    Node right;
	}
	
    	
	static int height(Node root) {
        if (root == null) return -1;
        int leftH = height(root.left) + 1;
        int rightH = height(root.right) + 1;
        return Math.max(leftH, rightH);
    }
}
