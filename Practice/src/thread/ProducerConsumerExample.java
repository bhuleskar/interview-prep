package thread;

import java.util.Random;

class Drop {
	private String message;
	private boolean empty = true;
	
	public synchronized String take() {
		// Wait until message is
        // available.
		while(empty) {
			try {
				wait();
			} catch(InterruptedException e){}
		}
		//toggle empty
		empty = true;
		// Notify producer that
        // status has changed.
        notifyAll();
        return message;
	}
	
	public synchronized void put(String str) {
		//wait until consumer consumes
		while(!empty) {
			try {
				wait();
			} catch(InterruptedException e){}
		}
		empty = false;
		// Store message.
        this.message = str;
        // Notify consumer that status
        // has changed.
        notifyAll();
	}
}

class Producer implements Runnable { 
	private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }
    
	@Override
	public void run() {
		String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };
	    Random random = new Random();

	    for (int i = 0;i < importantInfo.length; i++) {
	        drop.put(importantInfo[i]);
	        try {
	            Thread.sleep(random.nextInt(5000));
	         } catch (InterruptedException e) {}
	     }
	     drop.put("DONE");
	  }
}

class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumerExample {

	public static void main(String[] args) {
	   Drop drop = new Drop();
	  
       Thread t1 = new Thread(new Producer(drop));
       Thread t2 = new Thread(new Consumer(drop));
      
       t1.start();
       t2.start();
 
	}

}
