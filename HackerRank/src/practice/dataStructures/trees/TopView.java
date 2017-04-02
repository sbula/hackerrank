package practice.dataStructures.trees;

public class TopView {
	// you only have to complete the function given below.  
	// Node is defined as  
	
	class Node  {
	       int data;
	       Node left;
	       Node right;
	}
	
	void top_view(Node root) {
	    if (root == null) return;
	    top_left(root.left);
	    System.out.print(root.data + " ");
	    top_right(root.right);
	}

	private void top_left(Node root) {
	    if (root == null) return;
	    top_left(root.left);
	    System.out.print(root.data + " ");
	}

	private void top_right(Node root) {
	    if (root == null) return;
	    System.out.print(root.data + " ");
	    top_right(root.right);
	}
}
