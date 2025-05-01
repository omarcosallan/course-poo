package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<Product>();

		System.out.print("Enter file path: ");
		String strPath = sc.nextLine();

		File file = new File(strPath);
		String parentFolder = file.getParent();

		new File(parentFolder + "\\out").mkdir();

		String targetFileStr = parentFolder + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (br.ready()) {
				String[] line = br.readLine().split(",");

				Product product = new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2]));
				list.add(product);
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				for (Product product : list) {
					bw.write(product.getName() + "," + String.format("%.2f", product.total()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}
