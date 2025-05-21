package javaBasic;

import java.util.Calendar;

public class CalendarClass {

	public static void main(String[] args) {
		// enum과 내장된 객체(달력)을 연결하여 날짜를 출력하기
		
		Week today = null;	// Week 클래스 타입의 변수 today. 어떤 객체도 가리키고 있지 않다.
		Calendar calendar = Calendar.getInstance();	// Calendar 클래스 타입의 변수 calendar. Calendar 객체의 메서드 getInstacne()를 호출해 대입한다.
		// 메서드 getInstance() 의 반환형은 역시 Calendar일 것이다.
		// Calendar.getInstance()가 호출되면 Calendar 타입의 객체가 만들어지면서 calendar에 대입.
		
		int year = calendar.get(Calendar.YEAR);	// 정수 타입의 year 변수에 Calendar에서 가져온 YEAR값을 넣는다.
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int week = calendar.get(Calendar.DAY_OF_WEEK);	// 요일을 숫자로 출력. 일요일이 1
		
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		switch (week) {
			case 1:	
				today = Week.SUNDAY;
				break;
			case 2:	
				today = Week.MONDAY;				
				break;
			case 3:	
				today = Week.TUESDAY;				
				break;
			case 4:	
				today = Week.WEDNESDAY;				
				break;
			case 5:	
				today = Week.THURSDAY;				
				break;
			case 6:	
				today = Week.FRIDAY;				
				break;
			case 7:	
				today = Week.SATERDAY;				
				break;
		}
				
		if (today == Week.SUNDAY) {	// 같은 주소를 가리키는 변수이므로 == 연산으로 문자열 동등 비교가 가능하다.
			System.out.println("오늘은 일요일입니다.");
		}
		else if (today == Week.MONDAY) {
			System.out.println("오늘은 월요일입니다.");
		}
		else if (today == Week.TUESDAY) {
			System.out.println("오늘은 화요일입니다.");
		}
		else if (today == Week.WEDNESDAY) {
			System.out.println("오늘은 수요일입니다.");
		}
		else if (today == Week.THURSDAY) {
			System.out.println("오늘은 목요일입니다.");
		}
		else if (today == Week.FRIDAY) {
			System.out.println("오늘은 금요일입니다.");
		}
		else if (today == Week.SATERDAY) {
			System.out.println("오늘은 토요일입니다.");
		}
		
		// values() : 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴한다.
		Week[] weekDays = Week.values();
		
		for (Week weekDay : weekDays) {
			System.out.println(weekDay);
		}

	}

}
