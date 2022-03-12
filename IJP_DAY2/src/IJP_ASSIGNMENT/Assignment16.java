package IJP_ASSIGNMENT;

public class Assignment16 {
	public static void main(String[] args) {
		
		int i = 1; 
		int j = 1;
		int a =++i + ++j + i++ + j++;
		// i = 2 j =2 i = 2 j = 2 
		//sau do  i = 2 j =2 i = 3 j = 3 
		System.out.println(a);
	
	}

}
