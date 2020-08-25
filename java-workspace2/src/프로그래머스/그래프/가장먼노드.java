package 프로그래머스.그래프;

import java.util.*;

public class 가장먼노드 {

	public static void main(String[] args) {
		solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
	}

	public static int solution(int n, int[][] edges) {
		Map<Integer, List<Integer>> connections = new HashMap<>();

		for (int[] edge : edges) {
			int source = edge[0];
			int dest = edge[1];
			connections.putIfAbsent(source, new ArrayList<>());
			connections.putIfAbsent(dest, new ArrayList<>());

			connections.get(source).add(dest);
			connections.get(dest).add(source);
		}
		int answer = BFS(connections, n);
		System.out.println(answer);
		return answer;
	}

	private static int BFS(Map<Integer, List<Integer>> connections, int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		int[] visited = new int[n + 1];
		visited[1] = 1;
		int maxDistance = 0;
		List<Integer> answers = new ArrayList<>();

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			List<Integer> adjacent = connections.get(current);
			for (Integer adj : adjacent) {
				if (!queue.contains(adj) && visited[adj] == 0) {
					visited[adj] = visited[current] + 1;
					maxDistance = Math.max(maxDistance, visited[adj]);
					queue.add(adj);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (visited[i] == maxDistance) {
				answers.add(i);
			}
		}
		return answers.size();
	}
}
