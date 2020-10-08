package 트리;

import java.util.*;

public class 결혼식 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		int countOfConnection = scanner.nextInt();
		List<List<Integer>> adjacent = new ArrayList<>();
		for (int idx = 0; idx <= countOfPeople; idx++) {
			adjacent.add(new ArrayList<>());
		}
		for (int idx = 0; idx < countOfConnection; idx++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent.get(source).add(dest);
			adjacent.get(dest).add(source);
		}
		solution(adjacent, countOfPeople);
	}

	private static void solution(List<List<Integer>> adjacent, int countOfPeople) {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] visited = new int[countOfPeople + 1];
		visited[1] = 1;
		queue.add(1);

		int count = 0;
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (visited[current] > 3) {
				continue;
			}
			count++;
			for (Integer adj : adjacent.get(current)) {
				if (visited[adj] == 0) {
					visited[adj] = visited[current] + 1;
					queue.add(adj);
				}
			}
		}
		System.out.println(count - 1);
	}
}
