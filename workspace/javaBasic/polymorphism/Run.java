package javaBasic.polymorphism;

public class Run {
	
	public static void main(String[] args) {
		
		Parent parent1 = new Parent("신형만", 40, 60, "1111-1111", 100000000);
		Child child1 = new Child("신짱구", 7, 40, "2222-2222", 10000);
		Student student1 = new Student("김철수", 17, 68, "3333-3333", "떡잎고등학교");
		
		Human[] humans = new Human[10];
		humans[0] = parent1;
		humans[1] = child1;
		humans[2] = student1;
		
		System.out.println("=====Object로부터 오버라이딩된 toString()=======");
		System.out.println(humans[0]);
		System.out.println(humans[1]);
		System.out.println(humans[2]);
		System.out.println("======부모객체의 추상 메서드를 오버라이딩 하는 자식객체======");
		humans[0].drink();
		humans[1].drink();
		humans[2].drink();
		System.out.println("=====부모객체의 메서드를 사용하는 자식 객체=======");
		humans[0].eat();
		humans[1].eat();
		humans[2].eat();
		System.out.println("=====부모객체의 메서드를 사용하는 자식 객체=======");
		humans[0].sleep();
		humans[1].sleep();
		humans[2].sleep();
		System.out.println("=====부모객체의 추상 메서드를 오버라이딩 하는 자식객체=======");
		humans[0].play();
		humans[1].play();
		humans[2].play();
		System.out.println("=====자식객체 고유의 메서드. 형변환을 통해 호출한다,=======");
		((Parent)humans[0]).giveMoney();
		((Child)humans[1]).smile();
		((Student)humans[2]).study();
		System.out.println("=====자식객체 고유의 메서드. 형변환을 통해 호출한다,=======");
		if (humans[0] instanceof Parent) {
			Parent parent = (Parent)humans[0];
			parent.giveMoney();
		}
		if (humans[1] instanceof Child) {
			Child child = (Child)humans[1];
			child.smile();
		}
		if (humans[2] instanceof Student) {
			Student student = (Student)humans[2];
			student.study();
		}	
		
	}

}
