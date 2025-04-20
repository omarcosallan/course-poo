package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int column = sc.nextInt();
		
		int[][] mat = new int[row][column];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int search = sc.nextInt();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (mat[i][j] == search) {
					System.out.printf("\nPosition %d, %d:\n", i, j);
					
					if (j > 0) {
						System.out.println("Left: " + mat[i][j - 1]);
					}
					
					if (j < column - 1) {
						System.out.println("Rigth: " + mat[i][j + 1]);
					}
					
					if (i > 0) {
						System.out.println("Up: " + mat[i - 1][j]);
					}
					
					if (i < row - 1) {
						System.out.println("Down: " + mat[i + 1][j]);
					}
				}
			}
		}
	
		sc.close();
	}
}
