package ASSIGNMENT12;
//Tính giá trị biểu thức hậu tố: 2 3 4 + * 5 – 2 2 * +

import java.util.ArrayList;
import java.util.Stack;

/*
 2 3 4/ 2 7(3+4) / 14 5 / 9(14-5) 2 2/ 9 4(2*2)/ 13(9+4)
 */
public class Assignment6_2_Day12_opt2 {

	public static void main(String[] args) {
		String[] arr = { "2", "3", "4", "+", "*", "5", "-", "2", "2","*","+" };
		ArrayList<String> operator = new ArrayList<String>();
		operator.add("+");
		operator.add("-");
		operator.add("*");
		operator.add("/");

		Stack<Integer> st = new Stack<Integer>();
		int a,b;
		for (int i = 0; i < arr.length; i++) {
			if (!operator.contains(arr[i])) {
				st.push(Integer.parseInt(arr[i]));
			} else {
				if("+".equals(arr[i])) {
					a=st.pop();
					b=st.pop();
					st.push(b+a);
				}else if("-".equals(arr[i])) {
					a=st.pop();
					b=st.pop();
					st.push(b-a);
				}else if("*".equals(arr[i])) {
					a=st.pop();
					b=st.pop();
					st.push(b*a);
				}else if("/".equals(arr[i])) {
					a=st.pop();
					b=st.pop();
					st.push(b/a);
				}
			}
//			System.out.println(st);
		}
		System.out.println("Ket qua cua phep tinh: "+st.pop());

	}
	

}
