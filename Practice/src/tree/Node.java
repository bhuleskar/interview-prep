package tree;

import queue.Queue;

public class Node {
	Node left;
	Node right;
	int data;
	
	public Node(Node left,Node right,int data){
		this.data = data;
		this.left = left;
		this.right = right;
		
	}
}
