package IJP_ASSIGNMENT_DAY4;
import java.util.Scanner;

//In da�y s�� 2, 4, -6, 8, 10, -12 � n (b��ng i�t nh��t 2 ca�ch kha�c nhau) (n la� s�� nh��p va�o t�� ba�n phi�m)
public class Assignment6_2_Day4 {

	public static void main(String[] args) {
		System.out.print("Input n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for(int i = 2; i<=n; i+=2) {
			count++;
			if(count  == 3) {
			System.out.print(-i + " ");
			count = 0;
			}else {
			System.out.print(i + " ");
			}
		}
		sc.close();
	}
}