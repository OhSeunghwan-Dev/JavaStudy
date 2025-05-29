package member.model;

public class Member extends User{
	
	private int cash;		// 보유 현금
	private Basket saveList;	// 장바구니
	private Basket buyList;	// 구매 목록
	
	// 생성자
	public Member(String id, String pwd, String name, String email, String address, int cash) {
		super(id, pwd, name, email, address);
		this.cash = cash;
		this.saveList = new Basket();
		this.buyList = new Basket();
	}
	
	public int getCash() {
		return cash;
	}
	
	public Basket getSaveList() {
		return saveList;
	}
	
	public Basket getBuyList() {
		return buyList;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public void setBuyList(Basket buyList) {
		this.buyList = buyList;
	}

	public void setSaveList(Basket saveList) {
		this.saveList = saveList;
	}

}
