package store;

public class Order {

	private Product product;
	private int amount;

	public void mkOrder(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return this.product;
	}

	public int getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

}
