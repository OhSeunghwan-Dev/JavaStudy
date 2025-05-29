package member.repository;

import java.util.ArrayList;

import member.model.Member;
import member.model.User;

public class MemberRepository {
	
	private static MemberRepository memberRepository = null;
	private ArrayList<Member> memberList = new ArrayList<>();

	// private 생성자
	private MemberRepository() {}	
	
	// 싱글톤 패턴 - 객체 단일화하기 (DataBase)
	public static MemberRepository getInstance() {
		if (memberRepository == null) {
			memberRepository = new MemberRepository();
		}
		return memberRepository;
	}
	
	
	// Getter
	public ArrayList<Member> getMemberList() {
		return memberList;
	}
	
	// 아이디(세션)을 통한 멤버 찾기
	public Member getMember(String id) {
		
		Member member = null;
		
		for (Member oneMember : memberList) {
			if (oneMember.getId().equals(id)) {
				member = oneMember;
			}
		}
		
		return member;
	}
	
	// 멤버 추가
	public void addMember(Member member) {
		memberList.add(member);
	}
	
	// 멤버 삭제
	public void deleteMember(Member member) {
		memberList.remove(member);
	}
	
	// 멤버 업데이트
	public void updateMember(Member member) {
		
		int index = 0;
		
		for (Member oneMember : memberList) {
			if (member == oneMember) {
				memberList.set(index, member);
				break;
			}
			index++;
		}
	}

	
}
