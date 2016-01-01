package thread;

class MyThread extends Thread {
	public static void main(String [] args) {
		MyThread t = new MyThread();
		//Thread x = new Thread(t);
		t.start();
	}
 
	public void run() {
		for(int i=0;i<3;++i) {
			System.out.print(i + "..");
		} 
	} 
}


/*Thread class implements the Runnable interface; therefore, in
line 5, Thread can take an object of type Thread(MyThread) as an argument in the constructor (this is
NOT recommended).*/