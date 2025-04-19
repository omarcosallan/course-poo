package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("\nEmployee #%d:\n", i + 1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			
			list.add(employee);
		}
		
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();
		
		Employee employee = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		if (employee == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();	
			employee.setSalary(percentage);
		}
		
		System.out.println("\nList of employees:");
		for (Employee x : list) {
			System.out.println(x);
		}
	
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
