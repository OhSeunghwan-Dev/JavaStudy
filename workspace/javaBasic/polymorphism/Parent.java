package javaBasic.polymorphism;

public class Parent extends Human {

	private int asset;	// 자산

	public Parent() {}

	public Parent(String name, int age, int weight, String ssn, int asset) {
		super(name, age, weight, ssn);
		this.asset = asset;
	}

	public int getAsset() {
		return asset;
	}

	public void setAsset(int asset) {
		this.asset = asset;
	}

	public void giveMoney() {
		System.out.println("용돈을 줍니다.");
	}
	
	@Override
	public void play() {
		System.out.println("부모는 낚시를 하며 놉니다.");
	}
	
	@Override
	public void drink() {
		System.out.println("술을 마십니다.");
	}

	@Override
	public String toString() {
		return asset + "원 자산을 갖는 부모님 객체!";
	}
	
}
