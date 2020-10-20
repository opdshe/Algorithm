package 완전탐색.BFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int subin = scanner.nextInt();
		int sister = scanner.nextInt();
		solution(subin, sister);
	}

	private static void solution(int subin, int sister) {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] position = new int[100001];

		queue.add(subin);
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (current == sister) {
				break;
			}
			if (isAvailable(current - 1)) {
				if (position[current - 1] == 0) {
					position[current - 1] = position[current] + 1;
					queue.add(current - 1);
				}
			}
			if (isAvailable(current + 1)) {
				if (position[current + 1] == 0) {
					position[current + 1] = position[current] + 1;
					queue.add(current + 1);
				}
			}
			if (isAvailable(current * 2)) {
				if (position[current * 2] == 0) {
					position[current * 2] = position[current] + 1;
					queue.add(current * 2);
				}
			}
		}
		System.out.println(position[sister]);
	}

	private static boolean isAvailable(int nextPosition) {
		return nextPosition >= 0 && nextPosition <= 100000;
	}
}
