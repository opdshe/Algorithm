package 코테대비중요문제;

import java.util.*;

public class 산만한고양이 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
	static Map<Integer, Set<Integer>> map = new HashMap<>();
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			Set<Integer> destMap = map.getOrDefault(dest, new HashSet<>());
			destMap.add(source);
			map.put(dest, destMap);
			Set<Integer> sourceMap = map.getOrDefault(source, new HashSet<>());
			sourceMap.add(dest);
			map.put(source, sourceMap);
		}
		for (int i = 1; i <= N; i++) {
			if (i == N) {
				if (!hasCycle(1, -1, i)) {
					answer += i;
				}
			} else {
				if (!hasCycle(i + 1, -1, i)) {
					answer += i;
				}
			}
			visited = new boolean[N + 1];
		}
		System.out.println(answer);
	}

	private static boolean hasCycle(int current, int parent, int except) {
		visited[current] = true;
		for (Integer next : map.get(current)) {
			if (next != except) {
				if (!visited[next]) {
					if (hasCycle(next, current, except)) {
						return true;
					}
				} else if (next != parent) {
					return true;
				}
			}
		}
		return false;
	}
}
