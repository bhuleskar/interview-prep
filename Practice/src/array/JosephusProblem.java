package array;

public class JosephusProblem {
	public int PrintLastAfterDeletingThird(int[] arr){
		int j,k = arr.length+1, n = 0,N = 0,Tcount = 0, temp = arr.length;
		int[] indexArr=new int[temp];
		for(int index=0; index<temp;index++){
			indexArr[index]=index;
		}
		while(true){
			j=0;
			int len=temp-Tcount;
			N=n;
			if(len==2){
				if(n==0){
					System.out.println("Index is: "+indexArr[1]);
					return arr[1];
				}
				else{
					System.out.println("Index is: "+indexArr[0]);
					return arr[0];
				}
			}
			for(int i=0;i<len;i++){
				if(((i+N)%3)!=2){
					arr[j]=arr[i];
					indexArr[j]=indexArr[i];
					j++;
				}
				else{
					k=i;
					n=len-k-1;
					Tcount++;
					if(Tcount==temp-1){
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		JosephusProblem jp=new JosephusProblem();
		int[] a = new int[]{1,7,6,5,4,3,2,1,0};
		int b = jp.PrintLastAfterDeletingThird(a);
		System.out.println(b);
	}
}
