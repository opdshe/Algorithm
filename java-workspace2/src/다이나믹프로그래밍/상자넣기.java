package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 상자넣기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int[] numbers = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		solution(numbers);
	}

	private static void solution(int[] numbers) {
		List<Integer> list = new ArrayList<>();
		for (int number : numbers) {
			if (list.isEmpty()) {
				list.add(number);
			}
			if (list.get(list.size() - 1) < number) {
				list.add(number);
			} else {
				int position = Collections.binarySearch(list, number);
				if (position >= 0) {
					list.set(position, number);
				} else {
					list.set(-position - 1, number);
				}
			}
		}
		System.out.println(list.size());
	}
}
