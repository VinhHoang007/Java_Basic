package IJP_ASSIGNMENT;

import java.util.Scanner;

//Viết chương trình Java để tính toán doanh thu từ việc bán hàng dựa trên đơn giá và số lượng sản phẩm mà người dùng nhập vào.
//Tỷ lệ chiết khấu là 10% cho số lượng mua từ 100 đến 120 chiếc và 15% cho số lượng mua lớn hơn 120 chiếc. 
//Nếu số lượng mua dưới 100 chiếc, mức chiết khấu là 0%
//Xem  ví dụ như hình dưới đây:
//Nhập đơn giá: 25
//Nhập số lượng: 110
//Doanh thu từ việc bán hàng: 2475,0 $
//Sau khi chiết khấu: 275.0 $ (10.0%)

public class Assignment4 {

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);
		System.out.print("Input price: ");
		double prices = key.nextDouble();
		System.out.print("Input number: ");
		double quantity = key.nextDouble();

		if (quantity < 100) {
			double revenue = prices * quantity;
			System.out.println("Chiet khau 0%");
			System.out.println("Doanh thu ban hanh: " + revenue + " $");
		} else if (quantity >= 100 && quantity <= 120) {
			double discount = prices * quantity * 0.1;
			double revenue = prices * quantity - discount;
			System.out.println("Chiet khau (10%): " + discount + " $");
			System.out.println("Doanh thu ban hang: " + revenue + " $");
		} else {

			double discount = prices * quantity * 0.15;
			double revenue = prices * quantity - discount;
			System.out.println("Chiet khau (15%): " + discount + " $");
			System.out.println("Doanh thu ban hang: " + revenue + " $");

		}
		key.close();

	}

}
