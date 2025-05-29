package view.product;

import java.util.HashMap;

import member.controller.MemberController;
import member.model.Member;
import product.model.Product;

public class BuyListPage {

	MemberController memberController = new MemberController();
	
	public void show(String session) {
		
		Member member = memberController.getMember(session);
		HashMap<Product, Integer> list = member.getBuyList().getBasketList();
		
		System.out.println("구매 이력");
		
		list.forEach((product, count) -> {		
			    System.out.println(product.getName() + ": " + count + "개");	    
		});
		
		System.out.println();
	}
}
