package main;

import java.util.Scanner;

import member.model.Member;
import member.repository.MemberRepository;
import product.model.Product;
import product.repository.ProductRepository;
import view.Template;
import view.admin.MemberManagementPage;
import view.admin.ProductManagementPage;

public class ShoppingMall {
	
	static String session = null;

	public static void main(String[] args) {
		
		Template template = new Template();
		ProductRepository productRepository = ProductRepository.getInstance();
		MemberRepository memberRepository = MemberRepository.getInstance();
		MemberManagementPage memberManagementPage = new MemberManagementPage();
		ProductManagementPage productManagementPage = new ProductManagementPage();
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
				
		// 더미 데이터
		memberRepository.addMember(new Member("admin", "1234", "관리자", "admin@naver.com", "용산", 10000000));
		memberRepository.addMember(new Member("test", "1111", "시험용", "test1@naver.com", "수원", 10000000));
		memberRepository.addMember(new Member("test2", "2222", "시험용", "test2@naver.com", "강남", 2000000));
		memberRepository.addMember(new Member("test3", "3333", "시험용", "test3@naver.com", "성남", 3200000));
		memberRepository.addMember(new Member("test4", "4444", "시험용", "test4@naver.com", "용인", 4800000));
		memberRepository.addMember(new Member("test5", "5555", "시험용", "test5@naver.com", "청주", 5100000));
		memberRepository.addMember(new Member("test6", "6666", "시험용", "test6@naver.com", "세종", 600000));
		memberRepository.addMember(new Member("test7", "7777", "시험용", "test7@naver.com", "부산", 2000000));
		productRepository.addProduct(new Product("컴퓨터", 1350000, 0));
		productRepository.addProduct(new Product("키보드", 213000, 20));
		productRepository.addProduct(new Product("마우스", 40000, 0));
		productRepository.addProduct(new Product("핸드폰", 1410000, 35));
		productRepository.addProduct(new Product("게이밍 의자", 550000, 0));
		productRepository.addProduct(new Product("세탁기", 1500000, 10));
		productRepository.addProduct(new Product("진공청소기", 1100000, 15));
		productRepository.addProduct(new Product("전자레인지", 30000, 0));
		
		System.out.println("쇼핑몰에 오신것을 환영합니다!");
		
		// 프로그램 진입!
		while (run) {

			String selectNum;
			
			if (session == null) {		// 비로그인 상태
				
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("9. 프로그램 종료");
				System.out.print(">>> ");
				selectNum = sc.next();
				
				switch (selectNum) {
					case "1":
						session = template.getLoginPage().show();
						break;
					case "2":
						template.getSigninPage().show();
						
						break;
					case "9":
						System.out.println("프로그램을 종료합니다.");
						run = false;
						break;				
					default:
						System.out.println("잘못된 입력입니다.");
				}
			}
			else if (session.equals("admin")) {	// 관리자 로그인 상태
				System.out.println("1. 회원 관리");
				System.out.println("2. 상품 관리");
				System.out.println("3. 로그아웃");
				System.out.println("9. 프로그램 종료");
				System.out.print(">>> ");
				selectNum = sc.next();
				
				switch (selectNum) {
					case "1":
						memberManagementPage.show();
						break;
					case "2":
						productManagementPage.show();
						break;
					case "3":
						session = null;
						break;
					case "9":
						System.out.println("프로그램을 종료합니다.");
						run = false;
						break;				
					default:
						System.out.println("잘못된 입력입니다.");
				}
			}
			else {	// 일반 회원 상태
				
				System.out.println("1. 판매 물품 보기");
				System.out.println("2. 내 정보 보기");
				System.out.println("3. 구매 목록 보기");
				System.out.println("4. 장바구니 보기");
				System.out.println("5. 현금 충전하기");
				System.out.println("6. 로그아웃");
				System.out.println("7. 회원탈퇴");
				System.out.println("9. 프로그램 종료");
				System.out.print(">>> ");
				selectNum = sc.next();
				
				switch (selectNum) {
					case "1":
						template.getProductListPage().show(session);
						break;
					case "2":
						session = template.getMemberInfoPage().show(session);
						break;
					case "3":
						template.getBuyListPage().show(session);
						break;
					case "4":
						template.getSaveListPage().show(session);
						break;
					case "5":
						template.getRechargePage().show(session);
						break;
					case "6":
						session = null;
						break;
					case "7":
						session = template.getSignoutPage().show(session);
						break;
					case "9":
						System.out.println("프로그램을 종료합니다.");
						run = false;
						break;				
					default:
						System.out.println("잘못된 입력입니다.");
				}
			}
			
		} // 프로그램 끝
		

		sc.close();
		
		
		
	}	// main 메서드 종료

}	// main 클래스 종료
