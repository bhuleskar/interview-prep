package tree;

public class BuildBST {

	/*
	 * http://stackoverflow.com/questions/13167536/how-to-construct-bst-given-post-order-traversal
	 */
	public Node BSTfromPostOrder(int[] array){
		if(array == null) return null;
		return recursiveBSTfromPostOrder(array, 0, array.length-1);
	}
	
	private Node recursiveBSTfromPostOrder(int[] array,int leftIndex,int rightIndex){
		if(leftIndex > rightIndex) return null;
		 // single node -> single element tree
		if(leftIndex == rightIndex) return new Node(null, null, array[leftIndex]);
		
		//construct root node
		int rootValue = array[rightIndex];
		Node root = new Node(null, null, rootValue);
		
		// It's supposed to be the post-order traversal of a BST, so
	    // * left child comes first
	    // * all values in the left child are smaller than the root value
	    // * all values in the right child are larger than the root value
	    // Hence we find the last index in the range [leftIndex .. rightIndex-1]
	    // that holds a value smaller than rootval
		int leftLast = findLastSmaller(array, leftIndex, rightIndex-1, rootValue);
		
		root.left = recursiveBSTfromPostOrder(array, leftIndex, leftLast);
		
		root.right = recursiveBSTfromPostOrder(array, leftLast+1, rightIndex-1);
		
		return root;
		
	}
	
	private int findLastSmaller(int[] array, int first, int last, int cut) {
		
		// If the segment is empty, or the first value is larger than cut,
	    // by the assumptions, there is no value smaller than cut in the segment,
	    // return the position one before the start of the segment
	    if (last < first || array[first] > cut) return first - 1;
	    int low = first, high = last, mid;
	    
	    while (low < high && array[high] > cut) {
	    	
	    	mid = low + (high-low+1)/2;
	    	if (array[mid] > cut) {
	    		 high = mid-1;
	    	} else {
	    		low = mid;
	    	}
	    }
	    return high;

	}
	
	public void postOrder(Node root){
		if (root != null)
		  {
		   postOrder(root.left);
		   postOrder(root.right);
		   System.out.print(root.data + " ");
		  }
	}
//      10
//     /  \
//    6    15
//   / \   / \
//  4   8 12 
// /        \
// 2          13
//			   \
//			   14
	
	public static void main(String[] args) {
		
//		Node r14 = new Node(null,null,14);
//		Node l2= new Node(null,null,2);
//		Node r13 = new Node(null,r14,13);
//		Node r12 = new Node(null,r13,12);
//		Node l4 = new Node(l2,null,4); 
//		Node l8 = new Node(null,null,8); 
//		Node l6 = new Node(l4,l8,6);
//		Node r15 = new Node(r12,null,15);
//		Node root = new Node(l6,r15,10);

		int[] array = {3,4,5,6,7,10,8,12,13,9};
		BuildBST bst = new BuildBST();
		Node root = bst.BSTfromPostOrder(array);
		BST b = new BST();
		System.out.println(b.isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}

}
