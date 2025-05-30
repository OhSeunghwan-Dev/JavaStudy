package javaBasic.polymorphism;

public abstract class Human {

	private String name;
	private int age;
	private int weight;
	private String ssn;
	
	public Human() {}

	public Human(String name, int age, int weight, String ssn) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public void eat() {
		System.out.println("밥을 먹습니다.");
	}
	
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	
	public abstract void play();
	
	public abstract void drink();	// 부모는 술, 아이는 주스, 학생은 커피
	
	@Override
	public String toString() {
		return "인간 객체!";
	}
}
