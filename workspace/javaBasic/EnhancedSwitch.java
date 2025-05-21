package javaBasic;

import java.util.Scanner;

public class EnhancedSwitch {

	public static void main(String[] args) {
		// 향상된 switch문
		// 람다식( lambda )을 사용한다.
		
		Scanner scanner = new Scanner(System.in);
		
		String kind = "";
		System.out.print(">>> ");
		String animal = scanner.next();
		
		// 향상된 switch문 사용
		switch (animal) {
			case "호랑이", "사자", "강아지", "고양이", "인간" -> kind = "포유류";	// case 다음 ':' 를 쓰지 않는다. 뒤에는 람다식.
			case "팽귄", "닭", "낙타", "비둘기", "까마귀" -> kind = "조류";
			case "금붕어", "연어", "홍어", "갈치", "삼치" -> kind = "어류";
			default-> kind = "알 수 없는 개체";
		}
		
		System.out.println(animal + "은 " + kind + "입니다.");
	}

}
