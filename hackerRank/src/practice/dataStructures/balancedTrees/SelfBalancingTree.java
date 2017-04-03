package practice.dataStructures.balancedTrees;

public class SelfBalancingTree {
	static class Node {
		int val;   //Value
		int ht;      //Height
		Node left;   //Left child
		Node right;   //Right child
	}
	
    static Node insert(Node root,int val) {
        if (root == null) {
            root = new Node();
            root.val = val;
            return root;
        }
       
        if (root.val == val) {
            return root;
        }
        
        if (root.val > val) {
            root.left = insert(root.left, val);
         
        } else {
            root.right = insert(root.right, val);
        }
        root.ht = height(root);
        return rebalance(root);
    }

private static int height(Node root) {
    if (root == null) return -1;
    return Math.max(height(root.left), height(root.right)) + 1;
}

private static Node rebalance(Node root) {
    if (root == null) return root;
    if (balanceFactor(root) > 1) {
        if (balanceFactor(root.left) < 0) {
            root = leftRightRotation(root);
        }
        root = leftLeftRotation(root);
    
    } else if (balanceFactor(root) < -1) {
        if (balanceFactor(root.right) > 0) {
        	root = rightLeftRotation(root);
        }
        root = rightRightRotation(root);
    }
    if (root.right != null) root.right.ht = height(root.right);
    if (root.left != null) root.left.ht = height(root.left);
    root.ht = height(root);
    
    return root;
}

private static int balanceFactor(Node root) {
    if (root == null) return 0;
    return height(root.left) - height(root.right);
}


private static Node leftRightRotation(Node root) {
    Node tmp = root.left;
    root.left = tmp.right;
    tmp.right = root.left.left;
    root.left.left = tmp;
    if(root.right != null) root.right.ht = height(root.right);
    if(root.left != null) root.left.ht = height(root.left);
    root.ht = height(root);
    return root;
}

private static Node leftLeftRotation(Node root) {
    Node tmp = root.left;
    root.left = tmp.right;
    tmp.right = root;
    if(tmp.right != null) tmp.right.ht = height(tmp.right);
    if(tmp.left != null) tmp.left.ht = height(tmp.left);
    tmp.ht = height(tmp);
    return tmp;
}

private static Node rightLeftRotation(Node root) {
    Node tmp = root.right;
    root.right = tmp.left;
    tmp.left = root.right.right;
    root.right.right = tmp;
    if(root.right != null) root.right.ht = height(root.right);
    if(root.left != null) root.left.ht = height(root.left);
    root.ht = height(root);
    return root;
}

private static Node rightRightRotation(Node root) {
    Node tmp = root.right;
    root.right = tmp.left;;
    tmp.left = root;
    if(tmp.right != null) tmp.right.ht = height(tmp.right);
    if(tmp.left != null) tmp.left.ht = height(tmp.left);
    tmp.ht = height(tmp);
    return tmp;
}
}
