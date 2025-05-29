package view.member;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.Member;

public class UpdateInfoPage {
	
	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	
	public String show(String session) {
		
		Member member = memberController.getMember(session);
		
		while (true) {

			System.out.println("====회원가입====");
			System.out.println("기존 아이디 : " + member.getId());		
			System.out.print("변경할 아이디 : ");		
			String id = sc.next();
			// 아이디 유효성 검사하기
			if (memberController.isDuplicated(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				continue;
			}
			member.setId(id);
			session = id;
			System.out.println("기존 비밀번호 : " + member.getPwd());
			System.out.print("변경할 비밀번호 : ");
			member.setPwd(sc.next());
			System.out.print("기존 이름 : " + member.getName());
			System.out.print("변경할 이름 : ");
			member.setName(sc.next());
			System.out.println("기존 이메일 : " + member.getEmail());
			System.out.print("변경할 이메일 : ");
			member.setEmail(sc.next());
			System.out.println("기존 주소 : " + member.getAddress());
			System.out.print("변경할 주소 : ");
			member.setAddress(sc.next());
			
			memberController.updateMember(member);
			
			break;
		}
		
		return session;
	}
}
