package 그리디;

import java.util.Scanner;

public class 게임을만든동준이 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfLevel = scanner.nextInt();
		int[] levels = new int[countOfLevel];
		for (int idx = 0; idx < countOfLevel; idx++) {
			int value = scanner.nextInt();
			levels[idx] = value;
		}
		int answer = solution(levels, countOfLevel);
		System.out.println(answer);
	}

	private static int solution(int[] levels, int countOfLevel) {
		if (countOfLevel == 1) {
			return 0;
		}
		int answer = 0;
		for (int idx = countOfLevel - 2; idx >= 0; idx--) {
			if (levels[idx] >= levels[idx + 1]) {
				int next = levels[idx + 1] - 1;
				int diff = levels[idx] - next;
				answer += diff;
				levels[idx] = next;
			}
		}
		return answer;
	}
}
