package 그리디;

import java.util.Scanner;

public class 설탕배달 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int maxFive = target / 5;
		int answer = Integer.MAX_VALUE;
		for (int five = maxFive; five >= 0; five--) {
			int remainder = target - (five * 5);
			if (remainder % 3 == 0) {
				answer = five + (remainder / 3);
				break;
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}
