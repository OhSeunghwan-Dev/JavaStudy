package view.member;

import java.util.Scanner;

import member.controller.MemberController;

public class LoginPage {
	
	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();

	public String show() {
		
		while (true) {
			
			System.out.println("====로그인 페이지====");
			
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String pwd = sc.next();
			
			if (memberController.login(id, pwd)) {
				System.out.println(id + "님 환영합니다.");
				return id;
			}
			else {
				System.out.println("비밀번호를 확인해주세요.");
				System.out.println("뒤로 가시겠습니까?(yes/no)");
				String answer = sc.next();
				if (answer.equalsIgnoreCase("yes")) {
					break;
				}
			}
		}
		
		return null;
	}
	
}
