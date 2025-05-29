package member.model;

import java.util.LinkedHashMap;

import product.model.Product;

public class Basket {

private LinkedHashMap<Product, Integer> basketList;
	
	public Basket () {
		basketList = new LinkedHashMap<>();
	}
	
	
	public LinkedHashMap<Product, Integer> getBasketList() {
		return basketList;
	}
	
	public void setBasketList(LinkedHashMap<Product, Integer> basketList) {
		this.basketList = basketList;
	}
	
}
