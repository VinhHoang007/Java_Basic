package ASSIGNMENT_DAY6_7;
//Cho chuỗi “Hello World” và Đảo chuỗi thành dlroW olleH

public class Assignment27_7_String {

	public static void main(String[] args) {

		String str = "Hello World";

		char[] arr = str.toCharArray();
		
//		int i = 0;
//		int j = str.length() - 1;
//		char tmp;
//		while (i < j) {
//
//			tmp = reverse[i];
//			reverse[i] = reverse[j];
//			reverse[j] = tmp;
//			i++;
//			j--;
//		}
//		
//		System.out.print(reverse);
		char[] reverse = new char[arr.length];
		int count = 0;
		for(int i=arr.length-1;i>=0;i--) {
			reverse[count] = arr[i];
			count++;
		}
		String output = String.valueOf(reverse);
		System.out.println(output);

	}

}
