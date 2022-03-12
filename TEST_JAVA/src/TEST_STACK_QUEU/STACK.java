package TEST_STACK_QUEU;


/*
Tính giá trị biểu thức: 4 5 - 3 2 / + 5 *
	4 5 / -1(4-5) 3 2 / -1 1(3/2)/ 0(-1+1) 5 / 0(0*5)
*/

import java.util.ArrayList;

public class STACK{

	public static void main(String[] args) {
		String[] arr = { "4", "5", "-", "3", "2", "/", "+", "5", "*" };
		String[] arr1 = { "2", "3", "4", "+", "*", "5", "-", "2", "2","*","+" };
		ArrayList operator = new ArrayList();
		operator.add("+");
		operator.add("-");
		operator.add("*");
		operator.add("/");

//		Stack<Integer> st = new Stack<Integer>();
//		int a,b;
//		for (int i = 0; i < arr[i].length(); i++) {
//			if (!operator.contains(arr[i])) {
//				st.push(Integer.parseInt(arr[i]));
//			} else {
//				if("+".equals(arr[i])) {
//					st.push( st.pop() + st.pop());
//				}else if("-".equals(arr[i])) {
//					a=st.pop();
//					b=st.pop();
//					st.push(b-a);
//				}else if("*".equals(arr[i])) {
//					a=st.pop();
//					b=st.pop();
//					st.push(b*a);
//				}else if("/".equals(arr[i])) {
//					a=st.pop();
//					b=st.pop();
//					st.push(b/a);
//				}
//			}
//		}
//		System.out.println(st.pop());

		
	}

}
