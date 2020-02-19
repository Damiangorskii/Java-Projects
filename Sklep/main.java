import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static void main (String[] args) {
		Warehouse warehouse = new Warehouse();
		ArrayList<Person> osoby = new ArrayList<>();
		
		Cart cart = new Cart();
		
		Product a1 = new Product();
		a1.setName("Monte");
		Product a2 = new Product();
		a2.setName("Burn");
		Product a3 = new Product();
		a3.setName("Naked Grouse");
		Product a4 = new Product();
		a4.setName("Pepsi");
		Product a5 = new Product();
		a5.setName("Sprite");
		
		warehouse.addProduct(a1);
		warehouse.addProduct(a2);
		warehouse.addProduct(a3);
		warehouse.addProduct(a4);
		warehouse.addProduct(a5);
		
		warehouse.addQuantity(a1, 33);
		warehouse.addQuantity(a2, 200);
		warehouse.addQuantity(a3, 500);
		warehouse.addQuantity(a4, 100);
		warehouse.addQuantity(a5, 333);
		
		warehouse.addPrice(a1, 3.50);
		warehouse.addPrice(a2, 4.0);
		warehouse.addPrice(a3, 50.5);
		warehouse.addPrice(a4, 10.30);
		warehouse.addPrice(a5, 4.20);
		
		Scanner skaner = new Scanner(System.in);
		Boolean loopControler = true;
		while (loopControler) {
			System.out.println("1. Get ware");
			System.out.println("2. Check warehouse");
			System.out.println("3. Buy ware");
			System.out.println("4. Check all buyers");
			System.out.println("5. End programe");
			int choice = skaner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Insert product name:");
				String nm = skaner.next();
				Product tempProduct = new Product();
				tempProduct.setName(nm);
				if(warehouse.exists(tempProduct)) {
					System.out.println("Insert quantity:");
					int quantity = skaner.nextInt();
					warehouse.addQuantity(tempProduct, quantity);
				} else {
					warehouse.addProduct(tempProduct);
					System.out.println("Insert quantity:");
					int quantity = skaner.nextInt();
					warehouse.addQuantity(tempProduct, quantity);
					System.out.println("Insert Price: ");
					double price = skaner.nextDouble();
					warehouse.addPrice(tempProduct, price);
				}
				break;
			case 2:
				warehouse.printWarehouse();
				break;
			case 3:
				System.out.println("Insert Money you have: ");
				double change = skaner.nextDouble();
				System.out.println("Insert product name:");
				String name = skaner.next();
				Product tmpProduct = new Product();
				tmpProduct.setName(name);
				if(warehouse.exists(tmpProduct)) {
					System.out.println("Insert quantity:");
					int quantity = skaner.nextInt();
					if (quantity <5) {
						System.out.println("Nasz sklep przyjmuje tylko zamowienia hurtowe");
						break;
					}
					if ((change-(quantity * warehouse.getPrice(tmpProduct))>=0.0)){
						if ((warehouse.getQuantity(tmpProduct) - quantity) <0.0) {
							System.out.println("We are out of this product");
							break;
						}
						else {
							System.out.println("Your change: "+(change - (quantity*warehouse.getPrice(tmpProduct))));
						}
						if(cart.exists(tmpProduct)) {
							cart.addQuantity(tmpProduct, quantity);
							warehouse.addQuantity(tmpProduct, -quantity);
						} else {
							cart.addProduct(tmpProduct);
							cart.addQuantity(tmpProduct, quantity);
							warehouse.addQuantity(tmpProduct, -quantity);
						}
						System.out.println("We need some informations");
						System.out.println("Name: ");
						String name1 = skaner.next();
						System.out.println("Nazwisko: ");
						String nazwisko1 = skaner.next();
						System.out.println("Pesel: ");
						String pesel1 = skaner.next();
						Person osoba1 = new Person(nazwisko1,name1,pesel1);
						osoba1.printPerson();
						osoby.add(osoba1);
						System.out.println("Thanks, bye!");
					}
					else {
						System.out.println("Nie masz tyle pieniedzy");
					}
					
					
				} else {
					System.out.println("We don't have such product");
					break;
				}
				
				break;
			case 4:
				System.out.println(osoby);
				break;
			case 5:
				loopControler = false;
				break;
			}
		}
		
		
	}
}










