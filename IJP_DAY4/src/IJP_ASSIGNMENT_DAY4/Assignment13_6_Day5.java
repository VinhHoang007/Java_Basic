package IJP_ASSIGNMENT_DAY4;
//S = 1+1/3!+1/5!+…..+1/(2n-1)!
import java.util.Scanner;

public class Assignment13_6_Day5 {

	public static void main(String[] args) {
		int n;
		do {
			System.out.print("Input n:");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			sc.close();
		} while (n < 1/2);
		
		double s = 0;
		int mauSo = 1;
		for(int i = 1; i <=n ; i= i+2) { // i = 1 , 3 ,5 ,7
			for(int j=1; j<=i ; j++) {
				mauSo *=j;  //1.2.3...i
			}
			s +=1.0/mauSo;
			mauSo = 1;      // dam bao mau nhan tu 1 den i
		}
		System.out.println(s);
	}

}
