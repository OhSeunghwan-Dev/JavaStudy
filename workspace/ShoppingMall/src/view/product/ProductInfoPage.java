package view.product;

import java.util.Scanner;

import member.controller.MemberController;
import product.controller.ProductController;
import product.model.Product;

public class ProductInfoPage {
	
	Scanner sc = new Scanner(System.in);
	ProductController productController = new ProductController();
	MemberController memberController = new MemberController();
	ProductUpdatePage productUpdatePage = new ProductUpdatePage();
	
	public void show(Product product, String session) {
		
		int price = 0;
		boolean run = true;
		
		System.out.println("상품명 : " + product.getName());
		System.out.println("상품 가격 : " + product.getPrice());
		if (productController.isSale(product)) {
			int salePrice = product.getPrice() * (100 - product.getSaleRatio()) / 100;
			System.out.println("할인 가격 : " + salePrice);
			price = salePrice;
		}
		else {
			price = product.getPrice();			
		}
		
		while (run) {
			System.out.println("구매 수량을 입력해주세요");
			System.out.println("뒤로 가고 싶으시면 exit를 입력해주세요.\n");
			System.out.print(">>> ");
			String selectNum = sc.next();
			
			try {
				if (selectNum.equals("exit")) break;
				
				else {
					
					while (true) {
						System.out.println("총 가격 : " + (price * Integer.parseInt(selectNum)));
						System.out.println("1. 구매하기");
						System.out.println("2. 장바구니 담기");
						System.out.println("3. 뒤로 가기");
						System.out.print(">>> ");
						String answer = sc.next();
						
						if (answer.equals("1")) {	// 구매하겠다면
							
							int totalPrice = price * Integer.parseInt(selectNum);	// 구매 총액
							
							if (memberController.isBuyalbe(session, totalPrice)) {	//	잔액이 충분하다면
								memberController.buy(session, product, Integer.parseInt(selectNum), totalPrice);
								System.out.println("구매 완료됐습니다!\n");
								break;
							}
							else {
								System.out.println("잔액이 부족합니다.\n");
							}
							
						}
						else if (answer.equals("2")) {	// 장바구니 담기
							memberController.putProductInBasket(session, product, selectNum);
							System.out.println("장바구니에 담겼습니다!");
							break;
						}
						else if (answer.equals("3")) {
							break;
						}
						else {
							System.out.println("잘못된 입력입니다.");		// 그 외 입력에 대해
						}
					}

				}
				
			} catch(Exception NumberFormatException) {
				System.out.println("올바르지 않은 개수 입력입니다.\n");
			}
			
			run = false;
		}
		
	}
	
	
	public void show(Product product) {
		
		System.out.println("상품명 : " + product.getName());
		System.out.println("상품 가격 : " + product.getPrice());
		if (productController.isSale(product)) {
			int salePrice = product.getPrice() * (100 - product.getSaleRatio()) / 100;
			System.out.println("할인 가격 : " + salePrice);
		}
		
		while (true) {
			System.out.println("상품 정보를 수정하시겠습니까?(yes/no)");
			System.out.print(">>> ");
			String selectNum = sc.next();
			
			if (selectNum.equals("no")) break;
			
			else if (selectNum.equals("yes")) {
				productUpdatePage.show(product);
				System.out.println("수정 완료");
				break;
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
	}
	
}
