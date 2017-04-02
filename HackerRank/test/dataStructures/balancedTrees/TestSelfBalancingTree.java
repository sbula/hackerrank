package dataStructures.balancedTrees;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSelfBalancingTree {
	@Test
	public void test() {
		SelfBalancingTree.Node root = createNode(3, 2);
		root.left = createNode(2, 0);
		root.right = createNode(4, 1);
		root.right.right = createNode(5, 0);
		
		root = SelfBalancingTree.insert(root, 6);
		
		fail("Not yet implemented");
	}

	@Test
	public void test2() {
		SelfBalancingTree.Node root = createNode(5, 1);
		root.left = createNode(3, 0);
		
		root = SelfBalancingTree.insert(root, 4);
		
		fail("Not yet implemented");
	}

	@Test
	public void test3() {
		SelfBalancingTree.Node root = createNode(3, 1);
		root.right = createNode(5, 0);
		
		root = SelfBalancingTree.insert(root, 4);
		
		fail("Not yet implemented");
	}

	
	private SelfBalancingTree.Node createNode(int val, int height) {
		SelfBalancingTree.Node root = new SelfBalancingTree.Node();
		root.val = val;
		root.ht = height;
		return root;
	}
}
