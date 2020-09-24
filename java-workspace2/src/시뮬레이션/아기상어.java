package 시뮬레이션;

import java.util.*;

public class 아기상어 {
	static Scanner scanner = new Scanner(System.in);
	static List<Fish> fishes = new ArrayList<>();
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int[][] map;
	static int N;
	static Shark shark;
	static int count = 0;

	public static void main(String[] args) {
		N = scanner.nextInt();
		map = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				map[row][column] = scanner.nextInt();
				if (map[row][column] == 9) {
					map[row][column] = 0;
					shark = new Shark(2, row, column);
				}
			}
		}
		//물고기 위치 초기화
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				if (map[row][column] > 0 && map[row][column] != 9) {
					int distance = getMinDistance(row, column);
					fishes.add(new Fish(map[row][column], row, column, distance));
				}
			}
		}
		solution();
	}

	private static int getMinDistance(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] visited = new int[N][N];
		queue.add(new int[]{shark.y, shark.x});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (current[0] == y && current[1] == x) {
				break;
			}
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isAvailablePosition(N, nextRow, nextColumn)) {
					if (visited[nextRow][nextColumn] == 0 && map[nextRow][nextColumn] <= shark.size) {
						visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}
		}
		return visited[y][x];
	}

	private static int solution() {

		int time = 0;
		while (true) {
			fishes.sort(Comparator.comparing(fish -> fish.size));
			Queue<Fish> eatableFishes = new PriorityQueue<>((Fish a, Fish b) -> {
				if (a.distance > b.distance) {
					return 1;
				} else if (a.distance == b.distance) {
					if (a.y > b.y) {
						return 1;
					} else if (a.y == b.y) {
						if (a.x > b.x) {
							return 1;
						}
					}
				}
				return -1;
			});

			for (Fish fish : fishes) {
				if (fish.size < shark.size) {
					eatableFishes.add(fish);
					continue;
				}
				break;
			}
			if (eatableFishes.size() >= 1) {
				Fish fish = eatableFishes.poll();
				time += fish.distance;
				shark.eat(fish);
			} else {
				break;
			}
		}
		System.out.println(time);
		return time;
	}

	private static boolean isAvailablePosition(int N, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < N &&
				nextColumn >= 0 && nextColumn < N;
	}

	private static class Shark {
		private int size;
		private int y;
		private int x;

		public Shark(int size, int y, int x) {
			this.size = size;
			this.y = y;
			this.x = x;
		}

		private void eat(Fish fish) {
			this.y = fish.y;
			this.x = fish.x;
			fishes.remove(fish);
			map[fish.y][fish.x] = 0;
			count++;
			if (count == this.size) {
				count = 0;
				this.size++;
			}
			fishes.forEach(Fish::editDistance);
		}
	}

	private static class Fish {
		private int size;
		private int y;
		private int x;
		private int distance;

		public Fish(int size, int y, int x, int distance) {
			this.size = size;
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		private void editDistance() {
			this.distance = getMinDistance(this.y, this.x);
		}
	}
}
