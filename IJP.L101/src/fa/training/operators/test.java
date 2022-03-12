
package fa.training.operators;
import java.util.Scanner;

public class test {


	public static int countEvenNumber(int[] arr, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	public static int[] createArrayEvenNumber(int[] arrA, int n) {

		int d = countEvenNumber(arrA, n);

		int[] arrB = new int[d];
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (arrA[i] % 2 == 0) {
				arrB[j] = arrA[i];
				j++;
			}
//	                System.out.print(arrB[i] + " ");
		}
		return arrB;
	}

	public static void main(String[] args) {
		ASSIGNMENT_DAY6_7.Assignment1 input = new ASSIGNMENT_DAY6_7.Assignment1();

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao so phan tu cua mang: ");
		int n = sc.nextInt();

		int[] arrA = new int[n];

		System.out.println("Nhap phan tu cua mang: ");
		input.inputArray(arrA, n);
		int d = countEvenNumber(arrA, n);
		int[] arrB = new int[d];
		arrB = createArrayEvenNumber(arrA, n);
	}

}
