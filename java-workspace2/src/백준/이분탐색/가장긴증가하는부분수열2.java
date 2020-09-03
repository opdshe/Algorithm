package 백준.이분탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 가장긴증가하는부분수열2 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int[] numbers;
	static List<Integer> numList = new ArrayList<>();

	public static void main(String[] args) {
		N = scanner.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}
		numList.add(0);
		for (int number : numbers) {
			if (number > numList.get(numList.size() - 1)) {
				numList.add(number);
			} else {
				int position = Collections.binarySearch(numList, number);
				if (position >= 0) {
					numList.set(position, number);
				} else {
					numList.set((-position) - 1, number);
				}
			}
		}
		System.out.println(numList.size() - 1);
	}
}