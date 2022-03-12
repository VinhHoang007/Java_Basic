package TEST_STACK_QUEU;

import java.util.PriorityQueue;
import java.util.Queue;

public class QUEU {

	public static void main(String[] args) {
		Queue<Integer> numbers = new PriorityQueue<>();
		// Chèn phần tử vào Queue bằng phương thức offer
		numbers.offer(5);
		numbers.offer(1);
		numbers.offer(2);
		numbers.offer(4);
		System.out.println("Queue: " + numbers);
		int [] arr = new int[2];

		System.out.println("Truy cập phần tử: " + numbers.poll());
	
	}

}
