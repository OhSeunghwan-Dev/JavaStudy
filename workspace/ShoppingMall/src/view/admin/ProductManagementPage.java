package view.admin;

import java.util.Scanner;

import view.Template;

public class ProductManagementPage {
	
	Scanner sc = new Scanner(System.in);
	Template template = new Template();
	
	public void show() {
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("상품 관리 페이지입니다.");
			System.out.println("1. 상품 목록 보기");
			System.out.println("2. 상품 추가");
			System.out.println("3. 상품 삭제");
			System.out.println("9. 뒤로가기");
			System.out.print(">>> ");
			String selectNum = sc.next();
			
			switch (selectNum) {
			case "1":
				template.getProductListPage().show();
				break;
			case "2":
				template.getAddProductPage().show();
				break;
			case "3":
				template.getDeleteProductPage().show();
				break;
			case "9":
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;				
			default:
				System.out.println("잘못된 입력입니다.");
		}
		}
	}

}
