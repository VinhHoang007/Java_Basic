package ASSIGNMENT12;

import java.util.Scanner;

public class Assignment8_4_Day12_opt2 {
	private int top = -1;
	private int capacity;
	private int[] collection;

	public Assignment8_4_Day12_opt2(int capacity) {
		this.capacity = capacity;
		this.collection = new int[capacity];
	}

	public boolean isFull() {
		// if (top >= capacity - 1) { return true; }
		// else { return false; }
		return top >= capacity - 1;
	}

	public boolean isEmpty() {
		// if (top == -1) { return true; }
		// else { return false; }
		return top == -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack is full. Overflow condition!");
		} else {
			++top;
			collection[top] = value;
		}
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty. Underflow condition!");
			return -1;
		} else {
			return collection[top--];
		}
	}

	public void RemoveAllElements() {
		top = -1;
	}

	public int top() {
		if (isEmpty()) {
			System.out.println("Stack is empty. Underflow condition!");
			return -1;
		} else {
			return collection[top];
		}
	}

	public int size() {
		return top + 1;
	}

	@Override
	public String toString() {
		String[] value = new String[size()];
		for (int i = 0; i < value.length; i++) {
			value[i] = String.valueOf(collection[i]); // ""+collection[i];
		}
		return "Stack [" + String.join(",", value) + "]";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao Capacity:");
		int n = scanner.nextInt();
		Assignment8_4_Day12_opt2 stack = new Assignment8_4_Day12_opt2(n);

		// pushing 10 element in the stack .
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.push(100);
		System.out.printf("Current size of stack is %d \n", stack.size());
		System.out.println(stack);

		for (int i = 0; i < n; i++) {

			stack.pop();
		}
		System.out.printf("Current size of stack is %d \n", stack.size());
		System.out.println(stack);
		scanner.close();

	}

}
