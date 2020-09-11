package 코테대비중요문제;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class 경주로문제 {
	static int[][] visited;
	static Map<Integer, int[]> directions = new HashMap<>();
	static int size;

	public static void main(String[] args) {
		directions.put(1, new int[]{-1, 0});
		directions.put(2, new int[]{1, 0});
		directions.put(3, new int[]{0, 1});
		directions.put(4, new int[]{0, -1});

		solution(new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 1},
				{0, 0, 1, 0, 0, 0, 1, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0}});
	}

	public static int solution(int[][] input) {
		size = input.length;
		visited = new int[size][size];
		return bfs(input);
	}

	private static int bfs(int[][] input) {
		Queue<Car> queue = new ArrayDeque<>();
		queue.add(new Car(0, 0, -1, 0));
		visited[0][0] = 1;
		int answer = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Car current = queue.poll();
			if (current.y == size - 1 && current.x == size - 1) {
				answer = Math.min(answer, current.cost - 500);
				continue;
			}
			for (Map.Entry<Integer, int[]> entry : directions.entrySet()) {
				int nextHeight = current.y + entry.getValue()[0];
				int nextWidth = current.x + entry.getValue()[1];
				if (isAvailablePosition(nextHeight, nextWidth)) {
					//방문안
					if (visited[nextHeight][nextWidth] == 0 && input[nextHeight][nextWidth] == 0) {
						if (current.direction == entry.getKey()) {
							visited[nextHeight][nextWidth] = current.cost + 100;
							queue.add(new Car(nextHeight, nextWidth, entry.getKey(), current.cost + 100));
						} else {
							visited[nextHeight][nextWidth] = current.cost + 600;
							queue.add(new Car(nextHeight, nextWidth, entry.getKey(), current.cost + 600));
						}
					} else {
						int cost;
						if (current.direction == entry.getKey()) {
							cost = current.cost + 100;
						} else {
							cost = current.cost + 600;
						}
						if (visited[nextHeight][nextWidth] >= cost && input[nextHeight][nextWidth] == 0) {
							visited[nextHeight][nextWidth] = cost;
							queue.add(new Car(nextHeight, nextWidth, entry.getKey(), cost));
						}
					}
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < size &&
				nextWidth >= 0 && nextWidth < size;
	}

	private static class Car {
		private int y;
		private int x;
		private int direction;
		private int cost;

		public Car(int y, int x, int direction, int cost) {
			this.y = y;
			this.x = x;
			this.direction = direction;
			this.cost = cost;
		}
	}
}