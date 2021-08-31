package application;

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

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int c = 1; c <= n; c ++) {
			System.out.println("Product #" + c +" data: ");
			System.out.print("Common, used or imported? (c/u/i): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}else if(ch == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String date = sc.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				Date manufactureDate = formatter.parse(date);  
				list.add(new UsedProduct(name + " (used)", price, manufactureDate));
			}else {
				list.add(new Product(name, price));
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product prod : list) {
			System.out.println(prod.priceTag());			
			//System.out.println(prod.getName() + " - $ " + String.format("%.2f", prod.()));
		}
		
		sc.close();	

	}

}
