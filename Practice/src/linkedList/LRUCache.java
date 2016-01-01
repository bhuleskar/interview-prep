package linkedList;

import java.util.HashMap;

public class LRUCache {
	private HashMap<Integer, DoublyNode> cache;
	private DoublyNode leastRecentlyUsed;
	private DoublyNode mostRecentlyUsed;
	private int maxSize;
	private int currentSize;
	
	public LRUCache(int maxSize){
		 this.maxSize = maxSize;
	     this.currentSize = 0;
	     leastRecentlyUsed = new DoublyNode(null, null, 0, 0);
	     mostRecentlyUsed = leastRecentlyUsed;
	     cache = new HashMap<Integer, DoublyNode>();
	}
	
	public int get(int key){
		 DoublyNode tempNode = cache.get(key);
	     if (tempNode == null){
	    	 return -1;
	     }
	  
	     // If MRU leave the list as it is
	     else if (tempNode.key == mostRecentlyUsed.key) {
	    	 return mostRecentlyUsed.value;
	     }
	     
	     // Get the next and previous nodes
	     DoublyNode nextNode = tempNode.next;
	     DoublyNode previousNode = tempNode.previous;
	     
	     // If at the left-most, we update LRU 
	     if (tempNode.key == leastRecentlyUsed.key){
	        nextNode.previous = null;
	        leastRecentlyUsed = nextNode;
	     }
	     
	     // If we are in the middle, we need to update the items before and after our item
	     else if (tempNode.key != mostRecentlyUsed.key){
	    	 previousNode.next = nextNode;
	         nextNode.previous = previousNode;
	     }
	     
	     // Finally move our item to the MRU
	     tempNode.previous = mostRecentlyUsed;
	     mostRecentlyUsed.next = tempNode;
	     mostRecentlyUsed = tempNode;
	     mostRecentlyUsed.next = null;

	     return tempNode.value;
		
	}
	public void put(int key,int value){
		if(cache.containsKey(key)){
			return;
		}
		// Put the new node at the right-most end of the linked-list
		DoublyNode newNode = new DoublyNode(mostRecentlyUsed,null,key,value);
		mostRecentlyUsed.next = newNode;
		cache.put(key, newNode);
		mostRecentlyUsed = newNode;
		currentSize++;
		
		// Delete the left-most entry and update the LRU pointer
        if (currentSize == maxSize){
            cache.remove(leastRecentlyUsed.key);
            leastRecentlyUsed = leastRecentlyUsed.next;
            leastRecentlyUsed.previous = null;
        }
	}
}

class DoublyNode {
	DoublyNode previous;
	DoublyNode next;
	int key,value;
	
	// Define Node with pointers to the previous and next items and a key, value pair
	public DoublyNode(DoublyNode prev,DoublyNode next,int key, int val) {
		this.previous = prev;
		this.next = next;
		value = val;
		this.key = key;
	}
}