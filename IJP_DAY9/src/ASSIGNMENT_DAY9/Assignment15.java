package ASSIGNMENT_DAY9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Assignment15 {
	public static void cat(File file){

		RandomAccessFile input = null;

		String line = null;

		try {

			input = new RandomAccessFile(file, "r");

			while ((line = input.readLine()) != null) {

				System.out.println(line);

			}

			return;

		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (input != null) {
	
				try {
					input.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}

	public static void main(String[] args) {
		File apath1 = new File("D:\\JAVA\\IJP_DAY9\\src\\ASSIGNMENT_DAY9\\demo.txt");
		cat(apath1);

	}

}
