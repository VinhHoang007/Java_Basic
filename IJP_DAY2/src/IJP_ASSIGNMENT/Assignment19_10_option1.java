package IJP_ASSIGNMENT;
//Cho các ví dụ về ép kiểu mà độ chính xác không bị thay đổi, như thứ tự bên dưới:
//	byte->short->int->long->float->double"
public class Assignment19_10_option1 {

	public static void main(String[] args) {
		
		byte i = 127;
		short j =i;
		int k = j;
        long l = k;    // không yêu cầu chỉ định ép kiểu
        float f = l;   // không yêu cầu chỉ định ép kiểu
        double m = f;
        System.out.println("Giá trị Byte: " + i);
        System.out.println("Giá trị Short: " + j);
        System.out.println("Giá trị Int: " + k);
        System.out.println("Giá trị Long: " + l);
        System.out.println("Giá trị Float: " + f);
        System.out.println("Giá trị Double: " + m);

	}

}
