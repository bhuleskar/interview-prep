package fibonacci;

public class Fibonacci {

	/*
	 * print fibonacci for n numbers
	 */
	public static void printFibonacci(int n) {
		if(n < 1) {
			System.err.println("Cannot generate Fibonacci series");
			return;
		}
		if(n == 1) {
			System.out.println("1");
			return;
		}
		StringBuilder builder = new StringBuilder();
		int fibo1 = 1;
		int fibo2 = 1;
		builder.append(fibo1+" "+fibo2+" ");
		
		for(int i=3 ; i <=n ; i++) {
			int fibo = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibo;
			builder.append(fibo+ " ");
		}
		
		System.out.println(builder.toString());
	}

	public static int recursiveFibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) {
			
			return 1;
		}
		return recursiveFibonacci(n-1)+recursiveFibonacci(n-2);
		
	}
	public static void main(String[] args) {
		printFibonacci(0);
		System.out.println();
		 for (int i = 1; i <= 4; i++) {
	           System.out.print(recursiveFibonacci(i) + " ");
	       }

	}

}
