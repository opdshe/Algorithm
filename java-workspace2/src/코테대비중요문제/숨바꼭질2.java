package 코테대비중요문제;

import java.util.*;

public class 숨바꼭질2 {
	static Scanner scanner = new Scanner(System.in);
	static int[] visited = new int[100001];
	static int subin;
	static int sister;
	static int count = 0;
	static int answer = 100000;

	public static void main(String[] args) {
		subin = scanner.nextInt();
		sister = scanner.nextInt();
		search();
		System.out.println(answer);
		System.out.println(count);
	}

	private static void search() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(subin);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (current == sister) {
				answer = Math.min(answer, visited[current]);
				count++;
			}
			if (visited[current] > answer) {
				break;
			}
			List<Integer> availableCandidates = getAvailableCandidates(current);
			for (Integer position : availableCandidates) {
				if (isAvailablePosition(position)) {
					if (visited[position] == 0) {
						visited[position] = visited[current] + 1;
						queue.add(position);
					} else if (visited[position] == visited[current] + 1) {
						visited[position] = visited[current] + 1;
						queue.add(position);
					}
				}
			}
		}
	}

	private static List<Integer> getAvailableCandidates(int current) {
		List<Integer> candidates = new ArrayList<>();
		candidates.add(current + 1);
		candidates.add(current - 1);
		candidates.add(current * 2);
		return candidates;
	}

	private static boolean isAvailablePosition(int position) {
		return position >= 0 && position <= 100000;
	}
}
