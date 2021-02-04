package 너비우선탐색;

import java.util.*;

public class 숨바꼭질4 {
	static Scanner scanner = new Scanner(System.in);
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int subin = scanner.nextInt();
		int sister = scanner.nextInt();
		solution(subin, sister);
	}

	private static void solution(int subin, int sister) {
		int minTime = INF;
		List<Integer> route = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		int[] times = new int[100001];
		Arrays.fill(times, INF);
		times[subin] = 0;

		queue.add(new Node(subin, 0, new ArrayList<>()));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.position == sister) {
				minTime = current.time;
				route = current.route;
				break;
			}
			if (current.position - 1 >= 0 && times[current.position - 1] > current.time + 1) {
				times[current.position - 1] = current.time + 1;
				List<Integer> copy = new ArrayList<>(current.route);
				copy.add(current.position - 1);
				queue.add(new Node(current.position - 1, current.time + 1, copy));
			}
			if (current.position + 1 <= 100000 && times[current.position + 1] > current.time + 1) {
				times[current.position + 1] = current.time + 1;
				List<Integer> copy = new ArrayList<>(current.route);
				copy.add(current.position + 1);
				queue.add(new Node(current.position + 1, current.time + 1, copy));
			}
			if (current.position * 2 <= 100000 && times[current.position * 2] > current.time + 1) {
				times[current.position * 2] = current.time + 1;
				List<Integer> copy = new ArrayList<>(current.route);
				copy.add(current.position * 2);
				queue.add(new Node(current.position * 2, current.time + 1, copy));
			}
		}
		System.out.println(minTime);
		for (Integer integer : route) {
			System.out.print(integer + " ");
		}
	}

	private static class Node {
		int position;
		int time;
		List<Integer> route;

		public Node(int position, int time, List<Integer> route) {
			this.position = position;
			this.time = time;
			this.route = route;
		}
	}
}
