package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int INF = 0xfffffff;
	static int size;
	static int[][] map;
	static Shark shark;
	static List<Fish> fishes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		size = Integer.parseInt(bufferedReader.readLine());
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			int[] currentRow = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			for (int column = 0; column < size; column++) {
				map[row][column] = currentRow[column];
				if (currentRow[column] == 9) {
					map[row][column] = 0;
					shark = new Shark(row, column);
				} else if (currentRow[column] >= 1 && currentRow[column] <= 8) {
					fishes.add(new Fish(row, column, map[row][column]));
				}
			}
		}
		solution();
	}


	private static void solution() {
		int time = 0;
		while (true) {
			setDistanceFromShark();
			fishes.sort(new FishComparator());
			boolean eat = false;
			for (Fish fish : fishes) {
				if (fish.size < shark.size && fish.distanceFromShark != INF) {
					shark.eat(fish);
					time += fish.distanceFromShark;
					eat = true;
					break;
				}
			}
			if (!eat) {
				break;
			}
		}
		System.out.println(time);
	}

	private static class FishComparator implements Comparator<Fish> {

		@Override
		public int compare(Fish a, Fish b) {
			if (a.distanceFromShark > b.distanceFromShark) {
				return 1;
			} else if (a.distanceFromShark == b.distanceFromShark) {
				if (a.y > b.y) {
					return 1;
				} else if (a.y == b.y) {
					if (a.x > b.x) {
						return 1;
					}
				}
			}
			return -1;
		}
	}

	private static void setDistanceFromShark() {
		for (Fish fish : fishes) {
			Queue<int[]> queue = new ArrayDeque<>();
			int[][] visited = new int[size][size];
			for (int row = 0; row < size; row++) {
				Arrays.fill(visited[row], INF);
			}
			visited[shark.y][shark.x] = 0;
			queue.add(new int[]{shark.y, shark.x});

			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				if (current[0] == fish.y && current[1] == fish.x) {
					break;
				}
				for (int[] offset : directions) {
					int nextRow = current[0] + offset[0];
					int nextColumn = current[1] + offset[1];
					if (isAvailablePosition(nextRow, nextColumn)) {
						if (visited[nextRow][nextColumn] == INF && map[nextRow][nextColumn] <= shark.size) {
							visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
							queue.add(new int[]{nextRow, nextColumn});
						}
					}
				}
			}
			fish.distanceFromShark = visited[fish.y][fish.x];
		}
	}

	private static class Shark {
		private int y;
		private int x;
		private int size;
		private int eat;

		public Shark(int y, int x) {
			this.y = y;
			this.x = x;
			this.size = 2;
			this.eat = 0;
		}

		private void eat(Fish fish) {
			this.y = fish.y;
			this.x = fish.x;
			map[fish.y][fish.x] = 0;
			eat++;
			if (eat == this.size) {
				size++;
				eat = 0;
			}
			fishes.remove(fish);
		}
	}

	private static class Fish {
		private int y;
		private int x;
		private int size;
		private int distanceFromShark;

		public Fish(int y, int x, int size) {
			this.y = y;
			this.x = x;
			this.size = size;
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}

}
