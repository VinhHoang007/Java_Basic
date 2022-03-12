package ASSIGNMENT_DAY9;

import java.util.Random;
import java.util.Scanner;

public class Assignment12 {
	public static void main(String[] args) {
		int randomIntNumbers[] = new int[10];
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
		    randomIntNumbers[i] = rand.nextInt(100);
		    
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Bạn muốn in ra phần tử mảng thứ mấy? ");
		int index = input.nextInt();
		System.out.println("OK, phần tử mảng thứ " + index + " mang giá trị " + randomIntNumbers[index]);


	}
}
