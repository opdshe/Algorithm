package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 기타레슨 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfLesson = scanner.nextInt();
		int countOfBlueRay = scanner.nextInt();
		int[] lessons = new int[countOfLesson];
		for (int idx = 0; idx < countOfLesson; idx++) {
			lessons[idx] = scanner.nextInt();
		}
		solution(lessons, countOfLesson, countOfBlueRay);
	}

	private static void solution(int[] lessons, int countOfLesson, int countOfBlueRay) {
		long left = Arrays.stream(lessons)
				.max().getAsInt();
		long right = Arrays.stream(lessons)
				.sum();
		long answer = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			int count = 1;
			long sum = 0;
			for (int lesson : lessons) {
				if (sum + lesson <= mid) {
					sum += lesson;
				} else {
					count++;
					sum = lesson;
				}
			}
			if (count <= countOfBlueRay) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
