import java.util.ArrayList;

public class Assignment_Test {

	public static void main(String[] args) {

//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

//		try {
//			ArrayList<SinhVien> a = new ArrayList<SinhVien>();
//			SinhVien sv = new SinhVien();
//			a.add(sv);
//			SinhVien svout = a.get(0);
//			System.out.println(a.get(0).getHoTen().toString());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		Scanner input = new Scanner(System.in);
//		Integer intNumber = null;
//		         
//		try {
//		    System.out.println("Hãy nhập vào một số nguyên: ");
//		    String strNumber = input.nextLine();
//		    intNumber = new Integer(strNumber);
//		} catch (NumberFormatException e) {
//		    System.out.println("Vui lòng nhập vào một số nguyên");
//		}
//		         
//		System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));
//		try {
//			String s = null;
//			System.out.println(s.length());
//
//		} catch (NullPointerException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			int num1 = 30, num2 = 0;
//			int output = num1 / num2;
//			System.out.println("Result: " + output);
//
//			int a[] = new int[10];
//			// Array has only 10 elements
//			a[11] = 9;
//
//			int num = Integer.parseInt("XYZ");
//			System.out.println(num);
//
//			String str = null;
//			System.out.println(str.length());
//
//		} catch (ArithmeticException a) {
//			System.out.println(a.getMessage());
//		} catch (IndexOutOfBoundsException b) {
//			System.out.println(b.getMessage());
//		} catch (NumberFormatException c) {
//			System.out.println(c.getMessage());
//		} catch (NullPointerException d) {
//			System.out.println(d.getMessage());
//		}
//=========================================================		
//		int num1 = 30, num2 = 0;
//		try {
//			int output = num1 / num2;
//			System.out.println("Result: " + output);
//		} catch (ArithmeticException x) {
//			System.out.println(x.getMessage());
//		}	
//		try {
//			int a[] = new int[10];
//			a[11] = 9;
//		} catch (IndexOutOfBoundsException b) {
//			System.out.println(b.getMessage());
//		}
//		try {
//			int num = Integer.parseInt("XYZ");
//			System.out.println(num);
//		} catch (NumberFormatException c) {
//			System.out.println(c.getMessage());
//		}
//		try {	
//			String str = null;
//			System.out.println(str.length());
//		} catch (NullPointerException d) {
//			System.out.println(d.getMessage());
//		}

		Integer.parseInt("1"); // Không lỗi
		Integer.parseInt("-1"); // Không lỗi
		Integer.parseInt("+1");
		// Không lỗi
//		try {
//			Integer.parseInt(" 1");
//		} catch (NumberFormatException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		Integer.parseInt("2147483648"); 
//		Integer.parseInt("1.1");
//		Integer.parseInt("");

//		int randomIntNumbers[] = new int[10];
//		Random rand = new Random();
//		for (int i = 0; i < 10; i++) {
//			randomIntNumbers[i] = rand.nextInt(100);
//		}
//
//		Scanner input = new Scanner(System.in);
//		System.out.println("Bạn muốn in ra phần tử mảng thứ mấy? ");
//		try {
//			int index = input.nextInt();
//			System.out.println("OK, phần tử mảng thứ " + index + " mang giá trị " + randomIntNumbers[index]);
//		} catch (InputMismatchException e) {
//			System.out.println("Nhap vao so nguyen");
//		}
//===========================================================================================		
//		Scanner input = new Scanner(System.in);
//		Integer intNumber = null;
//		         
//		try {
//		    System.out.println("Hãy nhập vào một số nguyên: ");
//		    String strNumber = input.nextLine();
//		    intNumber = new Integer(strNumber);
//		} catch (NumberFormatException e) {
//		    System.out.println("Vui lòng nhập vào một số nguyên");
//		}
//		         
//		System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));

//		Scanner input = new Scanner(System.in);
//		Integer intNumber = null;
//
//
//		try {
//		    System.out.println("Hãy nhập vào một số nguyên: ");
//		    String strNumber = input.nextLine();
//		    intNumber = new Integer(strNumber);
//		    
//		} catch (NumberFormatException e) {
//		    System.out.println("Vui lòng nhập vào một số nguyên");
//		}catch (NullPointerException e) {
//			System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));
//		}
		ArrayList <Character> strArrayList = new ArrayList<Character>();
		strArrayList.add('a');
		strArrayList.add('b');
		System.out.println(strArrayList);

	}

}
