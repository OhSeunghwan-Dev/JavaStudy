package validation.member;

import java.util.ArrayList;

import member.model.Member;
import member.repository.MemberRepository;

public class IdValidationCheck {
	
	MemberRepository memberRepository = MemberRepository.getInstance();

	public boolean isExistId(String id) {
		// id가 memberList에 존재하는 아이디인지 검사 후 존재하면 true, 존재하지 않으면 false
		ArrayList<Member> memberList = memberRepository.getMemberList();
		
		for (Member member : memberList) {
			if (member.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	

}
