package fibonacci;

public class FibonacciGeneric {

	/*
	 * what every one knows is one Fibonacci series which adds the previous 2 numbers 
	 * i.e fib(n) = fib(n-1)+ fib(n-2). but there many Fibonacci series which adds the previous 2 numbers,
	 *  previous 3 numbers and so on. so write a function fib(n,k) which gives you first n numbers of a 
	 *  Fibonacci series and k is the number of previous numbers you have to add ex. for fib(n,3) you have
	 *   to add fib(n-1)+ fib(n-2)+ fib(n-3).


	 */
	public static void printFibonacci(int n,int k) {
		if(n < 1 || n < k) {
			System.err.println("Cannot generate Fibonacci series");
			return;
		}
		if(n == 3) {
			System.out.println("1 1 1");
			return;
		}
		StringBuilder builder = new StringBuilder();
		int fibo1 = 1;
		int fibo2 = 1;
		int fibo3 = 1;
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
		for (int i = 1; i <= 4; i++) {
	           System.out.print(recursiveFibonacci(i) + " ");
	       }

	}

}
