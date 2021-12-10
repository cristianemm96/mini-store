package store;

import java.util.ArrayList;

class Store {

	private Stock stock;
	private ArrayList<Client> clients;
	private ArrayList<Bill> bills;
	
	public Store() {
		this.stock = new Stock();
		this.clients = new ArrayList<Client>();
		this.bills = new ArrayList<Bill>();
	}

	public float getProfits() {
		return 0;
	}

	public int amountOfProductsInStock() {
		return this.stock.getAmountOfProductsInStock();
	}

	public int amountOfTopProductsInStock() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int amountOfClients() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int amountOfTopClients() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addAProductToStock(Product product, int amount) {
		this.stock.addProduct(product, amount);
	}

	public Object containsInStockTheProduct(Product product) {
		return this.stock.containsTheProduct(product);
	}

	public int amountOfProductsInStockOf(Product product) {
		return this.stock.amountOfProductsOf(product);
	}

	public void addAClient(Client client) {
		this.clients.add(client);
	}

	public Object containsTheClient(Client client) {
		return isRegisteredTheClient(client);
	}

	public void sellProduct(ArrayList<Order> listOrder, Client client) {
		// TODO Auto-generated method stub
		if(isRegisteredTheClient(client)) {
			this.sellTheProducts(listOrder, client);
		}
	}
	
	//Mk the sell to the client.
	private void sellTheProducts(ArrayList<Order> listOrder, Client client) {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<Order>();
		for (int i = 0; i < listOrder.size(); i++) {
			if(this.theProductIsAvailable(productOnIndex(listOrder, i))) {
				this.proceedWithSellOf(productOnIndex(listOrder, i), client);
				orders.add(productOnIndex(listOrder, i));
			}
		}
		this.mkBillForClient(client, orders);
	}

	private void mkBillForClient(Client client, ArrayList<Order> order) {
		// TODO Auto-generated method stub
		Bill bill = new Bill();
		bill.setClient(client);
		bill.setOrder(order);
		this.addBill(bill);
		client.addBill(bill);
	}

	private void addBill(Bill bill) {
		// TODO Auto-generated method stub
		this.bills.add(bill);
	}

	private void proceedWithSellOf(Order order, Client client) {
		// TODO Auto-generated method stub
		this.updateStoreFromSellOf(order);
		client.updatePurchasedProducts(order.getProduct());
	}
	
	// ------------------ TO DO ------------------
	private void updateStoreFromSellOf(Order order) {
		// TODO Auto-generated method stub
		stock.updateProductInStock(order.getProduct(), order.getAmount());
	}
	
	// -------------------------------------------
	private boolean theProductIsAvailable(Order order) {
		return this.amountOfProductsInStockOf(order) > 0 & this.amountOfProductsInStockOf(order) > this.amountOfProductsOf(order);
	}

	private int amountOfProductsOf(Order order) {
		return order.getAmount();
	}

	private int amountOfProductsInStockOf(Order order) {
		return this.stock.amountOfProductsOf(order.getProduct());
	}

	private Order productOnIndex(ArrayList<Order> listOrder, int i) {
		return listOrder.get(i);
	}

	private boolean isRegisteredTheClient(Client client) {
		return this.clients.contains(client);
	}

}
