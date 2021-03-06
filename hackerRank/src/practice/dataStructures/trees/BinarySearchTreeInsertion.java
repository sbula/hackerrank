package practice.dataStructures.trees;


public class BinarySearchTreeInsertion {

	static Node Insert(Node root,int value) {
		Node newNode  = new Node();
		newNode.data = value;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			return newNode;
		}
		Node travNode = root;
		while (travNode != null) {
			if (value < travNode.data) {
				if (travNode.left == null) {
					travNode.left = newNode;
					return root;
				}
				travNode = travNode.left;

			} else {
				if (travNode.right == null) {
					travNode.right = newNode;
					return root;
				}
				travNode = travNode.right;
			}
		}

		return root;
	}
}
