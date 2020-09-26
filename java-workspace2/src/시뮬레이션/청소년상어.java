package 시뮬레이션;

import java.util.*;

public class 청소년상어 {
	static Map<Integer, int[]> directions = new HashMap<>();
	static Scanner scanner = new Scanner(System.in);
	static int answer = 0;

	public static void main(String[] args) {
		initDirections();
		List<Fish> fishList = new ArrayList<>();
		Fish[][] map = new Fish[4][4];
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				int idx = scanner.nextInt();
				int dir = scanner.nextInt();
				Fish fish = new Fish(idx, row, column, dir);
				map[row][column] = fish;
				fishList.add(fish);
			}
		}
		int nextDir = map[0][0].dir;
		int add = map[0][0].idx;
		map[0][0] = null;
		dfs(map, 0, 0, nextDir, add);
		System.out.println(answer);
	}

	private static void dfs(Fish[][] map, int sharkY, int sharkX, int sharkDir, int sum) {
		List<Fish> fishList = new ArrayList<>();
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				if (map[row][column] != null) {
					fishList.add(map[row][column]);
				}
			}
		}
		fishList.sort(Comparator.comparing(fish -> fish.idx));
		fishList.forEach(fish -> fish.move(map, sharkY, sharkX));

		int nextSharkY = sharkY;
		int nextSharkX = sharkX;
		while (true) {
			int[] offset = directions.get(sharkDir);
			nextSharkY = nextSharkY + offset[0];
			nextSharkX = nextSharkX + offset[1];
			if (isAvailablePosition(nextSharkY, nextSharkX)) {
				if (map[nextSharkY][nextSharkX] == null) {
					continue;
				} else {
					int nextSharkDir = map[nextSharkY][nextSharkX].dir;
					int add = map[nextSharkY][nextSharkX].idx;
					Fish[][] copyMap = deepCopy(map);
					copyMap[nextSharkY][nextSharkX] = null;
					System.out.println("eat" + nextSharkY + "," + nextSharkX);
					for (int r = 0; r < 4; r++) {
						for (int c = 0; c < 4; c++) {
							if (copyMap[r][c] == null) {
								System.out.print(0 + " ");
							} else {
								System.out.print(copyMap[r][c].idx + " ");
							}
						}
						System.out.println();
					}
					dfs(copyMap, nextSharkY, nextSharkX, nextSharkDir, sum + add);
				}
			} else {
				break;
			}
		}
		answer = Math.max(answer, sum);
	}

	private static void initDirections() {
		directions.put(1, new int[]{-1, 0});
		directions.put(2, new int[]{-1, -1});
		directions.put(3, new int[]{0, -1});
		directions.put(4, new int[]{1, -1});
		directions.put(5, new int[]{1, 0});
		directions.put(6, new int[]{1, 1});
		directions.put(7, new int[]{0, 1});
		directions.put(8, new int[]{-1, 1});
	}

	private static class Fish {
		private int idx;
		private int y;
		private int x;
		private int dir;

		public Fish(int idx, int y, int x, int dir) {
			this.idx = idx;
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		private void move(Fish[][] map, int sharkY, int sharkX) {
			int currentY = this.y;
			int currentX = this.x;
			int nextDir = this.dir;
			for (int offset = 0; offset < 8; offset++) {
				int[] position = directions.get(nextDir);
				int nextRow = currentY + position[0];
				int nextColumn = currentX + position[1];
				if (isAvailablePosition(nextRow, nextColumn)) {
					if (!(nextRow == sharkY && nextColumn == sharkX)) {
						//이미 물고기 있는 경우
						if (map[nextRow][nextColumn] != null) {
							Fish prev = map[nextRow][nextColumn];
							prev.y = this.y;
							prev.x = this.x;
							map[this.y][this.x] = prev;
							map[nextRow][nextColumn] = this;
							this.y = nextRow;
							this.x = nextColumn;
						} else {
							map[nextRow][nextColumn] = this;
							map[this.y][this.x] = null;
							this.y = nextRow;
							this.x = nextColumn;
						}
						break;
					}
				}
				nextDir = (nextDir % 8) + 1;
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < 4 &&
				nextColumn >= 0 && nextColumn < 4;
	}

	private static Fish[][] deepCopy(Fish[][] origin) {
		if (origin == null) return null;
		Fish[][] result = new Fish[4][4];

		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				if (origin[row][column] != null) {
					int idx = origin[row][column].idx;
					int y = origin[row][column].y;
					int x = origin[row][column].x;
					int dir = origin[row][column].dir;
					Fish fish = new Fish(idx, y, x, dir);
					result[row][column] = fish;
				}
			}
		}
		return result;
	}
}
