package hashing;

import java.util.HashMap;

public class Apple {

	
		private String color;
	 
		public Apple(String color) {
			this.color = color;
		}
	 
		public boolean equals(Object obj) {
			if (!(obj instanceof Apple))
				return false;	
			if (obj == this)
				return true;
			return this.color.equals(((Apple) obj).color);
		}
	 
//		public int hashCode(){
//			return this.color.length();	
//		}
		
		public static void main(String[] args) {
			Apple a1 = new Apple("green");
			Apple a2 = new Apple("red");
	 
			//hashMap stores apple type and its quantity
			HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
			m.put(a1, 10);
			m.put(a2, 20);
			int key = m.get(new Apple("der"));
			System.out.println(key);
		}
		
	}


