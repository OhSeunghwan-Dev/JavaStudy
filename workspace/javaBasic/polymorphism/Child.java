package javaBasic.polymorphism;

public class Child extends Human {

	private int poketMoney;
	
	public Child() {}

	public Child(String name, int age, int weight, String ssn, int poketMoney) {
		super(name, age, weight, ssn);
		this.poketMoney = poketMoney;
	}

	public void smile() {
		System.out.println("세상물정 모르는 아이가 웃습니다.");
	}
	
	@Override
	public void play() {
		System.out.println("아이는 밖에서 뛰어 놉니다.");
	}

	@Override
	public void drink() {
		System.out.println("주스를 마십니다.");
	}

	@Override
	public String toString() {
		return "용돈을 " + poketMoney + "원 받는 아이 객체!";
	}
	
	
	
}
