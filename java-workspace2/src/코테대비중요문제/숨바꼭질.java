package 코테대비중요문제;

import java.util.*;

public class 숨바꼭질 {
	static Scanner scanner = new Scanner(System.in);
	static int subin;
	static int sister;
	static int[] visited = new int[100001];
	static int answer = -1;

	public static void main(String[] args) {
		subin = scanner.nextInt();
		sister = scanner.nextInt();
		search();
		System.out.println(answer);

	}

	private static void search() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(subin);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (current == sister) {
				answer = visited[current];
				break;
			}
			List<Integer> candidates = getCandidates(current);
			for (Integer position : candidates) {
				if (isAvailablePosition(position)) {
					if (visited[position] == 0 && !queue.contains(position)) {
						visited[position] = visited[current] + 1;
						queue.add(position);
					}
				}

			}
		}
	}

	private static List<Integer> getCandidates(int current) {
		List<Integer> candidates = new ArrayList<>();
		candidates.add(current - 1);
		candidates.add(current + 1);
		candidates.add(current * 2);
		return candidates;
	}

	private static boolean isAvailablePosition(int position) {
		return position >= 0 && position <= 100000;
	}
}
