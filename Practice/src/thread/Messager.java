package thread;

public class Messager implements Runnable {
	
		public static void main(String[] args) {
			new Thread(new Messager("Wallace")).start();
			new Thread(new Messager("Gromit")).start();
		}
		private String name;
		
		public Messager(String name) { this.name = name; }
		
		public void run() {
			message(1); 
			
			message(2);
		}
		
		private synchronized void message(int n) {
			
			System.out.print(name + "-" + n + " ");
		}
}