package IJP_ASSIGNMENT;
//Cho các ví dụ về ép kiểu mà độ chính xác không bị thay đổi, như thứ tự bên dưới:
public class Assignment20_11_option1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 123.00;
		float b = (float)a;
		long c = (long) b;
		int d = (int) c;
		short e = (short) d;
		byte f = (byte) e;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}

}
