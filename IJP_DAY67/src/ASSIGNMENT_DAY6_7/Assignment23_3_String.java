package ASSIGNMENT_DAY6_7;
//Cho chuỗi “Hello World” và Đếm xem có bao nhiêu chữ l
public class Assignment23_3_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "Hello World";
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'l') {
				count++;
			}
		}
		System.out.print(count);

	}

}
