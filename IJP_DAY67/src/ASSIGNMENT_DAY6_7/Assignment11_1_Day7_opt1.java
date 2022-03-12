package ASSIGNMENT_DAY6_7;
//Viết đoạn chương trình tạo mới một danh sách chứa các giá trị kiểu chuỗi vào Danh sách 
//và hiển thị tất cả các giá trị trong danh sách;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment11_1_Day7_opt1 {
	
	public static void inputArrayList() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("So phan tu muon nhap: ");
		int n = scanner.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Nhap gia tri phan tu: ");
		for(int i=0;i<n;i++) {
			list.add(scanner.next());
		}
		System.out.println(list);
		scanner.close();
	}


	public static void main(String[] args) {
		
//		ArrayList list = new ArrayList();
//		list.add("Toyota");
//		list.add("Huyndai");
//		list.add("Honda");
//		System.out.println(list);
		inputArrayList();
	}

}
