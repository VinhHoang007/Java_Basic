package ASSIGNMENT_DAY13;
//Tính giai thừa sử dụng đệ quy
public class Assignment2 {

	public static long factorial(int n) {
		if (n == 0) { // Điều kiện thoát khỏi đệ quy
			return 1;
		}
			return n * factorial(n - 1); // gọi đệ quy
	}

	public static void main(String[] args) {
		System.out.println("Factorial of 4 is: " + factorial(4)); // 120
	}
}
