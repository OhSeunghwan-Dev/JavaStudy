package javaBasic.polymorphism;

public class Student extends Human {

	private String schoolName;
	
	public Student() {}
	
	public Student(String name, int age, int weight, String ssn, String schoolName) {
		super(name, age, weight, ssn);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void study() {
		System.out.println("공부합니다.");
	}
	
	@Override
	public void play() {
		System.out.println("학생은 게임을 하며 놉니다.");
	}

	@Override
	public void drink() {
		System.out.println("아메리카노를 마십니다.");	
	}

	@Override
	public String toString() {
		return schoolName + "를 다니는 학생입니다.";
	}

	
}
