package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<>();
		
		list.add(new SavingsAccount(1001, "Alex", 500.0, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
		list.add(new SavingsAccount(1003, "Bob", 300.0, 0.01));
		list.add(new BusinessAccount(1004, "Anna", 500.0, 500.0));
		
		double sum = list.stream().mapToDouble(x -> x.getBalance()).sum();
		System.out.printf("Total balance: %.2f%n", sum);
		
		list.stream().forEach(x -> {
			x.deposit(10);
			System.out.printf("Updated balance for account %d: %.2f%n", x.getNumber(), x.getBalance());
		});
	}
}
