package ASSIGNMENT_DAY10;

/*
Cho một mảng nums đã được sắp xếp tăng dần và một số nguyên target, trả về chỉ số nếu có giá trị đó trong mảng.
Nếu không, hãy trả về chỉ số vị trí mà nếu chèn vào mảng đó, mảng vẫn giữ nguyên tính chất tăng dần. 
Biết trong mảng không có phần tử nào trùng lặp.

*/
import java.util.Scanner;

//Tìm chử số đầu tiên của số nguyên duong n
public class Assignment11_Day10_5_opt2 {
	public static int findNumber(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;
		int middle;
		while (left <= right) {
			middle = (left + right) / 2;
			if (x > arr[middle]) {
				left = middle + 1;
			} else if (x < arr[middle]) {
				right = middle - 1;
			} else {
				return middle;
			}
		}
		if (arr[left] >= x) {
			return left;
		}
		return 0;

	}

	public static int[] input(Scanner scanner) {
		
		System.out.println("Nhap vao n:");
		int n = scanner.nextInt();
		int arr[] = new int[n];
		System.out.println("Nhap vao cac phan tu: ");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		return arr;
	}

	public static int[] sortArray(int[] arr) {
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
	public static void display(int [] arr) {
		for(int i=0; i< arr.length;i++) {
			System.out.println("a[" + i+"] = " + arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[] = sortArray(input(scanner));
		System.out.println("Nhap vao gia tri X");
		int x = scanner.nextInt();
		
		System.out.println("Mang sau khi sap xep");
		display(arr);
		
		int answer = findNumber(arr, x);
		System.out.println("Vi tri cua phan tu >= X");
		System.out.println(answer);
		scanner.close();

	}

}
