package IJP_ASSIGNMENT_DAY4;

import java.util.Scanner;

//In daŞy sôì 1, 3, 5, 7, 9 … n (n laÌ sôì nhâòp vaÌo tıÌ baÌn phiìm)
public class Assignment4_Day4 {
	
	public static void main(String[] args) {
		
		System.out.print("Nhap vao n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			if(i%2 !=0) {
				System.out.print(i + " ");				
			}
		}
//		System.out.print(n);
		sc.close();
	}
		
}
