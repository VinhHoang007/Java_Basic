package ASSIGNMENT_DAY10;

/*
Cho một mảng arr, nhiệm vụ của bạn là sắp xếp lại mảng arr theo các quy tắc sau:
Các số chẵn sẽ được chuyển lên đầu mảng vào được sắp xếp tăng dần.
Các số lẻ sẽ được chuyển về cuối mảng vào sắp xếp giảm dần.
Hãy viết hàm để thực hiện yêu cầu trên.
a. Sử dụng sắp xếp nổi bọt
b.sử dụng sắp xếp nhanh
*/
public class Assignment13_Day11 {
	// Ham sap xep ham le
	public static int[] bubbleSortOdd(int[] arr) {
		int n = arr.length;
		int temp;
		boolean is_sorted = false;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (arr[j - 1] < arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					is_sorted = false;

				}
				if (is_sorted) {
					break;
				}
			}
		}
		return arr;
	}

	// ham sap xep ham chan
	public static int[] bubbleSortEven(int[] arr) {
		int n = arr.length;
		int temp;
		boolean is_sorted = false;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					is_sorted = false;

				}
				if (is_sorted) {
					break;
				}
			}
		}
		return arr;
	}

	// Ham tao mang le
	public static int[] evenArray(int[] arr, int n) {
		int count = 0;
		int evenArr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				evenArr[count] = arr[i];
				count++;
			}
		}
		return evenArr;
	}

	// Ham tao mang le
	public static int[] Oddarray(int[] arr, int m) {
		int count = 0;
		int oddArr[] = new int[m];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				oddArr[count] = arr[i];
				count++;
			}
		}
		return oddArr;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 6, 7, 8, 25, 23, 26, 30 };
		int n = 0;// bien dem so chan
		int m = 0;// bien dem so le

		// Dem so chan, dem so le
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				n++;
			} else {
				m++;
			}
		}
		// Tao mang chan
		int[] arrEven = evenArray(arr, n);
		// Tao mang le
		int[] arrOdd = Oddarray(arr, m);
		// Sap xep mang chan
//		int[] bubbleSortEven = bubbleSortEven(arrEven);
		bubbleSortEven(arrEven);
		// Sap xep mang le
//		int[] bubbleSortOdd = bubbleSortOdd(arrOdd);
		bubbleSortOdd(arrOdd);

		// Ghep mang
		int[] merge = new int[arr.length];
		int count = 0;
		for (int i = 0; i < arrEven.length; i++) {
			merge[count] = arrEven[i];
			count++;
		}
		for (int i = 0; i < arrOdd.length; i++) {
			merge[count] = arrOdd[i];
			count++;
		}

		// Hien thi mang
		System.out.println("Mang ban dau");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}

		System.out.println();
		System.out.println("=========================");
		System.out.println("Mang sau khi bubble sort");
		for (int i = 0; i < merge.length; i++) {

			System.out.print(merge[i] + " ");
		}

	}

}
