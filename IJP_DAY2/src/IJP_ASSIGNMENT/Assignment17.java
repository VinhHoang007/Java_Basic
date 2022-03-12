package IJP_ASSIGNMENT;

public class Assignment17 {
	public static void main(String[] args) {
	
		int i = 1;
		int a = i++ + ++i - i-- - --i;
		// i = 1 i = 3 i = 3 i = 1
		System.out.println(a);
	}
	


}
