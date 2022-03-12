package ASSIGNMENT12;
/*
Tính giá trị biểu thức: 4 5 - 3 2 / + 5 *
	4 5 / -1(4-5) 3 2 / -1 1(3/2)/ 0(-1+1) 5 / 0(0*5)
*/

import java.util.ArrayList;
import java.util.Stack;

public class Assignment3_Day12_op1 {

	public static void main(String[] args) {
		String[] arr = { "4", "5", "-", "3", "2", "/", "+", "5", "*" };
		
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
