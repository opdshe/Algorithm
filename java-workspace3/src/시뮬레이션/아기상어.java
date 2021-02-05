package 시뮬레이션;

import java.util.*;

public class 아기상어 {
	static final int INF = Integer.MAX_VALUE;
	static Scanner scanner = new Scanner(System.in);
	static int mapSize;
	static int[][] map;
	static int time;
	static Shark shark;
	static List<Fish> fishes = new ArrayList<>();
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		mapSize = scanner.nextInt();
		map = new int[mapSize][mapSize];
		for (int row = 0; row < mapSize; row++) {
			for (int column = 0; column < mapSize; column++) {
				int value = scanner.nextInt();
				if (value == 9) {
					shark = new Shark(row, column);
				} else if (value > 0) {
					map[row][column] = value;
					fishes.add(new Fish(row, column, value));
				}
			}
		}
		solution();
	}

	private static void solution() {
		while (hasEatableFish()) {
			Fish fish = getFish();
			shark.eat(fish);
		}
		System.out.println(time);
	}

	private static boolean hasEatableFish() {
		setFishDistance();
		return fishes.stream()
				.anyMatch(fish -> fish.size < shark.size && fish.distance != INF);
	}

	private static Fish getFish() {
		setFishDistance();
		return fishes.stream()
				.filter(fish -> fish.size < shark.size)
				.sorted((a, b) -> {
					if (a.distance > b.distance) {
						return 1;
					} else if (a.distance == b.distance) {
						if (a.row > b.row) {
							return 1;
						} else if (a.row == b.row) {
							if (a.column > b.column) {
								return 1;
							}
						}
					}
					return -1;
				}).findFirst()
				.get();
	}

	private static void setFishDistance() {
		fishes.forEach(Fish::setDistance);
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < mapSize &&
				nextColumn >= 0 && nextColumn < mapSize;
	}


	private static class Shark {
		int row;
		int column;
		int size;
		int eat;

		public Shark(int row, int column) {
			this.row = row;
			this.column = column;
			this.size = 2;
		}

		public void eat(Fish fish) {
			eat++;
			map[fish.row][fish.column] = 0;
			if (eat == size) {
				eat = 0;
				size++;
			}
			row = fish.row;
			column = fish.column;
			time += fish.distance;
			fishes.remove(fish);
		}
	}

	private static class Fish {
		int row;
		int column;
		int size;
		int distance;

		public Fish(int row, int column, int size) {
			this.row = row;
			this.column = column;
			this.size = size;
			distance = INF;
		}

		private void setDistance() {
			Queue<int[]> queue = new ArrayDeque<>();
			int[][] visited = new int[mapSize][mapSize];
			for (int row = 0; row < mapSize; row++) {
				Arrays.fill(visited[row], INF);
			}

			visited[shark.row][shark.column] = 0;
			queue.add(new int[]{shark.row, shark.column});

			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				if (current[0] == row && current[1] == column) {
					distance = visited[row][column];
					return;
				}
				for (int[] direction : directions) {
					int nextRow = current[0] + direction[0];
					int nextColumn = current[1] + direction[1];
					if (isAvailablePosition(nextRow, nextColumn)) {
						if (visited[nextRow][nextColumn] == INF && map[nextRow][nextColumn] <= shark.size) {
							visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
							queue.add(new int[]{nextRow, nextColumn});
						}
					}
				}
			}
		}
	}
}
