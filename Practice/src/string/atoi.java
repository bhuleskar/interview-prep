package string;

public class atoi {

	public static int atoi(String str){
		if(str == null || str.length() < 1)
			return 0;
		
		//remove white space
		str = str.replaceAll(" ", "");
		System.out.println(str);
		char flag = '+';
		int i = 0;
		
		if(str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if(str.charAt(0) == '+') {
			flag = '+';
			i++;
		}
		
		
		double result = 0;
		
		while(i < str.length()) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				result = result * 10 + (str.charAt(i) - '0');
				i++;
			}
		}
		if (flag == '-')
			result = -result;
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int)result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(atoi("-123 34"));

	}

}
