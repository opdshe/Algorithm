package 코테대비중요문제;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 다익스트라 {
	static final int inf = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[7];
	static int[] distance = new int[7];
	static int[][] map = new int[][]{
			new int[]{0, 7, inf, inf, 3, 10, inf},
			new int[]{7, 0, 4, 10, 2, 6, inf},
			new int[]{inf, 4, 0, 2, inf, inf, inf},
			new int[]{inf, 10, 2, 0, 11, 9, 4},
			new int[]{3, 2, inf, 11, 0, inf, 5},
			new int[]{10, 6, inf, 9, inf, 0, inf},
			new int[]{inf, inf, inf, 4, 5, inf, 0}
	};

	public static void main(String[] args) {
		Arrays.fill(distance, inf);
		search();
	}

	private static void search() {
		Queue<Integer> queue = new PriorityQueue<>();
		int start = 0;
		int size = 7;
		visited[0] = true;
		distance[0] = 0;
		queue.add(start);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			for (int i = 0; i < size; i++) {
				if (!visited[i] && map[current][i] < inf) {
					if (distance[current] + map[current][i] <= distance[i]) {
						distance[i] = distance[current] + map[current][i];
						queue.add(i);
					}
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}
}
