package thread;

public class Letters implements Runnable {
	private String name;
	public Letters(String name) { 
		this.name = name;
	}
	
	public void write() {
		System.out.print(name);
		System.out.print(name);
	}
	
	public void run() { 
		synchronized(this) {
			write(); 
		} 
	}
	public static void main(String[] args) {
		Letters l = new Letters("X");
		Thread t1 = new Thread(l);
		Thread t2 = new Thread(l);
		t1.start();
	
		t2.start();
//		new Letters("X").start();
//		new Letters("Y").start();
	} 
}
