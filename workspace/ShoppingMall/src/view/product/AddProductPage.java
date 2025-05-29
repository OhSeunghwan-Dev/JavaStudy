package view.product;

import java.util.Scanner;

import product.controller.ProductController;
import product.model.Product;
import validation.member.PositiveCheck;

public class AddProductPage {

	Scanner sc = new Scanner(System.in);
	ProductController productController = new ProductController();
	PositiveCheck positiveCheck = new PositiveCheck();
	
	public void show() {
		
		Product product = new Product();
		
		System.out.println("새로운 상품 추가 페이지");
		System.out.print("새로운 상품의 상품명 : ");
		product.setName(sc.nextLine());
		while (true) {
			System.out.print("새로운 상품의 가격 : ");
			product.setPrice(sc.nextInt());
			if (positiveCheck.isPositive(product.getPrice()))	break;
			else {
				System.out.println("올바른 가격을 입력해주세요.");
			}
		}
		while (true) {
			System.out.print("새로운 상품의 할인율 : ");
			product.setSaleRatio(sc.nextInt());
			if (positiveCheck.isPositive(product.getSaleRatio()))	break;
			else {
				System.out.println("올바른 할인율을 입력해주세요.");
			}
		}
		
		productController.addProduct(product);
		System.out.println("상품 추가 완료!\n");
	}
}
