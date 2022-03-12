package ASSIGNMENT_DAY6_7;
//Viết hàm hiển thị tất cả các phần tử số nguyên có trong cả danh sách L1 và L2;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment20_5_Day7_opt2 {

	public static ArrayList<Integer> inputArrayList() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("So phan tu muon nhap: ");
		int n = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Nhap gia tri phan tu: ");
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		return list;
	}
	public static void checkPrint(ArrayList<Integer> L1, ArrayList<Integer> L2) {
		L1.retainAll(L2);
		System.out.println(L1);
	}

	public static void main(String[] args) {
		ArrayList<Integer> L1 = inputArrayList();
		ArrayList<Integer> L2 = inputArrayList();
		checkPrint(L1, L2);
		
	}

}
