package IJP_ASSIGNMENT_DAY4;
/*Viết chương trình Java bằng cách sử dụng  vòng lặp for để in mẫu sau
*
**
***
****
*****
*/
public class Assignment1_Day4 {

	public static void main(String[] args) {
		
		for(int i = 1; i<=5; i++) {   // hang
			for(int j = 1; j<=i;j++) { // in sao trong hang
				System.out.print("*");			
			}
			System.out.println();
		}

	}
}
