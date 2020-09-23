package 그래프.위상정렬;

import java.util.*;

public class 회장뽑기 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] adjacent;
	static int[] inDegree;
	static int countOfCandidates;
	static TreeMap<Integer, List<Integer>> answerMap = new TreeMap<>();

	public static void main(String[] args) {
		countOfCandidates = scanner.nextInt();
		adjacent = new int[countOfCandidates + 1][countOfCandidates + 1];
		inDegree = new int[countOfCandidates + 1];

		while (true) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			if (from == -1 && to == -1) {
				break;
			}
			adjacent[from][to] = 1;
			adjacent[to][from] = 1;
			inDegree[from]++;
			inDegree[to]++;
		}
		for (int idx = 1; idx <= countOfCandidates; idx++) {
			search(idx);
		}
		System.out.println(answerMap.firstEntry().getKey() + " " + answerMap.firstEntry().getValue().size());
		for (int i = 0; i < answerMap.firstEntry().getValue().size(); i++) {
			System.out.print(answerMap.firstEntry().getValue().get(i) + " ");
		}
	}

	private static void search(int start) {
		Queue<Friend> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[countOfCandidates + 1];
		visited[start] = true;

		queue.add(new Friend(start, 0));
		int maxCost = 0;

		while (!queue.isEmpty()) {
			Friend current = queue.poll();
			maxCost = Math.max(maxCost, current.cost);
			for (int idx = 1; idx <= countOfCandidates; idx++) {
				if (!visited[idx] && adjacent[current.idx][idx] == 1) {
					visited[idx] = true;
					queue.add(new Friend(idx, current.cost + 1));
				}
			}
		}
		List<Integer> result = answerMap.getOrDefault(maxCost, new ArrayList<>());
		result.add(start);
		answerMap.put(maxCost, result);
	}

	private static class Friend {
		private int idx;
		private int cost;

		public Friend(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
