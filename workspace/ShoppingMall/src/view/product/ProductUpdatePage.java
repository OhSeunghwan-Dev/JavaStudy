package view.product;

import java.util.Scanner;

import product.controller.ProductController;
import product.model.Product;
import validation.member.PositiveCheck;

public class ProductUpdatePage {
	
	Scanner sc = new Scanner(System.in);
	ProductController productController = new ProductController();
	PositiveCheck positiveCheck = new PositiveCheck();
	
	public void show(Product product) {
		
		System.out.println("상품명 : " + product.getName());
		System.out.print("교체할 상품명 : ");
		product.setName(sc.nextLine());
		while (true) {
			System.out.println("상품 가격 : " + product.getPrice());
			System.out.print("새로운 상품 가격 : ");
			product.setPrice(sc.nextInt());
			if (positiveCheck.isPositive(product.getPrice()))	break;
			else {
				System.out.println("올바른 가격을 입력해주세요.");
			}
		}
		while (true) {
			System.out.println("상품 할인률 : " + product.getSaleRatio());
			System.out.print("변경할 상품 할인률 : ");
			product.setSaleRatio(sc.nextInt());
			if (positiveCheck.isPositive(product.getSaleRatio()))	break;
			else {
				System.out.println("올바른 할인률을 입력해주세요.");
			}
		}
		
		productController.updateProduct(product);
		System.out.println("상품 정보 변경 완료!\n");
	}

}
