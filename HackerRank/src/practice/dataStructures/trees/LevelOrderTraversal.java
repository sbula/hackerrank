package dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	// you only have to complete the function given below.  
	// Node is defined as  
    
    class Node {
       int data;
       Node left;
       Node right;
   }
    void LevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> nodesQueue = new LinkedList<Node>();
        nodesQueue.add(root);
        while (!nodesQueue.isEmpty()) {
            Node node = nodesQueue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) nodesQueue.add(node.left);
            if (node.right != null) nodesQueue.add(node.right);
        }
    }
}
