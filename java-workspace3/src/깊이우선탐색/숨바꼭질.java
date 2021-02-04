package 깊이우선탐색;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
	static final int INF = Integer.MAX_VALUE;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int subin = scanner.nextInt();
		int sister = scanner.nextInt();
		int answer = solution(subin, sister);
		System.out.println(answer);
	}

	private static int solution(int subin, int sister) {
		int minTime = INF;
		Queue<Node> queue = new ArrayDeque<>();
		int[] times = new int[1000001];
		Arrays.fill(times, INF);
		times[subin] = 0;

		queue.add(new Node(subin, 0));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.position == sister) {
				minTime = current.time;
				break;
			}
			if (current.position - 1 >= 0 && times[current.position - 1] == INF) {
				times[current.position - 1] = current.time + 1;
				queue.add(new Node(current.position - 1, current.time + 1));
			}
			if (current.position + 1 <= 100000 && times[current.position + 1] == INF) {
				times[current.position + 1] = current.time + 1;
				queue.add(new Node(current.position + 1, current.time + 1));
			}
			if (current.position * 2 <= 100000 && times[current.position * 2] == INF) {
				times[current.position * 2] = current.time + 1;
				queue.add(new Node(current.position * 2, current.time + 1));
			}
		}
		return minTime;
	}

	private static class Node {
		int position;
		int time;

		public Node(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}
}
