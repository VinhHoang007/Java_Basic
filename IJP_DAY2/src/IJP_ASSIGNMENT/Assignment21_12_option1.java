package IJP_ASSIGNMENT;
//Cho các ví dụ về ép kiểu mà độ chính xác  bị thay đổi, như thứ tự bên dưới:
//double -> float -> long -> int -> short -> byte	
public class Assignment21_12_option1 {

	public static void main(String[] args) {

		double a = 1234.56789;
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
