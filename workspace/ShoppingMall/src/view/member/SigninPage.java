package view.member;

import java.util.Scanner;

import member.controller.MemberController;

public class SigninPage {
	
	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	
	public void show() {
		
		while (true) {

			System.out.println("====회원가입====");
			System.out.print("아이디 : ");		
			String id = sc.next();
			// 아이디 유효성 검사하기
			if (memberController.isDuplicated(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				continue;
			}
			System.out.print("비밀번호 : ");
			String pwd = sc.next();
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("이메일 : ");
			String email = sc.next();
			System.out.print("주소 : ");
			String address = sc.next();
			int cash = 0;
			while (true) {
				System.out.print("보유 자산 : ");
				cash = Integer.parseInt(sc.next());
				if (!memberController.isPositive(cash)) {
					System.out.println("올바른 금액을 입력하세요.");
				}
				else break;
			}
			
			memberController.addMember(id, pwd, name, email, address, cash);
			break;
		}
	}
}
