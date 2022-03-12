package ASSIGNMENT_DAY6_7;

import java.util.Scanner;

//Cho chuỗi “Hello” và chuỗi “World” và Hãy tạo thành chuỗi “ Hello World ”
//Nhập vào một String S, thực hiện công việc sau:
//a.       In ra màn hình String đảo ngược của S
//b.       Đổi toàn bộ kí tự của S sang chữ Hoa
//c.       Đổi toàn bộ kí tự của S sang chữ thường
//d.       Đưa ra bảng tần số xuất hiện của các kí tự trong S
//e.       Trích ra chuỗi con của S từ kí tự thứ n đến thứ m của S (n, m nhập từ bàn phím)

public class Assignment28_8_String {

	public static char[] reverse(String S) {

		char[] reverse = S.toCharArray();

		int i = 0;
		int j = S.length() - 1;
		char tmp;
		while (i < j) {

			tmp = reverse[i];
			reverse[i] = reverse[j];
			reverse[j] = tmp;
			i++;
			j--;
		}
		return reverse;
	}

	public static void displayHello() {
		String str1 = "Hello";
		String str2 = "World";
		String str3 = str1 + " " + str2;
		System.out.println(str3);
	}


	public static void frequency(String s) {
		int n = s.length();
		char [] arr = s.toCharArray();
		for (int i = 0; i < n; i++){
			boolean KT = true; 
			for (int j = i - 1; j >= 0; j--){
				if (arr[i] == arr[j])
				{
					KT = false;
					break;
				}
			}
			if (KT == true){
				
				int count = 0;
				for (int k = 0; k < n; k++){
					if (arr[i] == arr[k])
					{
						count++;
					}
				}
				System.out.println("Ky tu " + arr[i] + " xuat hien " + count + " lan");
			}
		}
		
	}
	public static void stringPrint(char[] s) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vi tri n");
		int n = scanner.nextInt();
		System.out.println("Nhap vi tri m");
		int m = scanner.nextInt();
		if(m>n && m <s.length ) {
			for(int i=n;i<=m;i++) {
				System.out.print(s[i]);
			}
		}else {
			System.out.println("Gia tri nhap vao khong dung");
		}
		
	}
	public static void main(String[] args) {
//======================= Xuat ra hello world====================================
//		displayHello();

//======================= Nhap vao string S=======================================
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao chuoi String:");
		String S = sc.nextLine();

//======================= In ra man hinh string dao nguoc S=======================
		System.out.println("========================Cau A========================");
//		char [] reverse = reverse(S);
//		System.out.println(reverse);

//======================= Doi toan bo ky tu S sang chu hoa========================
		System.out.println("========================Cau B========================");
//		System.out.println(S.toUpperCase());
		
//======================= Doi toan bo ky tu S sang chu thuong======================
		System.out.println("========================Cau C========================");
//		System.out.println(S.toLowerCase());
		
//==========================================================
		System.out.println("========================Cau D========================");
		frequency(S);
//==========================================================
		System.out.println("========================Cau E========================");
//		stringPrint(S.toCharArray());


	}

}
