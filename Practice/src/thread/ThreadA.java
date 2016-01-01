package thread;

class ThreadA {
	public static void main(String [] args) {
		ThreadB b = new ThreadB();
		ThreadB b1 = new ThreadB();
		b.start();
		b1.start();
		
		synchronized(ThreadA.class) {
			try {
				System.out.println(Thread.currentThread().getName()+" Waiting for b to complete...");
				ThreadA.class.wait();
			
			} catch (InterruptedException e) {
				System.out.println("caught");
			}
			System.out.println("Total is: " + b.total);
		}
	}
 }

 class ThreadB extends Thread {
	 int total;
 	 public void run() {
 		 synchronized(this) {
	    	 System.out.println(Thread.currentThread().getName()+" counting total");
	    	 for(int i=0;i<10;i++) {
	    		 total += i;
	    	 }
	    	 try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 notify();
			 System.out.println(this.getName());
		  	}
	 
	  }
 }
