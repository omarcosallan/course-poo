package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rented;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		Rented[] vect = new Rented[10];
		
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("\nRented #%d:\n", i + 1);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			
			vect[room] = new Rented(name, email);
		}
		
		System.out.println("\nBusy rooms:");
		
		for (int i = 0; i < vect.length; i++) {
			if (vect[i] != null) {
				System.out.println(i + ": " + vect[i]);
			}
		}
		
		sc.close();;
	}
}
