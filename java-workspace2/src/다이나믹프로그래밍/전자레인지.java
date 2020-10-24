package 다이나믹프로그래밍;

import java.util.Scanner;

public class 전자레인지 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int time = scanner.nextInt();
		solution(time);
	}

	private static void solution(int target) {
		int[] units = new int[]{300, 60, 10};
		int[] answer = new int[3];
		for (int idx = 0; idx < 3; idx++) {
			answer[idx] = target / units[idx];
			target = target % units[idx];
		}
		if (target != 0) {
			System.out.println(-1);
			return;
		}
		for (int idx = 0; idx < 3; idx++) {
			System.out.print(answer[idx] + " ");
		}
	}
}
