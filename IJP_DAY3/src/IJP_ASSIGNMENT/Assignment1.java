package IJP_ASSIGNMENT;

import java.util.Scanner;

//Viết chương trình Java để cho phép người dùng nhập tuổi của họ. 
//Sau đó chương trình sẽ hiển thị xem người đó có đủ điều kiện để bỏ phiếu hay không. 
//Người đủ điều kiện bầu cử phải lớn hơn hoặc bằng 18 tuổi
public class Assignment1 {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		System.out.println("Input age: ");
		int age = key.nextInt();
		
		if(age >=18) {
			System.out.println("Ban du dieu kien bau cu");
		}else {
			System.out.println("Ban khong du dieu kien bau cu");
		}
		key.close();
	}

}
