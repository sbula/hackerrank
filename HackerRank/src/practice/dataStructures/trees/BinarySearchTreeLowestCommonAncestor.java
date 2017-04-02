package dataStructures.trees;

public class BinarySearchTreeLowestCommonAncestor {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node lca(Node root,int v1,int v2) {
		int low = (v1<v2) ? v1 : v2;
		int up  = (v1<v2) ? v2 : v1;

		Node myNode = root;
		while (myNode != null) {
			if (myNode.data > up) {
				myNode = myNode.left;
			} else if (myNode.data < low) {
				myNode = myNode.right;
			} else {
				return myNode;
			}
		}
		return null; 
	}
}
