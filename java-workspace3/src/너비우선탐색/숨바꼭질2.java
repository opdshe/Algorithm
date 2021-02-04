package 너비우선탐색;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2 {
	static Scanner scanner = new Scanner(System.in);
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int subin = scanner.nextInt();
		int sister = scanner.nextInt();
		solution(subin, sister);
	}

	private static void solution(int subin, int sister) {
		int count = 0;
		int minTime = INF;
		Queue<Node> queue = new ArrayDeque<>();
		int[] times = new int[100001];
		Arrays.fill(times, INF);
		times[subin] = 0;

		queue.add(new Node(subin, 0));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.position == sister) {
				minTime = Math.min(minTime, current.time);
				count++;
			}
			if (current.position - 1 >= 0 && times[current.position - 1] >= current.time + 1) {
				times[current.position - 1] = current.time + 1;
				queue.add(new Node(current.position - 1, current.time + 1));
			}
			if (current.position + 1 <= 100000 && times[current.position + 1] >= current.time + 1) {
				times[current.position + 1] = current.time + 1;
				queue.add(new Node(current.position + 1, current.time + 1));
			}
			if (current.position * 2 <= 100000 && times[current.position * 2] >= current.time + 1) {
				times[current.position * 2] = current.time + 1;
				queue.add(new Node(current.position * 2, current.time + 1));
			}
		}
		System.out.println(minTime);
		System.out.println(count);
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
