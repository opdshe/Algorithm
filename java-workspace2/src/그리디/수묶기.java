package 그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 수묶기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		Integer[] numbers = new Integer[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		Arrays.sort(numbers, Comparator.reverseOrder());
		int currentIdx = 0;
		int result = 0;
		while (currentIdx < countOfNumber) {
			if (currentIdx == countOfNumber - 1) {
				result += numbers[currentIdx];
				currentIdx++;
				continue;
			}
			if (numbers[currentIdx] * numbers[currentIdx + 1] > 0) {
				result += numbers[currentIdx] * numbers[currentIdx + 1];
				currentIdx += 2;
			} else if (numbers[currentIdx] * numbers[currentIdx + 1] < 0) {
				result += numbers[currentIdx];
				currentIdx++;
			} else if (numbers[currentIdx] * numbers[currentIdx + 1] == 0) {
				currentIdx++;
			}
		}
		System.out.println(result);
	}
}
