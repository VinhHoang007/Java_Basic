package ASSIGNMENT_DAY6_7;
//Cho chu��i �Hello World� v� Thay o tha�nh f
public class Assignment22_2_String {

	public static void main(String[] args) {

		String input = "Hello World";
		char [] arr = input.toCharArray();
		for (int i = 0; i < input.length(); i++) {
			if(arr[i]=='o') {
				arr[i] = 'f';
			}
//			input = input.replace('o', 'f');
		}
		String output= String.valueOf(arr);
		System.out.println(output);

	}
}
