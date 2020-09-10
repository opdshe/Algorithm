package 카카오2020인턴;

import java.util.*;

public class 경주로건설 {
	static int size;
	static int[][] visited;
	static Map<Integer, int[]> directions = new HashMap<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		solution(new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 1},
				{0, 0, 1, 0, 0, 0, 1, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0}
		});
	}

	public static int solution(int[][] input) {
		directions.put(0, new int[]{-1, 0});
		directions.put(1, new int[]{1, 0});
		directions.put(2, new int[]{0, 1});
		directions.put(3, new int[]{0, -1});

		size = input.length;
		visited = new int[size][size];

		bfs(input);
		System.out.println(answer);
		return answer;
	}

	private static void bfs(int[][] input) {
		Queue<Car> queue = new PriorityQueue<>(Comparator.comparing((Car c) -> c.price));
		queue.add(new Car(0, 0, -1, 0));
		visited[0][0] = 100;
		while (!queue.isEmpty()) {
			Car current = queue.poll();
			if (current.y == size - 1 && current.x == size - 1) {
				answer = Math.min(answer, visited[current.y][current.x] - 500);
				continue;
			}
			for (Map.Entry<Integer, int[]> stringEntry : directions.entrySet()) {
				int[] offset = stringEntry.getValue();
				int nextHeight = current.y + offset[0];
				int nextWidth = current.x + offset[1];
				if (isAvailablePosition(nextHeight, nextWidth)) {
					if (input[nextHeight][nextWidth] == 0) {
						//같은방향
						int cost;
						if (current.direction == stringEntry.getKey()) {
							cost = current.price + 100;
						} else {
							cost = current.price + 600;
						}
						if (visited[nextHeight][nextWidth] == 0) {
							visited[nextHeight][nextWidth] = cost;
							queue.add(new Car(nextHeight, nextWidth, stringEntry.getKey(), cost));
						} else {
							if (visited[nextHeight][nextWidth] >= cost) {
								visited[nextHeight][nextWidth] = cost;
								queue.add(new Car(nextHeight, nextWidth, stringEntry.getKey(), cost));
							}
						}
					}
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < size &&
				nextWidth >= 0 && nextWidth < size;
	}

	private static class Car {
		int y;
		int x;
		int direction;
		int price;

		public Car(int y, int x, int direction, int price) {
			this.y = y;
			this.x = x;
			this.direction = direction;
			this.price = price;
		}
	}
}