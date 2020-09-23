package 그래프.최단경로.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<List<Integer>> adjacent = new ArrayList<>();
	static int N;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		N = input[0];
		for (int i = 0; i < input[0] + 1; i++) {
			adjacent.add(new ArrayList<>());
		}
		for (int i = 0; i < input[1]; i++) {
			int[] roadInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			adjacent.get(roadInfo[0]).add(roadInfo[1]);
		}
		bfs(input[3], input[2]);
	}

	private static void bfs(int start, int targetDistance) {
		int[] visited = new int[N + 1];
		List<Integer> answer = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (visited[current] == targetDistance) {
				answer.add(current);
			}
			for (Integer adj : adjacent.get(current)) {
				if (visited[adj] == 0) {
					visited[adj] = visited[current] + 1;
					queue.add(adj);
				}
			}
		}
		if (answer.size() > 0) {
			answer.sort(Comparator.naturalOrder());
			for (Integer integer : answer) {
				System.out.println(integer);
			}
		} else {
			System.out.println(-1);
		}

	}
}
