package view.member;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.Member;

public class RechargePage {
	
	Scanner sc = new Scanner(System.in);
	CashInputPage cashInputPage = new CashInputPage();
	MemberController memberController = new MemberController();

	public void show(String session) {
		
		Member member = memberController.getMember(session);
		boolean run = true;
		
		System.out.println("====캐쉬 충전 페이지===");
		System.out.println("보유 금액 : " + member.getCash());
		
		while (run) {
			
			System.out.println("1. 캐시 충전하기");
			System.out.println("2. 뒤로가기");
			System.out.print(">>> ");
			String selectNum = sc.next();
			
			switch (selectNum) {
			case "1":
				cashInputPage.show(session);
				System.out.println("충전 완료!");
				System.out.println("보유 금액 : " + member.getCash());
				break;
			case "2":
				run = false;
				break;
			default :
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
