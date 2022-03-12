package IJP_ASSIGNMENT;

import java.util.Scanner;

//Chương trình sẽ đọc ba loại điểm (bài kiểm tra, điểm giữa kỳ và cuối kỳ) và xác định điểm dựa trên các quy tắc sau:
//	-nếu điểm trung bình> = 90% => điểm = A
//	-nếu điểm trung bình> = 70% và <90% => điểm = B
//	-nếu điểm trung bình> = 50% và <70% => điểm = C
//	-nếu điểm trung bình <50% => lớp = F
public class Assignment3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Intput bai kiem tra: ");
		double assign = sc.nextDouble();
		System.out.println("Input diem giua ky: ");
		double middleScore = sc.nextDouble();
		System.out.println("Input diem cuoi ky: ");
		double finalScore = sc.nextDouble();
		double avg = (assign + middleScore + finalScore) / 3;
		if (avg >= 9) {
			System.out.println("Xep loai: A");
		} else if (avg >= 7) {
			System.out.println("Xep loai: B");

		} else if (avg >= 5) {
			System.out.println("Xep loai: C");
		} else {
			System.out.println("Xep loai: F");
		}
		sc.close();
	}

}
