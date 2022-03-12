package fa.training.entities;

import java.util.Scanner;

public class Sale {
	private String name;
	private int age;
	private String address;
	private double salary;
	private int sumtimeWork;
	private int sale_count;
	
	
	public Sale() {
		
	}

	
	public Sale(String name, int age, String address, double salary, int sumtimeWork,int sale_count) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
		this.sumtimeWork = sumtimeWork;
		this.sale_count = sale_count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSumtimeWork() {
		return sumtimeWork;
	}

	public void setSumtimeWork(int sumtimeWork) {
		this.sumtimeWork = sumtimeWork;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}


	public void inputInfo(Scanner scanner ) {
		sale_count++;
		System.out.print("Name : ");	
		setName(scanner.nextLine());
		
		System.out.print("Age: ");
		setAge(Integer.parseInt(scanner.nextLine()));
			
		System.out.print("Address: ");
		setAddress(scanner.nextLine());
		
		System.out.print("Sum Time Work: ");
		setSumtimeWork(Integer.parseInt(scanner.nextLine()));
			
		System.out.print("Salary: " );
		setSalary(Double.parseDouble(scanner.nextLine()));	
		System.out.println("==================================");

		
		
	}
	
	public void printInfo() {
		System.out.println("Sale_count: " + getSale_count());
		System.out.println("Name: " + getName());
		System.out.println("Age: "+ getAge());
		System.out.println("Dia chi: " + getAddress());
		System.out.println("Tong so gio lam: " + getSumtimeWork());
		System.out.println("Luong: " + getSalary());
		System.out.println("Thuong: " + getBonus(sumtimeWork, salary));
		System.out.println("==================================");		
	}
	
	public double getBonus(int sumTimeWork,double salary) {
		double bonus=0;
		if(sumTimeWork >=200) {
			bonus = salary* 0.2;
		}else if(sumTimeWork >= 100 && sumTimeWork < 200) {
			bonus = salary * 0.1;
		}else {
			bonus = 0;
		}
		return bonus;
	}
}
