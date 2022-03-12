package ASSIGNMENT12;
//Cách đảo ngược một String bởi sử dụng Stack trong Java?
import java.util.Scanner;
import java.util.Stack;

public class Assignment2_Day12_op1 {

	public static void main(String[] args) {
		Stack<Character> st = new Stack<Character>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ky tu:");
		String n = scanner.nextLine();
		char[] ch= n.toCharArray();
		for(int i=0; i< ch.length; i++) {
			st.push(ch[i]);
		}
//		System.out.println(st);
		for(int i=0;i<ch.length;i++) {
			System.out.print(st.pop());
		}
		scanner.close();
	}

}
