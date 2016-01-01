package string;

public class StringCombination {

	char[] array;
	boolean[] visited;
	String text = "ab";
	
	public static void main(String[] args) {
		StringCombination st= new StringCombination();
		st.printCombination("");
	}
	
	public StringCombination()
	{
		array = this.text.toCharArray();
		visited = new boolean[array.length];
	}
	
	
	public void printCombination(String val)
	{
		if(val != null && val.length()>0)
		{
			System.out.println(val);
		}
		
		for(int x = 0; x < text.length() ; x++)
		{
			if(visited[x] == false)
			{
				visited[x] = true;
				String val2 = text.charAt(x) + "";
				printCombination(val+val2);
				visited[x] = false;				
			}
		}		
	}
	
}

	


