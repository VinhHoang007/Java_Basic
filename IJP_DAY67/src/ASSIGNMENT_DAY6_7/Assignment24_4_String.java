package ASSIGNMENT_DAY6_7;
//Cho chuỗi “Hello World” và Cho biết vị trí xuất hiện đầu tiên và cuối cùng của chữ l
public class Assignment24_4_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello World";
		int n = s.length();
//		System.out.println(s.indexOf('l')); //vi tri dau tien
//		System.out.println(s.lastIndexOf('l')); // vi tri cuoi cung
		for(int i=0; i< n; i++) {
			if(s.charAt(i) == 'l') {
				System.out.println("Vi tri l dau tien: "+i);
				break;
			}
		}
		
		for(int i=n-1; i> 0; i--) {
			if(s.charAt(i) == 'l') {
				System.out.println("Vi tri l cuoi dung: " +i);
				break;
			}
		}
	}

}
