package javaBasic;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// 버블 정렬 : 정렬 알고리즘의 종류 중 하나.
		// 정렬 방법 : 첫 번째 요소부터 시작해 다음 요소와 크기를 비교 후 위치를 바꾸거나 유지한다.
		//			배열의 끝까지 위의 방법으로 두 요소를 정렬하게 되면 배열의 맨 뒤의 요소는 올바른 정렬을 하게 된다.
		//			맨 뒤의 요소를 뺀 나머지 요소를 동일한 방법으로 정렬한다.
		//			이런 식의 정렬은 (배열의 길이 -1)번 하면 정렬이 완성된다.
		
		int[] arr = {63, 37, 79, 12, 85, 100, 94, 51};
		
		// 버블 정렬을 통한 오름차순
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
