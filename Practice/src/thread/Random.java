package thread;

public class Random extends Thread {

	
	public static int n  = 0;
	public static void main(String[] args) {
		
		Random r1 = new Random();
		Random r2 = new Random();
		r1.start();
		r2.start();

	}
	
	public void run() {
		
		for(int i=0;i<100;i++) {
			n++;
		}
		System.out.println(n);
	}

}
