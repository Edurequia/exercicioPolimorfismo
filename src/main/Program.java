package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Commom, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
				if (ch == 'i') {
					System.out.print("Customs fee: ");
					Double customsFee = sc.nextDouble();
					list.add(new ImportedProduct(name, price, customsFee));
				}
				else if(ch == 'u') {
					System.out.print("Manufacture date (DD/MM/yyyy): ");
					Date manufactureDate = sdf.parse(sc.next());
					list.add(new UsedProduct(name, price, manufactureDate));
				}
				else {
					list.add(new Product(name, price));
				}
		}
		
		System.out.println("");
		System.out.println("PRICE TAGS: ");
		for (Product x : list) {
		System.out.println(x.priceTag());
		}
		
		sc.close();
	}

}
