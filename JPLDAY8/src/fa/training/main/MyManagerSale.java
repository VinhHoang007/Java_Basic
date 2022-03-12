package fa.training.main;

import java.util.ArrayList;
import java.util.Scanner;

import fa.training.entities.Sale;

public class MyManagerSale {

	public static void main(String[] args) {
		ArrayList<Sale> saleList = new ArrayList<Sale>();
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		int count = 0;
		System.out.println("============== INPUT ==============");
		do {
			
			count=count +1;
			Sale nhanvien = new Sale();
			nhanvien.inputInfo(scanner);
			saleList.add(nhanvien);
			nhanvien.setSale_count(count);
			System.out.print("Ban co muon nhap tiep khong ? (Y/N): ");
			choice = scanner.nextLine();
			
		} while ("Y".equalsIgnoreCase(choice));
		
		System.out.println("------------INFORMATION------------");
		for (Sale sale : saleList) {
			sale.printInfo();
		}
		scanner.close();

	}

}
