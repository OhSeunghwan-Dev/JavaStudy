package view.member;

import java.util.ArrayList;

import member.model.Member;
import member.repository.MemberRepository;

public class MemberListPage {
	
	MemberRepository memberRepository = MemberRepository.getInstance();

	public void show() {
		
		ArrayList<Member> list = memberRepository.getMemberList();
		
		System.out.println("====회원 관리 페이지====");
		for (Member member : list) {
			System.out.println(member.getId() + "  "
							+ member.getPwd() + "  "
							+ member.getEmail() + "  "
							+ member.getAddress() + " "
							+ member.getName() + "  " 
							+ member.getCash() + "  " 
							+ member.getDate());
		}
	}
}
