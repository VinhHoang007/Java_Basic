package IJP_ASSIGNMENT_DAY4;

/*
1******
12*****
123****
1234***
12345**
123456*
1234567
*/
public class Assignment2_Day4 {

	public static void result() {
		for (int i = 1; i <= 7; i++) { // chay theo hang, in ra so hang
			for (int j = 1; j <= i; j++) { // in ra so trong hang
				System.out.print(j);
			}
			for (int j = i; j < 7; j++) { // in ra so * con lai trong hang
				System.out.print("*");
			}
			System.out.println(); // xuong dong
		}
	}

	public static void main(String[] args) {

		result();
	}

}
