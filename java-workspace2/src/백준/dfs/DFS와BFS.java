package 백준.dfs;

import java.util.*;

public class DFS와BFS {
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] inputs = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Map<Integer, List<Integer>> connections = new HashMap<>();
		for (int i = 0; i < inputs[1]; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			addConnection(connections, source, dest);
		}
		visited = new boolean[inputs[0] + 1];
		DFS(connections, inputs[2]);
		System.out.println();
		visited = new boolean[inputs[0] + 1];
		BFS(connections, inputs[2]);
	}

	private static void DFS(Map<Integer, List<Integer>> connections, int current) {
		visited[current] = true;
		System.out.print(current + " ");
		List<Integer> adjacent = connections.get(current);
		adjacent.sort(Comparator.naturalOrder());
		for (Integer adj : adjacent) {
			if (!visited[adj]) {
				DFS(connections, adj);
			}
		}
	}

	private static void BFS(Map<Integer, List<Integer>> connections, int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		StringBuilder answer = new StringBuilder();

		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			answer.append(String.valueOf(current)).append(" ");
			List<Integer> adjacent = connections.get(current);
			adjacent.sort(Comparator.naturalOrder());
			for (Integer adj : adjacent) {
				if (!queue.contains(adj) && !visited[adj]) {
					visited[adj] = true;
					queue.add(adj);
				}
			}
		}
		System.out.println(answer.toString().trim());
	}

	private static void addConnection(Map<Integer, List<Integer>> connections, int source, int dest) {
		List<Integer> sourceConnections = connections.getOrDefault(source, new ArrayList<>());
		sourceConnections.add(dest);
		connections.put(source, sourceConnections);

		List<Integer> destConnections = connections.getOrDefault(dest, new ArrayList<>());
		destConnections.add(source);
		connections.put(dest, destConnections);
	}
}
