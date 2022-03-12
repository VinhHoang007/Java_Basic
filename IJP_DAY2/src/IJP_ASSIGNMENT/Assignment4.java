package IJP_ASSIGNMENT;

import java.util.Random;

//Viết chương trình Java để tạo một số ngẫu nhiên giữa 1 tới 6
public class Assignment4 {

	public static void main(String[] args) {
		
		Random generator = new Random();
		System.out.println(generator.nextInt(6)+1);
	}
}