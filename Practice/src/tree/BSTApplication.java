package tree;

import java.util.ArrayList;
import java.util.LinkedList;

import org.omg.PortableInterceptor.INACTIVE;

public class BSTApplication {

//	     10
//	    /  \
//	   6    15
//	  / \   / 
//	 4   8 12 
//	/        \
// 2          13
//				\
//				14
    	
	
	public static void main(String[] args) {
		
		Node r14 = new Node(null,null,14);
		Node l2= new Node(null,null,2);
		Node r13 = new Node(null,r14,13);
		Node r12 = new Node(null,r13,12);
		Node l4 = new Node(l2,null,4); 
		Node l8 = new Node(null,null,8); 
		Node l6 = new Node(l4,l8,6);
		Node r15 = new Node(r12,null,15);
		Node root = new Node(l6,r15,10);
		
		BST bst = new BST();
//		System.out.println("Level Order Traversal");
//		bst.levelOrderTraversal(root);
//		System.out.println();
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("PreOrder Traversal");
//		bst.preOrder(root);
//		System.out.println();
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("InOrder Traversal");
//		bst.inOrder(root);
//		System.out.println();
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("ZigZag Traversal");
//		bst.zigZagTraversal(root);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("Is Tree is BST?");
//		System.out.println(bst.isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("Is Tree is BST using InOrder traversal?");
//		System.out.println(bst.isBSTUsingInOrder(root));
//		
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("Sorted Array To BST");
//		int[] a = {2,4,6,8,10,12,14,16};
//		Node myRoot = bst.sortedArrayToBST(a, 0, a.length-1);
//		bst.inOrder(myRoot);
//		
//		System.out.println();
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("Descending order");
//		
//		Node reverseBST = bst.convertBSTtoDescendingOrder(root);
//		bst.inOrder(reverseBST);
//		
//		System.out.println();
//		System.out.println("~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("Is BST is Full BST?");
//		System.out.println(bst.isFullBST(null));
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Sum of all left leaves");
		int sum=0;
		System.out.println(bst.sumofLeftLeaves(root));
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Print all nodes withing the range 13 and 15");
		bst.printBSTRange(root, 13, 15);
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("LCA of BST. Node 2 & 4");
		System.out.println(bst.LCA(l2, l4, root).data);
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("LCA of BT. Node 4 & 8");
		System.out.println(bst.LCABT(l4, l8, root).data);
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Find a Path. sum = 22");
		System.out.println(bst.hasPathSum(root, 22));
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Find all Path. sum = 22");
		System.out.println(bst.pathSum(root, 22));
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Max Depth of a tree. Recursive");
		System.out.println(bst.maxDepth(root));
		
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Min Depth of a tree. Recursive");
		System.out.println(bst.minDepth(root));
		
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("LinkList at each level of the tree");
		ArrayList<LinkedList<Node>> result = bst.findLevelLinkList(root);
		for(int i = 0; i < result.size(); i++) {
		   for(Node n : result.get(i)) {
			   System.out.print(n.data+" ");
		   }
		   System.out.println();
		}
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("sum of all nodes excluding leaves");
		System.out.println(bst.doSum(root));
		
		
	}

}
