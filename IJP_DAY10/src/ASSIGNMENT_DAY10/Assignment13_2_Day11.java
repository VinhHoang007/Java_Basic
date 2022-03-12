package ASSIGNMENT_DAY10;

import java.util.Scanner;

/*
Cho một mảng arr, nhiệm vụ của bạn là sắp xếp lại mảng arr theo các quy tắc sau:
Các số chẵn sẽ được chuyển lên đầu mảng vào được sắp xếp tăng dần.
Các số lẻ sẽ được chuyển về cuối mảng vào sắp xếp giảm dần.
Hãy viết hàm để thực hiện yêu cầu trên.

b.sử dụng sắp xếp nhanh
*/
public class Assignment13_2_Day11 {
	public static int[] input(Scanner scanner) {
		
		System.out.println("Nhap so phan tu cua mang");
		int n = scanner.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			;
		}

	}

	public static void quickSortIncrease(int[] arr, int left, int right) {
		if (left < right) {
			// tim vi tri low de chia mang
			int low = findPositionLowIncrease(arr, left, right);

			// goi de qui mang ben trai theo vi tri low
			quickSortIncrease(arr, left, low - 1);

			// goi de qui mang ben phai theo vi tri low
			quickSortIncrease(arr, low + 1, right);
		}

	}

	public static void quickSortDecrease(int[] arr, int left, int right) {
		if (left < right) {
			// tim vi tri low de chia mang
			int low = findPositionLowDecrease(arr, left, right);

			// goi de qui mang ben trai theo vi tri low
			quickSortDecrease(arr, left, low - 1);

			// goi de qui mang ben phai theo vi tri low
			quickSortDecrease(arr, low + 1, right);
		}

	}

	public static int findPositionLowIncrease(int[] arr, int left, int right) {
		int pivot = arr[right];
		int low = left;
		int high = right - 1;

		/*
		 * 1/ Neu nhu gia tri tai low < pivot thi cu tang low len 2/ Nguoc lai, xet gia
		 * tri cua high, neu >= pivot thi giam high xuong 3/ Nguoc lai cua 2 thang tren.
		 * Neu low < high thi hoan doi gia tri tai low va high. Neu low >= high thi
		 * thoat vong lap
		 */
		while (true) {
			if (arr[low] < pivot) {
				low++;
			} else if (high > 0 && arr[high] >= pivot) {
				high--;
			} else {
				if (low < high) {
					int temp = arr[low];
					arr[low] = arr[high];
					arr[high] = temp;
				} else {
					break;
				}
			}
		}

		// Hoan doi gia tri tai vi tri low va gia tri right
		int temp = arr[low];
		arr[low] = arr[right];
		arr[right] = temp;

		// Tra ve gia tri low dung de phan chia mang
		return low;
	}

	public static int findPositionLowDecrease(int[] arr, int left, int right) {
		int pivot = arr[right];
		int low = left;
		int high = right - 1;

		while (true) {
			if (arr[low] > pivot) {
				low++;
			} else if (high > 0 && arr[high] <= pivot) {
				high--;
			} else {
				if (low < high) {
					int temp = arr[low];
					arr[low] = arr[high];
					arr[high] = temp;
				} else {
					break;
				}
			}
		}

		// Hoan doi gia tri tai vi tri low va gia tri right
		int temp = arr[low];
		arr[low] = arr[right];
		arr[right] = temp;

		// Tra ve gia tri low dung de phan chia mang
		return low;
	}

	public static int[] count(int[] arr) {
		int odd = 0;
		int even = 0;
		int count[] = new int[2];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		count[0] = even;
		count[1] = odd;
		return count;
	}

	public static int[] oddArray(int arr[], int odd) {
		int oddArray[] = new int[odd];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				oddArray[count] = arr[i];
				count++;
			}
		}
		return oddArray;
	}

	public static int[] evenArray(int arr[], int even) {
		int evenArray[] = new int[even];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				evenArray[count] = arr[i];
				count++;
			}
		}
		return evenArray;
	}

	public static void merge(int[] arr, int[] evenArray, int[] oddArray) {
		int count =0;
		for (int i = 0; i < evenArray.length; i++) {
			arr[count] = evenArray[i];
			count++;
		}
		for (int j = 0; j < oddArray.length; j++) {
			arr[count] = oddArray[j];
			count++;
		}
		display(arr);
	}

	public static void main(String[] args) {
		// Nhap mang
//		Scanner scanner = new Scanner(System.in);
//		int arr[] = input(scanner);
		
		int[] arr = { 1, 5, 3, 6, 12, 645, 2, 43, 11 };
		// Dem so phan tu chan
		int evenCount = count(arr)[0];
		// Dem so phan tu le
		int oddCount = count(arr)[1];
		// Khoi tao mang chan
		int evenArray[] = evenArray(arr, evenCount);
		// Khoi tao mang le
		int oddArray[] = oddArray(arr, oddCount);
		// Mang chan sap xep theo quicksort tang dan
		quickSortIncrease(evenArray, 0, evenArray.length - 1);
//		display(evenArray);
		System.out.println();
		// Mang le sap xep theo quicksort giam dan
		quickSortDecrease(oddArray, 0, oddArray.length - 1);
//		display(oddArray);
		System.out.println();
		// Noi va xuat mang
		merge(arr, evenArray, oddArray);

	}

}
