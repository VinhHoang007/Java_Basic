package ASSIGNMENT_DAY6_7;

import java.util.ArrayList;
import java.util.Scanner;

//Viết hàm Xóa giá trị vị tại vị trí Z trong danh sách (Z nhập vào từ bàn phìm) và 
//hiển thị các giá trị trong danh sách (sử dụng hàm hiển thị ở câu 2)
public class Assignment15_5_Day7_opt1 {
	public static void deleteElement() {
		Assignment12_2_Day7_opt1 value = new Assignment12_2_Day7_opt1();
		ArrayList<Integer> removeElement = new ArrayList<Integer>();
		removeElement = value.inputArrayList();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vi tri muon xoa");
		int z = scanner.nextInt();
		
		removeElement.remove(z);
		System.out.println("Mang sau khi xoa: ");
		value.displayTest(removeElement);
		scanner.close();
	}
	public static void main(String[] args) {
		deleteElement();
	}

}
