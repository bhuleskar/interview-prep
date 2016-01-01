package string;

public class Substring {

	public static int substringCount(String source,String substring) {
		if(source == null  || source.length() == 0)
			return -1;
		if(substring == null) 
			return 0;
		if(source.length() < substring.length()) {
			System.err.println("Source < Substring");
			return -1;
		}
		
		char start_char = substring.charAt(0);
		int i = 0;
		int substringCount = 0;
		int lastOccurance = -1;
		
		while(i < source.length()){
			if(source.charAt(i) == start_char) {
				int lastIndex = i;
				int k = 1;
				i++;
				
				while(k < substring.length() && i < source.length()) {
					if(source.charAt(i) == substring.charAt(k)) {
						i++;
						k++;
					} else {
						break;
					}
				}
				if(k == substring.length()) {
					lastOccurance = lastIndex;
					substringCount++;
				}
			}else {
				i++;
			}
		}
		
		System.out.println("Last Occurance : " + lastOccurance);
		return substringCount;
	}
	
	
	public static void main(String[] args) {
		System.out.println(substringCount("Nishant Nishant Ni", "Nik"));

	}

}
