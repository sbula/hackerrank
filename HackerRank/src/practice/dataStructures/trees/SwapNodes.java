package dataStructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {
	private static class Node {
		private final int date, depth;
		private Node left, right;

		public Node(int date, int depth) {
			super();
			this.date = date;
			this.depth = depth;
		}

		public void setNodes (Node leftNode, Node rightNode) {
			left = leftNode;
			right = rightNode;
		}

		public void swap() {
			Node tmp = left;
			left = right;
			right = tmp;
		}

		public void inorderTraversal(StringBuilder sb) {
			if (left != null) left.inorderTraversal(sb);
			sb.append(date + " ");
			if (right != null) right.inorderTraversal(sb);
		}
	}

	public static void main(String[] args) {
		Map<Integer, List<Node>> depthNodes = new HashMap<Integer, List<Node>>();
		int maxDepth = 0;

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		Queue<Node> leafNodesQueue = new LinkedList<Node>();
		Node root = new Node(1, 1);
		{
			List<Node> nodeList = new ArrayList<Node>();
			nodeList.add(root);
			depthNodes.put(1, nodeList);
			leafNodesQueue.add(root);
			maxDepth = 1;
		}
		for (int i=0; i<N; i++) {
			Node parent = leafNodesQueue.poll();
			int newDepth = parent.depth+1;

			if (!depthNodes.containsKey(newDepth)) {
				depthNodes.put(newDepth, new ArrayList<Node>());
			}
			
			List<Node> newNodeList =  depthNodes.get(newDepth);
			
            int leftData = in.nextInt();
			Node leftNode = (leftData == -1) ? null : new Node(leftData, newDepth);
            if (leftNode != null) {
            	leafNodesQueue.add(leftNode);
            	newNodeList.add(leftNode);
            	maxDepth = newDepth;
            }
            
            int rightData = in.nextInt();
			Node rightNode = (rightData == -1) ? null : new Node(rightData, newDepth);
            if (rightNode != null) {
            	leafNodesQueue.add(rightNode);
            	newNodeList.add(rightNode);
            	maxDepth = newDepth;
            }
            
			parent.setNodes(leftNode, rightNode);
		}
		
		int S =  in.nextInt();
        
		for (int i=0; i<S; i++) {
            int s = in.nextInt();
            
            for (int k=1; k*s<=maxDepth; k++) {
            	List<Node> list = depthNodes.get(k*s);
            	for (Node myNode : list) {
            		myNode.swap();
            	}
            }
            StringBuilder sb = new StringBuilder();
            root.inorderTraversal(sb);
            System.out.println(sb.toString());
		}

		in.close();
	}
}
