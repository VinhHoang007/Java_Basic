package IJP_ASSIGNMENT;

//Tính giá trị của a:
//int i = 1; j = 1;
//a = i++ + j++;

public class Assignment11_6_option1 {
	public static void main(String[] args) {
		
		int i = 1, j = 1;
		int a = i++ + j++;
		// i = 1, j = 1
		// sau do i = 2, j =2
		System.out.println(a); // 1+1
	}

}
