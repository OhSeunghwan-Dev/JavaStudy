package view.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.Member;
import product.controller.ProductController;
import product.model.Product;

public class SaveListPage {

	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	ProductController productController = new ProductController();
	int index;
	
	public void show(String session) {
		
		Member member = memberController.getMember(session);
		LinkedHashMap<Product, Integer> list = member.getSaveList().getBasketList();
		ArrayList<Integer> numberList = new ArrayList<>();
		
		while (true) {
			
			System.out.println("====장바구니에 담긴 상품입니다.====");
			
			index = 1;
			
			list.forEach((product, count) -> {	
				numberList.add(index);
				System.out.println((numberList.get(index++ - 1)) + ". " + product.getName() + ": " + count + "개");	    
			});
			
			System.out.println();
			
			try {
				System.out.println("상품을 구매하시려면 상품의 번호를 입력해주세요.");
				System.out.println("뒤로 가고 싶으시면 exit를 입력해주세요.\n");
				System.out.print(">>> ");
				String selectNum = sc.next();
				
				if (selectNum.equals("exit")) break;
				
				else if (numberList.contains(Integer.parseInt(selectNum))) {
					
					memberController.buySavedProduct(session, list, Integer.parseInt(selectNum)-1);
					System.out.println("구매가 완료됐습니다!");
					index = 1;
					
				}				
				
			} catch(Exception NumberFormatException) {
				System.out.println("상품 번호를 확인해주세요.\n");
			}
		}
		
		
	}
}
