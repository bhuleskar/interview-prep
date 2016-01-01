package thread;

import java.util.concurrent.locks.ReadWriteLock;
/*
 * Read more : http://tutorials.jenkov.com/java-concurrency/locks.html
 */
public class Counter{

	  private MyLock lock = new MyLock();
	  private int count = 0;

	  public int inc() throws InterruptedException{
	    lock.lock();
	    int newCount = ++count;
	    lock.unlock();
	    return newCount;
	  }
}

class MyLock {
	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {  //while loop handles Spurious wakeups
			wait();
		}
		isLocked = true;
	}
	
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}