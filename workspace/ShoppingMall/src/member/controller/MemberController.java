package member.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import member.model.Member;
import member.service.MemberService;
import product.model.Product;

public class MemberController {
	
	MemberService memberService = new MemberService();
	
	public void addMember(String id, String pwd, String name, String email, String address, int cash) {
		
		Member member = new Member(id, pwd, name, email, address, cash);
		memberService.addMember(member);
	}
	
	public boolean isDuplicated(String id) {
		
		return memberService.isDuplicated(id);
	}
	
	public boolean login(String id, String pwd) {
		
		return memberService.login(id, pwd);
	}
	
	public boolean isPositive(int cash) {
		
		return memberService.isPositive(cash);
	}
	
	public void signout(String session) {
		
		memberService.signout(session);
	}
	
	public Member getMember(String session) {
		
		return memberService.getMember(session);
	}
	
	public void updateMember(Member member) {
		
		memberService.updateMember(member);
	}

	public boolean isBuyalbe(String session, int totalPrice) {
		
		Member member = memberService.getMember(session);
		
		return memberService.isBuyalbe(member, totalPrice);
	}

	public void buy(String session, Product product, int count, int totalPrice) {
	
		Member member = memberService.getMember(session);
		memberService.buy(member, product, count, totalPrice);
	}

	public void putProductInBasket(String session, Product product, String count) {
		
		Member member = memberService.getMember(session);
		memberService.putProductInBasket(member, product, count);
	}

	public void buySavedProduct(String session, LinkedHashMap<Product, Integer> list, int index) {
		
		Member member = memberService.getMember(session);
		memberService.buySavedProduct(member, list, index);
	}
}
