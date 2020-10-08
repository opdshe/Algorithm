package 그리디;

import java.util.Scanner;

public class 전자레인지 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] button = new int[]{300, 60, 10};
		int[] answer = new int[3];
		int target = scanner.nextInt();
		for (int idx = 0; idx < 3; idx++) {
			int time = button[idx];
			if (target >= time) {
				int share = target / time;
				answer[idx] += share;
				target = target % time;
			}
		}
		if (target == 0) {
			for (int idx = 0; idx < 3; idx++) {
				System.out.print(answer[idx] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}
}
