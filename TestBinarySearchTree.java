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
		assertTrue(intTree.add(2));
		assertFalse(intTree.add(2));
		
	}
	
	@Test
	void testHeight() {
		intTree.add(5);
		intTree.add(2);
		intTree.add(3);
		intTree.add(6);
		intTree.add(8);
		intTree.add(7);
		

		assertEquals(intTree.height(), 3);
	}
	
	@Test
	void testSize() {
		intTree.add(1);
		intTree.add(3);
		intTree.add(9);
		intTree.add(4);
		assertEquals(intTree.size(), 4);
	}
	
	@Test
	void testClear() {
		intTree.add(1);
		intTree.add(3);
		intTree.add(9);
		intTree.add(4);
		intTree.clear();
		assertTrue(intTree.height() == 0);
		assertTrue(intTree.size() == 0);
		
	}

}
