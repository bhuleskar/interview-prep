package linkedList;

public class CircularLinkedList {

	private Node head;
	
	public void sortedInsert(int data) {
		Node newNode = new Node(data);
		Node current = head;
	
		if(head == null) {
			newNode.next = newNode;
			head = newNode;
			return;
		} else if(data <= head.data) {          // if newNode value is smaller than head
			while(current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
			head = newNode;
		} else {
			while(current.next != head && current.next.data < newNode.data) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		
	}
	
	public void printList(){
		Node current = head.next;
		System.out.print(head.data+"-->");
		while(current != head) {
			System.out.print(current.data+"-->");
			current = current.next;
			if(current == head) break;
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedList list1 = new CircularLinkedList();
		list1.sortedInsert(6);
		list1.sortedInsert(2);
		list1.sortedInsert(4);
		list1.sortedInsert(3);
		list1.sortedInsert(1);
		list1.sortedInsert(5);
		list1.sortedInsert(3);
		list1.printList();
		

	}

}
