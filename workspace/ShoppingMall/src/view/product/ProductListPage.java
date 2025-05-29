package view.product;

import java.util.ArrayList;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.Product;

public class ProductListPage {
	
	Scanner sc = new Scanner(System.in);
	ProductController productController = new ProductController();
	ProductInfoPage productInfoPage = new ProductInfoPage();
	ArrayList<Product> productList = productController.getProductList();
	ArrayList<Integer> numberList = new ArrayList<>();
	
	public void show(String session) {
				
		while (true) {

			System.out.println("====상품 목록====");
			for (int i = 0; i < productList.size(); i++) {
				numberList.add(i+1);
				System.out.println(i + 1 + "번 상품");
				System.out.println(productList.get(i).getName());
				System.out.println();
			}
			
			try {
				System.out.println("자세한 정보를 보고싶은 상품의 번호를 입력하세요");
				System.out.println("뒤로 가고 싶으시면 exit를 입력해주세요.");
				System.out.print(">>> ");
				String selectNum = sc.next();
				
				if (selectNum.equals("exit")) break;
				
				else if (numberList.contains(Integer.parseInt(selectNum))) {
					
					Product product = productController.getProduct(Integer.parseInt(selectNum)-1);
					
					productInfoPage.show(product, session);
				}				
			} catch(Exception NumberFormatException) {
				System.out.println("존재하지 않는 상품번호입니다.\n");
			}
			
		}
		
	}
	
	public void show() {
		
		while (true) {

			System.out.println("====상품 목록====");
			for (int i = 0; i < productList.size(); i++) {
				numberList.add(i+1);
				System.out.println(i + 1 + "번 상품");
				System.out.println(productList.get(i).getName());
				System.out.println();
			}
			
			try {
				System.out.println("자세한 정보를 보고싶은 상품의 번호를 입력하세요");
				System.out.println("뒤로 가고 싶으시면 exit를 입력해주세요.");
				System.out.print(">>> ");
				String selectNum = sc.next();
				
				if (selectNum.equals("exit")) break;
				
				else if (numberList.contains(Integer.parseInt(selectNum))) {
					
					Product product = productController.getProduct(Integer.parseInt(selectNum)-1);
					
					productInfoPage.show(product);
				}				
			} catch(Exception NumberFormatException) {
				System.out.println("존재하지 않는 상품번호입니다.\n");
			}
			
		}
		
	}
}
