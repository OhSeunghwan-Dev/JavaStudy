package view.member;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.Member;

public class MemberInfoPage {
	
	Scanner sc = new Scanner(System.in);
	UpdateInfoPage updateInfoPage = new UpdateInfoPage();
	MemberController memberController = new MemberController();
	
	public String show(String session) {
		
		Member member = memberController.getMember(session);
		boolean run = true;
		
		System.out.println("====" + session + "님의 정보====");
		System.out.println("아이디 : " + member.getId());
		System.out.println("비밀번호 : " + member.getPwd());
		System.out.println("이름 : " + member.getName());
		System.out.println("이메일 : " + member.getEmail());
		System.out.println("주소 : " + member.getAddress());
		System.out.println("캐시 : " + member.getCash());
		System.out.println("가입 날짜 : " + member.getDate());
		
		while (run) {
			
			System.out.println("\n1. 정보 업데이트");
			System.out.println("2. 뒤로가기");
			System.out.print(">>> ");
			String selectNum = sc.next();
			
			switch (selectNum) {
			case "1":
				session = updateInfoPage.show(session);
				System.out.println("\n업데이트 완료!");
				break;
			case "2":
				run = false;
				break;
			default :
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		return session;
	}

}
