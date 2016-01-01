package general;

public class MyClass implements A,B {

	public static void main(String[] args) {
		A a = new MyClass();
		B b = new MyClass();
		a.show();
		b.show();
	}

	@Override
	public void show() {
		System.out.println("this method is from class Test:"); 
		System.out.println(this.getClass().getInterfaces()[0]); 
		System.out.println(this.getClass().getInterfaces()[1]); 
		
		
	}
	
	
}
