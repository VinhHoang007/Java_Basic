package ASSIGNMENT_DAY6_7;

//Cho chuỗi “Hello World” và Lấy ra chữ World
//substring Đây là phương thức dùng để lấy ra một xâu con dựa trên chỉ số bắt đầu 
//và chỉ số kết thúc của một xâu khác. name.substring(0,2)
public class Assignment21_1_String {

	public static void main(String[] args) {
		
		String input = "Hello World";
//		System.out.println(input.substring(input.indexOf("World")));
		
		for(int i= input.indexOf("W"); i < input.length() ; i++) {
			System.out.print(input.charAt(i));
		}
	}
}


