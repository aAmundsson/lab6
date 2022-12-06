package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E>comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
  	@SuppressWarnings("unchecked")
	public BinarySearchTree() {
      root = null;
      size = 0;
      comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
  		}
  	
  	
  	
  	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
   public BinarySearchTree(Comparator<E> comparator) {
      root = null;
      size = 0;
      this.comparator = comparator;
   }
	
   public static void main(String[] args) {
	    BSTVisualizer canvas = new BSTVisualizer("Hello", 500 ,200);
	    BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
	    BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
	    
	    bst1.add(1);
	    bst1.add(3);
	    bst1.add(2);
	    
 		canvas.drawTree(bst1);
 		bst1.printTree();
 		
 	}


	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		 if ( root == null) {
			 root = new BinaryNode<E>(x);
			 size++;
			 return true;
		 }
		 return add(root, x);
	}
	
	 private boolean add(BinaryNode<E> n, E x) {	      
	      
	      int compResult = comparator.compare(x, n.element);
	      if (compResult == 0) {
	         return false;
	      } else if (compResult < 0) {
	    	 if(n.left==null) {
	    		 n.left = new BinaryNode<E>(x);
	    		 size++;
	    		 return true;
	    	 }
	    	 else{
	    		 return add(n.left, x);
	    	 }
	    	 
	      } else {
	    	 if(n.right == null) {
	    		 n.right = new BinaryNode<E>(x);
	    		 size++;
	    		 return true;
	    	 }
	    	 else {
	    		 return add(n.right, x);
	    	 }
	      }
	   }
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	private int height(BinaryNode<E> n) {
		if(n == null){
			return 0;
		}
		else {
			int left = 0, right = 0;  
			  
            if(n.left != null)  
                left = 1 + height(n.left);  
  
            //Calculate the height of right subtree  
            if(n.right != null)  
                right = 1 + height(n.right);  
  
            //Compare height of left subtree and right subtree  
            //and store maximum of two in variable max  
            int max = Math.max(left,  right);  
  
            //Calculate the total height of tree by adding height of root  
            return (max + 1);  
        }  
     }  
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryNode<E> n) {
		if (n != null) {
	        printTree(n.left);
	        System.out.println(n.element);
	        printTree(n.right);
	    }
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<E>();
		toArray(root, sorted);
		root = buildTree(sorted, 0, sorted.size()-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if(n!=null) {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first > last) {
			return null;
		}
		else {
			int mid = first + ((last-first)/2);
			BinaryNode<E> m = new BinaryNode<E>(sorted.get(mid));
			m.left = buildTree(sorted, first, mid-1);
			m.right = buildTree(sorted, mid + 1, last);
			return m;
		}
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
