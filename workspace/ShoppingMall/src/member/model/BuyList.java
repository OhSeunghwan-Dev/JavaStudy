package member.model;

import java.util.HashMap;

import product.model.Product;

public class BuyList {

	private HashMap<Product, Integer> buyList;
	
	public BuyList() {
		buyList = new HashMap<>();
	}
	
	
	public HashMap<Product, Integer>getBuyList() {
		return buyList;
	}
	
	public void setBuyList(HashMap<Product, Integer> buyList) {
		this.buyList = buyList;
	}
	
}
