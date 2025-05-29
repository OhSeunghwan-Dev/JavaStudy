package member.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import member.model.Basket;
import member.model.Member;
import member.repository.MemberRepository;
import product.model.Product;
import product.service.ProductService;
import validation.member.IdValidationCheck;
import validation.member.PositiveCheck;

public class MemberService {
	
	MemberRepository memberRepository = MemberRepository.getInstance();
	ProductService productService = new ProductService();
	IdValidationCheck idValidationCheck = new IdValidationCheck();
	PositiveCheck positiveCheck = new PositiveCheck();
	
	public void addMember(Member member) {
		memberRepository.addMember(member);
	}

	public boolean isDuplicated(String id) {
		
		boolean check = idValidationCheck.isExistId(id);
		
		return check;
	}

	public boolean login(String id, String pwd) {
		
		boolean check = false;
		
		Member member = memberRepository.getMember(id);
		
		if (member != null) {
			if (member.getPwd().equals(pwd)) {
				check = true;
			}
		}
		
		return check;
	}
	
	public boolean isPositive(int cash) {
		
		boolean check = positiveCheck.isPositive(cash);
		
		return check;
	}
	
	public void signout(String session) {
		
		Member member = memberRepository.getMember(session);
		
		memberRepository.deleteMember(member);
	}
	
	public Member getMember(String session) {
		
		return memberRepository.getMember(session);
	}
	
	public void updateMember(Member member) {
		
		memberRepository.updateMember(member);
	}

	public boolean isBuyalbe(Member member, int totalPrice) {
		
		if (member.getCash() >= totalPrice) {
			return true;
		}
		return false;
	}

	public void buy(Member member, Product product, int count, int totalPrice) {
		
		Basket buyList = member.getBuyList();
		LinkedHashMap<Product, Integer> list = buyList.getBasketList();
		
		// buyList 에 프로덕트와 수량을 더한다.
		if (isExistProduct(member, product)) {	// 이미 산 전적이 있는 구매품이라면,
			list.computeIfPresent(product, (key, val) -> val + count);	// 헤시맵의 알맞는 키 값의 value에 count를 더한다.
		}
		else {			// 처음 구매하는 물품이라면
			list.put(product, count);	// 해시맵에 값을 넣는다.
			buyList.setBasketList(list);	// 값을 넣은 해시맵을 buyList객체에 세팅
			member.setBuyList(buyList);	// BuyList를 멤버 객체에 세팅
		}
		// totalPrice 를 삭감하는 것으로 member의 cash 필드에 업데이트한다.
		int remain = member.getCash() - totalPrice;
		member.setCash(remain);
		
		memberRepository.updateMember(member);
	}
	
	public boolean isExistProduct(Member member, Product product) {
		
		Basket buyList = member.getBuyList();
		LinkedHashMap<Product, Integer> list = buyList.getBasketList();
		
		if (list.containsKey(product)) {
			return true;
		}
		return false;
	}

	public void putProductInBasket(Member member, Product product, String count) {
		
		Basket saveList = member.getSaveList();
		LinkedHashMap<Product, Integer> list = member.getSaveList().getBasketList();
		int intCount = Integer.parseInt(count);
		
		// 장바구니에 이미 있는 품목이라면
		if (isExistProduct(member, product)) {	// 이미 산 전적이 있는 구매품이라면,
			list.computeIfPresent(product, (key, val) -> val + intCount);	// 헤시맵의 알맞는 키 값의 value에 count를 더한다.
		}
		else {	// 장바구니에 처음 담는 상품이라면
			list.put(product, intCount);	// 해시맵에 값을 넣는다.
			saveList.setBasketList(list);	// 값을 넣은 해시맵을 saveList객체에 세팅
			member.setSaveList(saveList);	// BuyList를 멤버 객체에 세팅
		}
		
		memberRepository.updateMember(member);
	}
	
	

	public Product buySavedProduct(Member member, LinkedHashMap<Product, Integer> list, int index) {
		
		// 1.받아온 인덱스에 있는 Product 찾기
		List<Product> keys = new ArrayList<>(list.keySet());
		List<Integer> values = new ArrayList<>(list.values());
		Product product = keys.get(index);
		Integer count = values.get(index);
		// 2. Product 구매 & 구매 목록 추가
		int totalPrice = 0;
		
		if (product.getSaleRatio() == 0) {
			totalPrice = product.getPrice() * count;
		}
		else {
			totalPrice = (product.getPrice() * (100 - product.getSaleRatio()) / 100) * count; 
		}
		
		buy(member, product, count, totalPrice);
		
		// 2. 찾은 Product는 장바구니에서 지워주기
		deleteProductInBasket(member, product);
		
		return null;
	}
	
	public void deleteProductInBasket(Member member, Product product) {
		
		LinkedHashMap<Product, Integer> list = member.getSaveList().getBasketList();
		list.remove(product);
		Basket basket = new Basket();
		basket.setBasketList(list);
		member.setSaveList(basket);
		
		memberRepository.updateMember(member);
	}

	
}
