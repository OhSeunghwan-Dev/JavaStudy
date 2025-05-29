package view.product;

import java.util.ArrayList;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.Product;

public class DeleteProductPage {

	Scanner sc = new Scanner(System.in);
	ProductController productController = new ProductController();
	
	public void show() {
		
		System.out.print("삭제할 상품명을 입력하세요 : ");
		String name = sc.nextLine();
		ArrayList<Product> list = productController.getProduct(name);
		ArrayList<Integer> numList = new ArrayList<>();
		int index = 0;
		
		if (list.isEmpty()) {
			System.out.println("존재하지 않는 상품입니다.");
		}
		else if (list.size() == 1) {
			productController.deleteProduct(list.get(0));
			System.out.println("상품이 삭제되었습니다.");
		}
		else {
			for (Product product : list) {
				numList.add(++index);
				System.out.print(index + ".  ");
				System.out.print("상품명 : " + product.getName());
				System.out.print("\t상품 가격 : " + product.getPrice());
				System.out.print("\t할인율 : " + product.getSaleRatio() + "\n");
			}
			
			try {
				System.out.println("삭제할 상품 번호를 입력하세요.");
				System.out.print(">>> ");
				int selectNum = Integer.parseInt(sc.nextLine());
				
				if (numList.contains(selectNum)) {
					productController.deleteProduct(list.get(selectNum-1));
					System.out.println("상품이 삭제되었습니다.\n");
				}
				else {
					System.out.println("없는 번호 입니다.\n");
				}
				
			} catch(Exception NumberFormatException) {
				System.out.println("입력이 올바르지 않습니다.\n");
			}
		}
		
		
	}
}
