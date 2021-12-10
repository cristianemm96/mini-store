package store;

import java.util.HashMap;
import java.util.Map;

public class Stock {

	private Map<Product, Integer> productsInStock;
	private int amountOfProductsInStock;
	
	public Stock() {
		this.productsInStock = new HashMap<Product,Integer>();
		this.amountOfProductsInStock = 0;
	}

	public void addProduct(Product product, int amount) {
		// TODO Auto-generated method stub
		this.addToStock(product, amount);
		this.amountOfProductsInStock++; 
	}

	private void addToStock(Product product, int amount) {
		this.productsInStock.put(product, amount);
	}

	public Object containsTheProduct(Product product) {
		return this.productsInStock.containsKey(product);
	}

	public int getAmountOfProductsInStock() {
		return this.amountOfProductsInStock;
	}

	public int amountOfProductsOf(Product product) {
		// TODO Auto-generated method stub
		return this.productsInStock.get(product);
	}

	public void updateProductInStock(Product product, int amount) {
		// TODO Auto-generated method stub
		int productAmountToUpdate = this.productsInStock.get(product); 
		productAmountToUpdate = productAmountToUpdate - amount;
		this.productsInStock.replace(product, productAmountToUpdate);
	}

}
