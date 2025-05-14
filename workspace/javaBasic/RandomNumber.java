package javaBasic;

public class RandomNumber {

	public static void main(String[] args) {
		// 라이브러리에 존재하는 Math 클래스의 메서드 중 random() 함수는 난수를 발생시키는 함수이다.
		// 난수의 범위는 0.0 이상 1.0 미만이다.
		// 원하는 난수 발생 범위가 1 ~ n 이라면 (Math.random() * n) + 1 난수를 구할 수 있다.
		double random = Math.random();
		double myRandom = (Math.random() * 100) + 1;	// 1~100 사이의 난수
		int integerRandom = (int) myRandom;				// 1~100 사이의 정수 형태의 난수
		
		System.out.println(random);
		System.out.println(myRandom);
		System.out.println(integerRandom);
	}

}
