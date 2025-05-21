package javaBasic;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// 배열은 한가지 자료형에 대해 여러개의 데이터를 저장할 수 있는 자료구조이다.
		// 크기가 정해져있다.
		
		Scanner sc = new Scanner(System.in);
		
		// 배열 선언.
		int[] intArr = new int[10];
		String[] stringArr = new String[3];
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = i+1;
		}
		for (int i = 0; i < stringArr.length; i++) {
			System.out.print("입력 : ");
			stringArr[i] = sc.next();
		}
		
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(stringArr));

	}

}
