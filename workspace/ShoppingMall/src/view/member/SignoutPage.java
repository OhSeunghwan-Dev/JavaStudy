package view.member;

import java.util.Scanner;

import member.controller.MemberController;

public class SignoutPage {
	
	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	
	public String show(String session) {
		
		while (true) {
			System.out.println("====회원탈퇴====");
			System.out.print("비밀번호를 입력하세요 : ");
			String pwd = sc.next();
			
			if (memberController.login(session, pwd)) {
				memberController.signout(session);
				System.out.println("성공적으로 탈퇴 되었습니다.");
				session = null;
				break;
			}
			else {
				System.out.println("올바른 비밀번호가 아닙니다.");
				break;
			}
		}
		return session;
	}

}
