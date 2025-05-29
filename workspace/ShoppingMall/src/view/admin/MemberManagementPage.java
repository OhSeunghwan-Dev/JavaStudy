package view.admin;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.Member;
import view.Template;

public class MemberManagementPage {

	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	Template template = new Template();
	
	public void show() {
		
		boolean run = true;
		Member member = null;
		String memberId = null;
		
		while (run) {
			
			System.out.println("회원 관리 페이지입니다.");
			System.out.println("1. 회원 목록 보기");
			System.out.println("2. 회원 정보 조회");
			System.out.println("3. 회원 삭제");
			System.out.println("9. 뒤로가기");
			String selectNum = sc.next();
			
			switch (selectNum) {
				case "1":
					template.getMemberListPage().show();
					break;
				case "2":
					System.out.print("조회할 회원의 아이디를 입력하세요 : ");
					memberId = sc.next();
					
					member = memberController.getMember(memberId);
					if (member != null) {
						template.getMemberInfoPage().show(memberId);						
					}
					else {
						System.out.println("존재하지 않는 회원입니다.");
					}
					break;
				case "3":
					System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
					memberId = sc.next();
					
					member = memberController.getMember(memberId);
					if (member != null) {
						memberController.signout(memberId);
						System.out.println("삭제 완료!");
					}
					else {
						System.out.println("존재하지 않는 회원입니다.");
					}
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
