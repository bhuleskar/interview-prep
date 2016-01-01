package string;

public class AlphaNumeric {

	//1ABC34D768(1+34+768)
	public static void main(String[] args) {
		String str = "1ABC34D768";
		int sum = 0;
		String[] tokens = str.split("[a-zA-Z]+");
		for(int i=0 ;i<tokens.length;i++) {
			int num = stringToInt(tokens[i]);
			sum = sum + num;
		}
		System.out.println(sum);

	}
	
	private static int stringToInt(String str){
		int result = 0;
		for(int i=0 ; i<str.length() ; i++){
			int number = str.charAt(i) - '0';
			result = result*10 + number;
		}
		
		return result;
	}

}
