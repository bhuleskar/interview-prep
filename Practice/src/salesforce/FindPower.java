package salesforce;

public class FindPower {

	public static int findPower(int n,int exp) {
		if(exp == 0) return 1;
		if(exp == 1) return n;
		
		int power = 1;
		
		for(int i=1 ; i<=exp ; i++) {
			power = power * n;
		}
		return power;
	}
	public static void main(String[] args) {
		System.out.println(findPower(5,2));

	}

}
