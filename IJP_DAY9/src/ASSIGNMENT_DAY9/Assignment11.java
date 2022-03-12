package ASSIGNMENT_DAY9;

import java.io.FileOutputStream;

public class Assignment11 {

	public static void main(String[] args) {
		
		try {
			String s = null;
			System.out.println(s.length());

			FileOutputStream outputStream;
			outputStream = new FileOutputStream("E://file.txt");
			outputStream.write(65);
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

}
