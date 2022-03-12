package ASSIGNMENT_DAY10;


import java.util.Random;

/*
Cho một dãy số khoảng 1000000 kí tự số toàn 0 và 1. Biết rằng các số 0 đứng
trước các chữ số 1: 000....0011...11. Hãy cho biết vị trí của số 0 cuối cùng trong
dãy.
*/
public class Assignment12_5_Day10_op1 {
	
	public static int[] sortArray() {
		Random ran = new Random();
		int n = ran.nextInt(1000000);
		int[] arr = new int[1000000];

		for (int i = 0; i < n; i++) {
			arr[i] = 0;
		}
		for(int i=n;i<1000000;i++) {
			arr[i]=1;
		}
		return arr;
	}
	public static int findNumber(int []arr) {
		int left= 0;
		int right = arr.length-1;
		int middle;
		while(left<=right) {
			middle = left + (right - left) / 2;
			if(arr[middle]==0) {
				if(arr[middle+1]==1){
					return middle;
				}else {
					left = middle +1;
				}
			}else {
				if(arr[middle-1]==0) {
					return middle-1;
				}else {
					right=middle-1;
				}
			}
		}
			return -1;
		}


	public static void main(String[] args) {
		int arr[] = sortArray();

		System.out.println("Vi tri so 0 can tim: "+findNumber(arr));
	}

}
