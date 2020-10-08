package 완전탐색;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int floor = scanner.nextInt();
		int current = scanner.nextInt();
		int target = scanner.nextInt();
		int up = scanner.nextInt();
		int down = scanner.nextInt();
		solution(floor, current, target, up, down);
	}

	private static void solution(int floor, int current, int target, int up, int down) {
		int[] visited = new int[floor + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(current);
		visited[current] = 1;

		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			if (current == target) {
				break;
			}
			int nextFloor;
			nextFloor = now + up;
			if (nextFloor >= 1 && nextFloor <= floor) {
				if (visited[nextFloor] == 0) {
					visited[nextFloor] = visited[now] + 1;
					queue.add(nextFloor);
				}
			}
			nextFloor = now - down;
			if (nextFloor >= 1 && nextFloor <= floor) {
				if (visited[nextFloor] == 0) {
					visited[nextFloor] = visited[now] + 1;
					queue.add(nextFloor);
				}
			}
		}
		System.out.println(visited[target] == 0 ? "use the stairs" : visited[target] - 1);
	}
}
