package string;

import org.junit.Assert;
import org.junit.Test;

public class Reverse {

	/*Given a string, return the string with the words reversed 
		"I am good" -> "good am I" 
	*/
	public static String reverseWords(String str) {
		if(str.length() == 0) return null;
		if(str == null) return null;
		
		StringBuilder builder = new StringBuilder();
		String[] tokens = str.split("[\\s]+");
		int i = tokens.length - 1;
		while(i >= 0) {
			builder.append(tokens[i]);
			builder.append(" ");
			i--;
		}
		builder.deleteCharAt(builder.length() - 1); //remove the last space
		System.out.println(builder.length());
		return builder.toString();
	}
	
	@Test
	public void testReverseWord(){
		Assert.assertEquals("good am I", reverseWords("I am good"));
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWords("I am good"));
		new Reverse().testReverseWord();
		

	}

}
