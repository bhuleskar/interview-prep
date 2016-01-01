package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BST {

	public static int sum = 0;
	
	public void levelOrderTraversal(Node root){
		if(root == null) return;
		Queue q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		int level = 0;
		
		while(!q.isEmpty()) {
			Node temp = (Node) q.poll();
			if(temp == null){
				if(q.isEmpty())
					return;
				else{
					q.add(null);
					level++;
					System.out.println();
				}
				
			} else {
				System.out.print(temp.data+"  ");
				if(temp.left!=null)q.add(temp.left);
				if(temp.right!= null)q.add(temp.right);
			}
		}
	}
	
	//print sum of all nodes excluding leaf nodes
	public int doSum(Node root){
		if(root == null) return 0;
		Queue q = new LinkedList<Node>();
		q.add(root);
		int sum = 0;
		
		while(!q.isEmpty()) {
			Node temp = (Node) q.poll();
			if(temp.left == null && temp.right == null) 
				continue;
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
			sum = sum + temp.data;
		}
		return sum;
	}
	
	public void preOrder(Node root){
		if(root == null) return;
		Stack<Node> stack = new Stack<Node>();
		
		while(true){
			while(root != null){
				System.out.print(root.data+" ");
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) break;  // break the outer while
			root = (Node)stack.pop();
			root = root.right;
		}
	}
	
	public void inOrder(Node root) {
		if(root == null) return;
		Stack<Node> stack = new Stack<Node>();
		
		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) break;
			root = (Node)stack.pop();
			System.out.print(root.data+" ");
			root = root.right;
		}
	}

	public void zigZagTraversal(Node root) {
		if(root == null) return;
		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		boolean leftToRight = true;
		
		currentLevel.push(root);
		while(!currentLevel.isEmpty()) {
			Node temp =(Node) currentLevel.pop();
			System.out.print(temp.data+" ");
			if(leftToRight) {
				if(temp.left != null) nextLevel.push(temp.left);
			    if(temp.right != null) nextLevel.push(temp.right);
			} else {
			    if(temp.right != null) nextLevel.push(temp.right);
			    if(temp.left != null) nextLevel.push(temp.left);
			}
			
			if(currentLevel.isEmpty()) {
				System.out.println();
				Stack tempStack;
				leftToRight = false;
				tempStack = nextLevel;
				nextLevel = currentLevel;
				currentLevel = tempStack;
			}
		}
	}

	public boolean isBST(Node root,int max,int min){
		if(root == null) return true;
		boolean leftBST = false;
		boolean rightBST = false;
		
		if(root.data < max && root.data > min) {
			leftBST = isBST(root.left, root.data, min);
			if(leftBST) {
				rightBST = isBST(root.right, max, root.data);
			}
		}
		return (leftBST && rightBST);
	}

	public boolean isBSTUsingInOrder(Node root) {
		if(root == null) return true;
		Stack<Node> stack = new Stack<Node>();
		
		while(true){
			while(root != null) {
				stack.push(root);
				int prev = root.data;
				root = root.left;
				if(root != null && root.data > prev) return false;
			}
			if(stack.isEmpty()) break;
			root = (Node)stack.pop();
			root = root.right;
		}
		return true;
	}

	public Node sortedArrayToBST(int[] a,int start,int end) {

		if (start > end) return null;
		if(start == end) return new Node(null,null,a[start]);
		
		int mid = start + (end-start)/2;
		Node root = new Node(null,null,a[mid]);
		root.left = sortedArrayToBST(a, start, mid-1);
		root.right = sortedArrayToBST(a, mid+1, end);
		
		return root;
		
	}

	public Node convertBSTtoDescendingOrder(Node root){
		if(root == null) return null;
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		convertBSTtoDescendingOrder(root.left);
		convertBSTtoDescendingOrder(root.right);
		
		return root;
		
	}
	
	/*
	 * Check whether a binary tree is a full binary tree or not.
	 * A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
	 * Conversely, there is no node in a full binary tree, which has one child node.
	 */
	public boolean isFullBST(Node root) {
		if(root == null) return true;
		
		if((root.left == null && root.right == null) || (root.left != null && root.right != null)) {
			return (isFullBST(root.left) && isFullBST(root.right));
		}
		
		return false;
		
	}
	
	/*
	 *Find sum of all left leaves in a given Binary Tree 
	 */
	public int sumofLeftLeaves(Node root){
		if(root == null) return 0;
		
		if(root.left != null && isleaf(root.left)) 
			sum = sum + root.left.data;
		sumofLeftLeaves(root.left);
		sumofLeftLeaves(root.right);
		
	return sum;
		
	}
	
	public boolean isleaf(Node root) { 
		return (root.left == null && root.right == null); 
	}
	
	public void printBSTRange(Node root,int k1,int k2) {
		if(root == null) return;
		if(root.data >= k1) 
			printBSTRange(root.left, k1, k2);
		if(root.data >= k1 && root.data <= k2)
			System.out.print(root.data+",");
		if(root.data <= k2) printBSTRange(root.right, k1, k2);
		return;
	}
	
	//The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node 
	//in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
	public Node LCA(Node n1,Node n2,Node root){
		if(root == null || n1 == null || n2 == null) 
			return null;
		
		while(root != null) {
			if(root.data == n1.data || root.data == n2.data || (n1.data < root.data && root.data < n2.data)) 
				return root;
			else if(root.data > n1.data && root.data > n2.data)
				root = root.left;
			else
				root = root.right;
		 }
		 return root;
	}

	//Assume both n1 and n2 are present in the tree
	public Node LCABT(Node n1,Node n2,Node root) {
		if(root == null) {
			return null;
		}
		
		if(root.data == n1.data || root.data == n2.data) 
			return root;
		
		Node lca_left = LCABT(n1, n2, root.left);
		Node lca_right = LCABT(n1, n2, root.right);
		
		if(lca_left != null && lca_right != null) return root;
		
		return (lca_left != null)? lca_left: lca_right;
	}
	
	/*
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
	 * that adding up all the values along the path equals the given sum.
	 */
	public boolean hasPathSum(Node root, int sum) {  
   		if (root == null) 
   			return false;  
   		if (root.left == null && root.right == null) // get to a leaf 
   			return (sum == root.data);  
   		
   		return hasPathSum(root.left, sum-root.data) || hasPathSum(root.right, sum-root.data);  
	 }
	
	//Find all paths that sum to ..
	 public ArrayList<ArrayList<Integer>> pathSum(Node root, int sum) {  
		   ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();  
		   findPathSum(root, sum, new ArrayList<Integer>(), resSet);  
		   return resSet;  
	 }
	 
	 private  void findPathSum(Node root,int sum,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> resSet){
		 
		 if (root == null) return;  
		 path.add(root.data);  
		 if (root.left == null && root.right == null) { // get to a leaf 
		    if (sum == root.data) { // found a path 
		     // has to make a copy, otherwise the content may be changed  
		       ArrayList<Integer> curPath = new ArrayList<Integer>(path);  
		       resSet.add(curPath);  
		     }  
		  }  
		  findPathSum(root.left, sum - root.data, path, resSet);  
		  findPathSum(root.right, sum - root.data, path, resSet);  
		  path.remove(path.size()-1);  
	 }
	
	 //Max depth of recursive solution is below. for the iterative solution use the level order traversal
	 public int maxDepth(Node root) {
		 if(root == null) 
			 return 0;
		
		 return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	 }
	 
	 public int minDepth(Node root) {
		 if(root == null) return 0;
		 return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	 }
	
	 //Given a binary search tree, design an algorithm which creates a linked list of all the nodes 
	 //  at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
	 public ArrayList<LinkedList<Node>> findLevelLinkList(Node root){
			if(root == null) return null;
			int level = 0;
			ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(root);
			
			result.add(level,list);
			list = new LinkedList<Node>();
			
			Queue q = new LinkedList<Node>();
			q.add(root);
			q.add(null);
			
			while(!q.isEmpty()) {
				
				Node temp = (Node) q.poll();
				if(temp == null){
					if(q.isEmpty())
						return result;
					else{
						q.add(null);
						level++;
						result.add(level,list);
						list = new LinkedList<Node>();
					}
					
				} else {
					if(temp.left != null) {
						q.add(temp.left);
						list.add(temp.left);
					}
					if(temp.right != null){
						q.add(temp.right);
						list.add(temp.right);
					}
				}
			}
			return result;
		}
	 
	 //algorithm to check if two trees are mirror of each other
	 public boolean areMirror(Node root1,Node root2){
		 if(root1 == null && root2 == null) return true;
		 if(root1 == null || root2 == null) return false;
		 
		 if(root1.data != root2.data) 
			 return false;
		 
		 return (areMirror(root1.left, root2.right) && areMirror(root1.right, root2.left));
	 }
	
	 
	 //Check if two trees are identical
	 ///* This function returns true if S is a subtree of T, otherwise false */
	 public boolean isSubtree(Node T,Node S) {
		 /* base cases */
		 if(S == null) return true;
		 if(T == null) return false;
		 
		 if(areIdentical(T, S)) return true;
		 
		 /* If the tree with root as current node doesn't match then
	       try left and right subtrees one by one */
		 return (isSubtree(T.left, S) || isSubtree(T.right, S));
	 }
	
	 	/* A utility function to check whether trees with roots as root1 and
	   root2 are identical or not */
	 private boolean areIdentical(Node root1,Node root2) {
		 /* base cases */
		 if(root1 == null && root2 == null) return true;
		 if(root1 == null || root2 == null) return false;
		 
		 /* Check if the data of both roots is same and data of left and right
	       subtrees are also same */
		 return root1.data == root2.data && areIdentical(root1.left, root2.left) 
				 && areIdentical(root1.right, root2.right);
		 
	 }
	 
	 /*
	 * http://www.careercup.com/question?id=14570776
	 */
	 
	/*  Merge Two Sorted Binary Serach trees into one BST
	 *  1) Do inorder traversal of first tree and store the traversal in one temp array arr1[]. 
	 * 		This step takes O(m) time.
		2) Do inorder traversal of second tree and store the traversal in another temp array arr2[]. 
			This step takes O(n) time.
		3) The arrays created in step 1 and 2 are sorted arrays. 
		    Merge the two sorted arrays into one array of size m + n. This step takes O(m+n) time.
		4) Construct a balanced tree from the merged array using the technique discussed in this post.
		    This step takes O(m+n) time.

		    Time complexity of this method is O(m+n) which is better than method 1.
		    This method takes O(m+n) time even if the input BSTs are not balanced.
	 */
}
