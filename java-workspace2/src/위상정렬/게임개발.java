package 위상정렬;

import java.util.*;

public class 게임개발 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int[] inDegree;
	static List<List<Integer>> adjacent = new ArrayList<>();
	static List<Integer> cost = new ArrayList<>();

	public static void main(String[] args) {
		N = scanner.nextInt();
		inDegree = new int[N + 1];
		cost.add(0);
		for (int i = 0; i < N + 1; i++) {
			adjacent.add(new ArrayList<>());
		}
		scanner.nextLine();
		for (int i = 1; i <= N; i++) {
			int[] input = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			cost.add(input[0]);
			for (int idx = 1; idx < input.length - 1; idx++) {
				adjacent.get(input[idx]).add(i);
				inDegree[i]++;
			}
		}
		solution();
	}

	private static void solution() {
		int[] answer = new int[N + 1];
		Arrays.fill(answer, 0xfffffff);

		Queue<Building> queue = new ArrayDeque<>();
		for (int idx = 1; idx <= N; idx++) {
			if (inDegree[idx] == 0) {
				answer[idx] = cost.get(idx);
				queue.add(new Building(idx, cost.get(idx)));
			}
		}
		while (!queue.isEmpty()) {
			Building current = queue.poll();
			for (Integer adj : adjacent.get(current.idx)) {
				inDegree[adj]--;
				if (inDegree[adj] <= 0) {
					int end = current.end + cost.get(adj);
					answer[adj] = Math.min(answer[adj], end);
					queue.add(new Building(adj, end));
				}
			}
		}
		for (int idx = 1; idx <= N; idx++) {
			System.out.println(answer[idx]);
		}
	}

	private static class Building {
		private int idx;
		private int end;

		public Building(int idx, int end) {
			this.idx = idx;
			this.end = end;
		}
	}
}
