package hashing;

import java.util.HashMap;

public class HashCode {

	public static void main(String[] args) {
		HashMap<HashCode,Integer> map = new HashMap();
		
		for(int i=0 ; i<5 ; i++) {
			HashCode c = new HashCode();
			map.put(c, 1);
		}

		for(int i=0 ; i<5 ; i++) {
			HashCode c = new HashCode();
			map.put(c, 2);
		}

		for(int i=0 ; i<5 ; i++) {
			HashCode c = new HashCode();
			map.put(c, 3);
		}

		System.out.println("Done");
	}
	
	

}
