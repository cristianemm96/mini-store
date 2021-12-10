package store;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test_store {
	private Store aStore;
	private Product productA;
	private Client clientA;
	private Order orderA;
	private ArrayList<Order> listOrder;
	
	@BeforeEach 
	public void setUp() throws Exception{
		aStore = new  Store();
		orderA = new Order();
		clientA = new Client();
		listOrder = new ArrayList<Order>();
		orderA.mkOrder(productA, 3);
	}
	
	@Test
	public void test_aNewStoreHasNoProfits() {
		assertEquals(0, aStore.getProfits());
	}
	@Test
	public void test_aNewStoreHasNoProductInStock(){
		assertEquals(0, aStore.amountOfProductsInStock());
	}
	@Test
	public void test_aNewStoreHasNoTopProducts() {
		assertEquals(0, aStore.amountOfTopProductsInStock());
	}
	@Test
	public void test_aNewStoreHasNoClients() {
		assertEquals(0, aStore.amountOfClients());
	}
	@Test
	public void test_aNewStoreHasNoTopClients() {
		assertEquals(0, aStore.amountOfTopClients());
	}
	@Test
	public void test_aStoreCanAddANewProductToStock() {
		aStore.addAProductToStock(productA, 5);
		assertEquals(true, aStore.containsInStockTheProduct(productA));
	}
	@Test
	public void test_aStoreKnowsHowManyDifferentProductsItHasInStock(){
		aStore.addAProductToStock(productA, 2);
		assertEquals(1, aStore.amountOfProductsInStock());
	}
	@Test
	public void test_aStoreKnowsTheAmountOfAProductInStock() {
		aStore.addAProductToStock(productA, 5);
		assertEquals(5, aStore.amountOfProductsInStockOf(productA));
	}
	@Test
	public void  test_aStoreCanAddAClient(){
		aStore.addAClient(clientA);
		assertEquals(true, aStore.containsTheClient(clientA));
	}
	@Test
	public void test_aStoreCanSellAProductInStockToACustomer() {
		aStore.addAClient(clientA);
		aStore.addAProductToStock(productA, 10);
		listOrder.add(orderA);
		aStore.sellProduct(listOrder, clientA);
		assertEquals(7, aStore.amountOfProductsInStockOf(productA));
	}
	
	@Test
	public void test_aClientCanSaveThePurchasedProductInTheStore() {
		aStore.addAClient(clientA);
		aStore.addAProductToStock(productA, 10);
		listOrder.add(orderA);
		aStore.sellProduct(listOrder, clientA);
		assertEquals(true, clientA.boughtTheProduct(productA));
	}
}
