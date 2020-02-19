import java.util.ArrayList;

public class Warehouse {
	
	private ArrayList<Product> products;
	private ArrayList<Integer> quantities;
	private ArrayList<Double> price;
	
	public Warehouse() {
		products = new ArrayList<>();
		quantities = new ArrayList<>();
		price = new ArrayList<>();
	}
	
	public int getQuantity(Product p) {
		for (int i=0;i<products.size();i++) {
			if (products.get(i).getName().equals(p.getName())) {
				return quantities.get(i).intValue();
			}
		}
		return 0;
	}
	public int getPrice(Product p) {
		for (int i=0;i<products.size();i++) {
			if (products.get(i).getName().equals(p.getName())) {
				return price.get(i).intValue();
			}
		}
		return 0;
	}
	
	public void remove(Product p) {
		boolean exists = false;
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(p.getName())) {
				products.remove(i);
				quantities.remove(i);
				price.remove(i);
				exists = true;
			}
		}
		
		if(!exists) {
			System.out.println("Produkt nie istnieje");
		}
	}
	
	// checks if a product exists
	public boolean exists(Product p) {
		boolean exists = false;
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(p.getName())) {
				exists = true;
			}
		}
		
		return exists;
	}
	
	public void addQuantity(Product p, int quantity) {
		boolean exists = false;
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(p.getName())) {
				quantities.set(i, quantities.get(i) + quantity);
				exists = true;
			}
		}
		
		
		if(!exists) {
			System.out.println("Produkt nie istnieje");
		}
	}
	public void addPrice(Product p, double priceP) {
		boolean exists = false;
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(p.getName())) {
				price.set(i, price.get(i) + priceP);
				exists = true;
			}
		}
		
		
		if(!exists) {
			System.out.println("Produkt nie istnieje");
		}
	}
	
	public void addProduct(Product p) {
		boolean exists = false;
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(p.getName())) {
				exists = true;
			}
		}
		
		if(!exists) {
			products.add(p);
			quantities.add(0);
			price.add(0.0);
		} else {
			System.out.println("Produkt juz istnieje");
		}
	}
	
	public void printWarehouse() {
		for (int i=0;i<products.size();i++) {
			System.out.println(products.get(i).getName()+" - "+quantities.get(i)+ " price : "+price.get(i));
		}
	}

	

}