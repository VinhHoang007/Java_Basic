package ASSIGNMENT_DAY6_7;
//Viết hàm cập nhật giá trị vị tại vị trí Y trong danh sách (Y nhập vào từ bàn phìm) và 
//hiển thị các giá trị trong danh sách (sử dụng hàm hiển thị ở câu 2)
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment14_4_Day7_opt1 {
	
	public static void updateValue() {
		Assignment12_2_Day7_opt1 value = new Assignment12_2_Day7_opt1();
		ArrayList<Integer> setArrayList = new ArrayList<Integer>();
		setArrayList = value.inputArrayList();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vi tri muon thay doi: ");
		int y = scanner.nextInt();
		setArrayList.set(y, 1);
		System.out.println("Mang sau khi update:");
		value.displayTest(setArrayList);
		scanner.close();
	}
	public static void main(String[] args) {
		
		updateValue();
	}

}
