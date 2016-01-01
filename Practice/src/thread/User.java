package thread;

class Conference {
	
	public synchronized void bookRoom() {
		System.out.println(Thread.currentThread().getName()+" acquired the room");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" released the room");		
	}
}

public class User extends Thread {
	private Conference c;
	
	public User(Conference c) {
		this.c = c;
	}
	
	public static void main(String[] args) {
		Conference c = new Conference();
		User t1 = new User(c);
		User t2 = new User(c);
		
		t1.bookRoom();
		t2.bookRoom();
		
	}
	
	void bookRoom() {
		start();
	}
	
	public void run() {
		c.bookRoom();
	}

}