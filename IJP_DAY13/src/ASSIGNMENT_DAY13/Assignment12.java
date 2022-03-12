package ASSIGNMENT_DAY13;
//S = 1+1/3!+1/5!+…..+1/(2n-1)!
public class Assignment12 {
	
	public static double factorial(Double n) {
		if (n == 1) { // Điều kiện thoát khỏi đệ quy
			return 1;
		}
			return n * factorial(n - 1); // gọi đệ quy
	}
	public static double sum(double n) {
		if (n == 1) { // Điều kiện thoát khỏi đệ quy
			return 1;
		}
			return 1/factorial(2*n-1)+sum(n-1); // gọi đệ quy
	}

	public static void main(String[] args) {
		System.out.println(sum(5)); 
	}

}
