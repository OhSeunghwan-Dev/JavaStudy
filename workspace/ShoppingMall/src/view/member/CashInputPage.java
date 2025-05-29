package view.member;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.Member;

public class CashInputPage {
	
	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	
	public void show(String session) {
		
		Member member = memberController.getMember(session);
		
		System.out.print("충전할 금액을 입력하세요 : ");
		int cash = Integer.parseInt(sc.nextLine().replaceAll("\\s", ""));
		cash += member.getCash();
		member.setCash(cash);
		memberController.updateMember(member);
	}

}
