package queue;

public class Queue {

	int front;
	int rear;
	int[] storage;
	int maxSize;
	int currentSize;
	
	public Queue(){
		front = 0;
		rear = 0;
		maxSize = 5;
		storage = new int[maxSize];
		currentSize = 0;
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			System.err.println("Queue is Full");
			return;
		}
		rear = (rear + 1) % maxSize;
		storage[rear] = data;
		currentSize++;
		return;
		
	}
	
	public int deQueue(){
		if(!isEmpty()){
			front = (front + 1) % maxSize;
			int val = storage[front];
			currentSize--;
			return val;
		}
		System.err.println("Queue is Empty");
		return 0;
	}
	
	public boolean isEmpty(){
		if(currentSize == 0)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if(currentSize == maxSize) 
			return true;
		return false;
		
	}
	
	public void printQueue(){
		for(int i=0 ; i < this.storage.length ; i++) {
			System.out.print(this.storage[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		Queue myQueue = new Queue();
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.enQueue(4);
		myQueue.enQueue(5);
		System.out.println(myQueue.deQueue()+" ");
		myQueue.enQueue(6);
		
		myQueue.printQueue();
		System.out.println();
		System.out.print(myQueue.deQueue()+" ");
		System.out.print(myQueue.deQueue()+" ");
		System.out.print(myQueue.deQueue()+" ");
		System.out.print(myQueue.deQueue()+" ");
		System.out.print(myQueue.deQueue()+" ");
		
		

	}

}
