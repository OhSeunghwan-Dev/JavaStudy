package javaBasic;

public class Loop {

	public static void main(String[] args) {
		// if문의 초기식 선언 방법 세 가지.

		// 1. for문 안에서 초기식을 선언한다.
		for (int i = 0; i < 10; i++) {
			System.out.println("for문 " + (i + 1) + "번째 반복 중입니다.");
		}
		
		// 2. 외부에서 반복 제어 변수 선언 후 사용
		int i;
		
		for (i = 0; i < 10; i++) {
			System.out.println("for문 " + (i + 1) + "번째 반복 중입니다.");
		}
		
		// 3. 외부에서 반복 제어 변수 선언 후 초기화까지 해서 사용
		int j = 0;
		
		for (; j < 10; j++) {
			System.out.println("for문 " + (j + 1) + "번째 반복 중입니다.");
		}
		
	}

}
