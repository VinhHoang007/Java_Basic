package ASSIGNMENT12;
public class Assignment7_3_Day12_opt2 {
	class Stack {
		private int stack[];
		private int top = -1;
		private int size;

//kiểm tra stack is full
		public boolean IsFull(int maxSize) {
			if (top >= maxSize - 1) {
				return true;
			}
			return false;
		}

		public Stack(int[] stack, int top, int size) {
			super();
			this.stack = stack;
			this.top = top;
			this.size = size;
		}

		// kiểm tra stack is empty
		public boolean IsEmpty() {
			if (top == -1) {
				return true;
			}
			return false;
		}

//push in stack
		public void push(int arr[], int maxSize, int value) {
			if (IsFull(maxSize) == true) {
				System.out.print("the stack is full");
			} else {
				top++;
				stack[top] = value;
			}
		}

//top()
		public int top(int stack[]) {
			return stack[top];
		}

//int size
		public int size() {
			return top + 1;
		}
	}
}