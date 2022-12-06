package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;


class TestBinarySearchTree {
	private BinarySearchTree<Integer> intTree;
	private BinarySearchTree<String> stringTree;
	

	@BeforeEach
	void setUp() throws Exception {
		intTree = new BinarySearchTree<Integer>();
		stringTree = new BinarySearchTree<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
	 intTree = null ;
	 stringTree=null;
	}

	@Test
	void testAdd() {
		intTree.add(1);
		intTree.add(3);
		intTree.add(9);
		intTree.add(4);
		
	}

}
