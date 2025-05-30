package main;

import java.util.Scanner;

import grade.GradeDTO;
import member.MemberDTO;

public class Service {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static MemberDTO[] memberDTOs = new MemberDTO[30];
	public static GradeDTO[] gradeDTOs = new GradeDTO[30];
	public static MemberDTO session = null;
	
	// dummy data
	static {		
		memberDTOs[0] = new MemberDTO("김철수", "1111", "1111");
		memberDTOs[1] = new MemberDTO("홍길동", "2222", "2222");
		memberDTOs[2] = new MemberDTO("김영희", "3333", "3333");
		memberDTOs[3] = new MemberDTO("김고기", "4444", "4444");
		memberDTOs[4] = new MemberDTO("남나눔", "5555", "5555");
		memberDTOs[5] = new MemberDTO("도담동", "6666", "6666");
		memberDTOs[6] = new MemberDTO("라랄라", "7777", "7777");
		memberDTOs[7] = new MemberDTO("마마무", "8888", "8888");
		memberDTOs[8] = new MemberDTO("박바보", "9999", "9999");
		
		gradeDTOs[0] = new GradeDTO(100, 90, 78, 88);
		gradeDTOs[1] = new GradeDTO(85, 97, 58, 71);
		gradeDTOs[2] = new GradeDTO(83, 92, 85, 56);
		gradeDTOs[3] = new GradeDTO(100, 81, 94, 46);
		gradeDTOs[4] = new GradeDTO(96, 66, 77, 90);
		gradeDTOs[5] = new GradeDTO(47, 58, 33, 78);
		gradeDTOs[6] = new GradeDTO(60, 48, 87, 88);
		gradeDTOs[7] = new GradeDTO(78, 81, 54, 48);
		gradeDTOs[8] = new GradeDTO(10, 16, 6, 24);
	}
			

	public static void main(String[] args) {;
		
		boolean run = true;
		
		while (run) {
			
			if (session == null) {
				
				System.out.println("=======성적처리 프로그래멩 오신것을 환영합니다!=======");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("9. 프로그램 종료");
				System.out.println(">>> ");
				String select = sc.next();
				
				switch (select) {
				case "1" : 
					session = login();
					break;
				case "2" :
					signIn();
					break;
				case "9" :
					run = false;
					break;
				default :
					System.out.println("잘못된 입력입니다.");
				}
			}
			else {
				System.out.println("=======" + session.getName() + "님 환영합니다.=======");
				System.out.println("1. 내 점수 보기");
				System.out.println("2. 점수 수정");
				System.out.println("3. 학생 성적 목록 보기");
				System.out.println("4. 학생 평균 석차 보기");
				System.out.println("5. 로그아웃");
				System.out.println("6. 회원탈퇴");
				System.out.println("9. 프로그램 종료");
				System.out.print(">>> ");
				String select = sc.next();
				
				switch (select) {
				case "1" :
					showMyGrade(session);
					break;
				case "2" :
					updateMyGrade(session);
					break;
				case "3" :
					showStudentsGrade();
					break;
				case "4" :
					sortedStudentAverageGrade();
					break;
				case "5" :
					session = null;
					break;
				case "6" :
					session = deleteMember(session);
					break;
				case "9" :
					run = false;
					break;
				default :
					System.out.println("잘못된 입력입니다.");
				}
				
			}
		}

	}	// main함수 종료
	
	public static void signIn() {
		
		MemberDTO memberDTO = new MemberDTO();
		GradeDTO gradeDTO = new GradeDTO();
		
		while (true) {
			
			System.out.print("이름 : ");
			memberDTO.setName(sc.next());
			while (true) {
				System.out.print("아이디 : ");
				memberDTO.setId(sc.next());
				if (!checkDuplicateId(memberDTO.getId())) {
					break;
				}
				else {
					System.out.println("이미 존재하는 아이디입니다.");
				}
			}
			System.out.print("비밀번호 : ");
			memberDTO.setPw(sc.next());
			
			if (!putMember(memberDTO))	break;
			
			System.out.print("국어점수 : ");
			gradeDTO.setKorScore(Integer.parseInt(sc.next()));
			System.out.print("수학점수 : ");
			gradeDTO.setMathScore(Integer.parseInt(sc.next()));
			System.out.print("영어점수 : ");
			gradeDTO.setEngScore(Integer.parseInt(sc.next()));
			System.out.print("과학점수 : ");
			gradeDTO.setScienceScore(Integer.parseInt(sc.next()));
			putGrade(gradeDTO);
			break;
		}
		
		System.out.println("회원가입 완료!");
	}
	
	public static boolean putMember(MemberDTO memberDTO) {
		int index = 0;

		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null) {
				memberDTOs[i] = memberDTO;
				index++;
				break;
			}
		}
		if (index == 30) {
			System.out.println("더 이상 회원가입이 불가능합니다.");
			return false;
		}
		return true;
	}
	
	public static void putGrade(GradeDTO gradeDTO) {

		for (int i = 0; i < gradeDTOs.length; i++) {
			if (gradeDTOs[i] == null) {
				gradeDTOs[i] = gradeDTO;
				break;
			}
		}
	}
	
	public static MemberDTO login() {
		
		MemberDTO memberDTO = new MemberDTO();
		
		while (true) {
			System.out.print("아이디 : ");
			memberDTO.setId(sc.next());
			System.out.print("비밀번호 : ");
			memberDTO.setPw(sc.next());
			
			for (MemberDTO member : memberDTOs) {
				if (memberDTO.equals(member)) {
					if (isPassword(member, memberDTO.getPw())) {
						return member;						
					}
				}
			}
			System.out.println("비밀번호를 확인해주세요.");
			break;
		}
		return null;
	}
	
	public static boolean checkDuplicateId(String id) {
		
		for (MemberDTO memberDTO : memberDTOs) {
			if (memberDTO == null) continue;
			else if (memberDTO.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int getIndex(MemberDTO memberDTO) {
		
		int index = 0; 
		
		for (MemberDTO member : memberDTOs) {
			if (memberDTO.equals(member)) {
				break;
			}
			index++;
		}
		
		return index;
	}
	
	
	public static void showMyGrade(MemberDTO memberDTO) {
		
		int index = getIndex(memberDTO);
		
		int total = gradeDTOs[index].getKorScore() + gradeDTOs[index].getMathScore() + gradeDTOs[index].getEngScore() + gradeDTOs[index].getScienceScore();
		System.out.println(memberDTO.getName() + "님의 성적입니다.");
		System.out.println("국어 : " + gradeDTOs[index].getKorScore());
		System.out.println("수학 : " + gradeDTOs[index].getMathScore());
		System.out.println("영어 : " + gradeDTOs[index].getEngScore());
		System.out.println("과학 : " + gradeDTOs[index].getScienceScore());
		System.out.println("평균 : " + (total / 4.0));
	}
	
	
	public static void updateMyGrade(MemberDTO memberDTO) {
		
		boolean run = true;
		int index = getIndex(memberDTO);
		
		while (run) {
			System.out.print("수정할 과목명을 입력하세요 : ");
			String subject = sc.next();
			
			switch (subject) {
			case "국어" :
				System.out.println("기존 국어 점수 : " + gradeDTOs[index].getKorScore());
				System.out.print("변경할 점수 : ");
				gradeDTOs[index].setKorScore(Integer.parseInt(sc.next()));
				System.out.println("수정 완료");
				run = false;
				break;
			case "수학" :
				System.out.println("기존 수학 점수 : " + gradeDTOs[index].getMathScore());
				System.out.print("변경할 점수 : ");
				gradeDTOs[index].setMathScore(Integer.parseInt(sc.next()));
				System.out.println("수정 완료");
				run = false;
				break;
			case "영어" :
				System.out.println("기존 영어 점수 : " + gradeDTOs[index].getEngScore());
				System.out.print("변경할 점수 : ");
				gradeDTOs[index].setEngScore(Integer.parseInt(sc.next()));
				System.out.println("수정 완료");
				run = false;
				break;
			case "과학" :
				System.out.println("기존 과학 점수 : " + gradeDTOs[index].getScienceScore());
				System.out.print("변경할 점수 : ");
				gradeDTOs[index].setScienceScore(Integer.parseInt(sc.next()));
				System.out.println("수정 완료");
				run = false;
				break;
			default :
				System.out.println("올바른 과목명을 입력해주세요.");
			}
		}
	
	}
	
	
	public static void showStudentsGrade() {
		
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null)	continue;
			System.out.println(memberDTOs[i].getName()
					+ "\t국어" + gradeDTOs[i].getKorScore()
					+ "\t수학" + gradeDTOs[i].getMathScore()
					+ "\t영어" + gradeDTOs[i].getEngScore() 
					+ "\t과학" + gradeDTOs[i].getScienceScore());
		}
	}
	
	
	public static MemberDTO deleteMember(MemberDTO memberDTO) {
		
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.next();
		
		if (isPassword(memberDTO, pw)) {
			int index = getIndex(memberDTO);
			memberDTOs[index] = null;
			gradeDTOs[index] = null;
			System.out.println("회원탈퇴 완료");
			return null;
		}
		
		System.out.println("비밀번호를 확인하세요.");
		return memberDTO;
	}
	

	public static boolean isPassword(MemberDTO memberDTO, String pw) {
		
		if (memberDTO.getPw().equals(pw)) {
			return true;
		}
		return false;
	}
	
	
	public static void sortedStudentAverageGrade() {
		
		int index = 0;
		String[][] sortedGrade = new String[30][2];
		
		// sortedGrade에 각 학생들의 평균 점수와 이름을 차례로 담는다. 담은 후 index++
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null)	continue;
			
			int total = gradeDTOs[i].getKorScore() + gradeDTOs[i].getMathScore() + gradeDTOs[i].getEngScore() + gradeDTOs[i].getScienceScore();
			double average = total / 4.0;
			
			sortedGrade[index][0] = memberDTOs[i].getName();
			sortedGrade[index][1] = Double.toString(average);
			index++;
		}
		// 담긴 평균점수까지만 반복문을 돌아 버블소트를 진행한다. -> 내림차순
		for (int i = 0; i < index - 1; i++) {
			for (int j = 0; j < index - 1 - i; j++) {
				if (Double.parseDouble(sortedGrade[j][1]) < Double.parseDouble(sortedGrade[j+1][1])) {
					String[] temp = sortedGrade[j];
					sortedGrade[j] = sortedGrade[j+1];
					sortedGrade[j+1] = temp;
				}
			}
		}
		// 정렬된 sortedGrade를 출력
		for (int i = 0; i < index; i++)	{
			System.out.println((i + 1) + "등 : " + sortedGrade[i][0] + " : " + sortedGrade[i][1] + "점");
		}
	}
	
}	// 클래스 종료
