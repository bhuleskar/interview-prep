package exception;

import java.io.*;
class Master {
	String doFileStuff() throws IOException { return "a"; }
	}

public class Slave extends Master {
	public static void main(String[] args) {
		int x = 5, y = 5;
		System.out.println(++x);
		if(y++<6)
			System.out.println(y);
		
		String s = null;
		try { 
			s = new Slave().doFileStuff();
		} catch ( Exception xx) {
			s = "b";
		}
		System.out.println(s);
	}
	
	String doFileStuff() throws IOException {
		return "b";
	}
		
}