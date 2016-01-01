package linkedList;

import java.util.HashMap;
import java.util.HashSet;

import array.MergeArrays;

public class SinglyLinkedList {

	private Node head;
	
	public void addNode(int data){
		Node newNode = new Node(data);
		if(this.head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	
	//with hashtable as a extra buffer
	public Node removeDuplicates(){
		if(head == null) return null;
		HashSet<Integer> set = new HashSet<Integer>();
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			if(set.contains(current.data)){
				previous.next = current.next;
			}else{
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		
		return head;
	}
	
	//without using extra buffer
	public Node removeDups() {
		if(head == null) 
			return null;
		Node previous = head.next;
		Node current = previous.next;
		
		while(current != null) {
			Node runner = head;
			while(runner != current) {
				if(runner.data == current.data) {
					Node temp = current.next;
					previous.next = temp;
					current = temp;
					break; //all other dups have already been removed
				}
				runner = runner.next;
			}
			if(runner == current) {
				previous = current;
				current = current.next;
			}
		}
		return head;
	}

	public void sortedInsert(int data) {
		
	}
	
	//Find kth node from end of link list
	public Node findKthfromEnd(int k){
		if(head == null) return null;
		Node ptr1 = head;
		Node ptr2 = head;
		
		for(int i=0 ; i<k ; i++) {
			if(ptr2 == null)return null; // k > n
			ptr2 = ptr2.next;
		}
		
		while(ptr2 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		return ptr1;
	}
	
	//Delete kth node from end of link list
	  public void deleteKthfromEnd(int k){
			if(head == null) return;
			Node ptr1 = head;
			Node ptr2 = head;
			Node previous = null;
			
			for(int i=0 ; i<k ; i++) {
				ptr2 = ptr2.next;
			}
			
			while(ptr2 != null) {
				previous = ptr1;
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			previous.next = ptr1.next;
			
		}
	
	public void  reverseList(){
		Node current = head;
		Node previous = null;
		Node next;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head =  previous;
	}
 	
	public void printList(){
		Node current = head;
		while(current != null) {
			System.out.print(current.data+"-->");
			current = current.next;
		}
	}
	
 	public void swap() {
 		if(head == null || head.next == null) return;
 		Node current = head.next;
 		Node prev = head;
 		head = current;
 		
 		while(true) {
 			Node temp = current.next;
 			current.next = prev;  // Change next of current as previous node
 			  
 			// If next NULL or next is the last node
 	        if (temp == null || temp.next == null)
 	        {
 	            prev.next = temp;
 	            break;
 	        }
 	        // Change next of previous to next next
 	        prev.next = temp.next; 
 	        
 	        //Update previous and next pointer
 			prev = temp;
 			current = prev.next;
 		}
 	}
 	
 	//Sum two list
 	public Node addTwoNumbers(Node l1, Node l2) {
        int carry =0;
  
         Node newHead = new Node(0);
         Node p1 = l1, p2 = l2, p3 = newHead;
  
         while(p1 != null || p2 != null){
             if(p1 != null){
                 carry += p1.data;
                 p1 = p1.next;
             }
  
             if(p2 != null){
                 carry += p2.data;
                 p2 = p2.next;
             }
  
             p3.next = new Node(carry%10);
             p3 = p3.next;
             carry /= 10;
         }
  
         if(carry == 1) 
             p3.next=new Node(1);
  
         return newHead.next;
     }
 	
 	//Merge link list with recusrion
 	public Node mergeList(Node head1,Node head2){
 		Node result = null;
 		if(head1 == null) return head2;
 		if(head2 == null) return head1;
 		
 		if(head1.data < head2.data) {
 			result = head1;
 			result.next = mergeList(head1.next, head2);
 		} else {
 			result = head2;
 			result.next = mergeList(head1, head2.next);
 		}
 		
 		return result;
 	}
 	
 	//Merge linklist without recursion
 	public Node mergeListIterative(Node head1,Node head2) {
 		Node result = new Node(0);
 		Node head3 = result;
 		
 		if(head1 == null) return head2;
 		if(head2 == null) return head1;
 		
 		while(head1 != null && head2 != null) {
 			if(head1.data <= head2.data) {
 				result.next = head1;
 				head1 = head1.next;
 			}
 			else  {
 				result.next = head2;
 				head2 = head2.next;
 			}
 			result = result.next;
 		}
 		
 		if(head1 != null) {
 			result.next = head1;
 			
 		}
 		if(head2 != null){
 			result.next = head2;
 		}
 		
 		return head3.next;
 	}
 	
 	public static void main(String[] args) {
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.addNode(7);
		list1.addNode(3);
		list1.addNode(2);
		list1.addNode(1);
		list1.printList();
		System.out.println();
 		
 		SinglyLinkedList list2 = new SinglyLinkedList();
 		list2.addNode(8);
 		list2.addNode(5);
 		list2.addNode(4);
 		list2.printList();
 		System.out.println();
 		
 		Node result = list1.mergeListIterative(list1.head, list2.head);
 		while(result != null) {
 			System.out.print(result.data+"->");
 			result = result.next;
 		}
 		
 		

 		
 		
 	

	}

}
