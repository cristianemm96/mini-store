package store;

import java.util.ArrayList;

public class Client {

	private ArrayList<Bill> bills;
	private ArrayList<Product> purchasedProducts;
	
	public Client() {
		this.bills = new ArrayList<Bill>();
		this.purchasedProducts = new ArrayList<Product>();
	}

	public void addBill(Bill bill) {
		// TODO Auto-generated method stub
		this.bills.add(bill);
	}

	public void updatePurchasedProducts(Product product) {
		// TODO Auto-generated method stub
		this.purchasedProducts.add(product);
	}

	public Object boughtTheProduct(Product productA) {
		// TODO Auto-generated method stub
		return purchasedProducts.contains(productA);
	}
}
