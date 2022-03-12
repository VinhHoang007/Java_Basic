package ASSIGNMENT12;

public class BuildQueu {

	private int arraySize;
	private int front;
	private int rear;
	private int[] collection;

	public BuildQueu(int arraySize) {

		this.arraySize = arraySize;

		this.collection = new int[arraySize];
	}

	public boolean isFull() {
		return rear == arraySize - 1;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void add(int value) {
		if (isFull()) {
			System.out.println("OverFlow\n");
		} else {
			collection[rear] = value;
			rear++;
		}

	}

	public int remove() {
		if (isEmpty()) {
			System.out.println("UnderFlow\n");
			return -1;
		} else {
			return collection[front++];
		}

	}
	public int element() {
        if (isEmpty()) {
            System.out.println("Queu is empty. Underflow condition!");
            return -1; 
        } else {
            return collection[front];
        }
	}
    public int size() {
        return rear + 1;
    }
	@Override
    public String toString() {
        String[] value = new String[size()];
        for (int i = 0; i < value.length; i++) {
            value[i] = String.valueOf(collection[i]); // ""+collection[i];
        }
        return "Queu [" + String.join(",", value) + "]";
    }
	

	public static void main(String[] args) {
		BuildQueu queu = new BuildQueu(5);
		queu.add(1);
		queu.add(2);
		queu.add(3);
		queu.add(4);
		queu.remove();
		System.out.println(queu);
	}

}
