package 복습;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 로봇청소기 {
	static Scanner scanner = new Scanner(System.in);
	static int[][][] map;
	static int maxRow;
	static int maxColumn;
	static Robot robot;
	static Map<Integer, int[]> directions = new HashMap<>();

	public static void main(String[] args) {
		initDirections();
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		map = new int[maxRow][maxColumn][2];
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int dir = scanner.nextInt();
		robot = new Robot(r, c, dir);
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				map[row][column][0] = scanner.nextInt();
			}
		}
		int answer = robot.operate();
		System.out.println(answer);
	}

	private static class Robot {
		int row;
		int column;
		int dir;

		public Robot(int row, int column, int dir) {
			this.row = row;
			this.column = column;
			this.dir = dir;
		}

		public int operate() {
			int count = 0;
			boolean canClean = true;
			while (true) {
				if (canClean) {
					clean();
					count++;
				}
				boolean hasEmptySpace = false;
				for (int offset = 1; offset <= 4; offset++) {
					int nextDir = (dir + (4 - offset)) % 4;
					int[] direction = directions.get(nextDir);
					int nextRow = row + direction[0];
					int nextColumn = column + direction[1];
					if (isAvailablePosition(nextRow, nextColumn) && map[nextRow][nextColumn][0] == 0 &&
							map[nextRow][nextColumn][1] == 0) {
						this.dir = nextDir;
						this.row = nextRow;
						this.column = nextColumn;
						hasEmptySpace = true;
						canClean = true;
						break;
					}
				}
				if (!hasEmptySpace) {
					int[] direction = directions.get(dir);
					int backRow = row - direction[0];
					int backColumn = column - direction[1];
					if (map[backRow][backColumn][0] == 0) {
						this.row = backRow;
						this.column = backColumn;
						canClean = false;
					} else {
						break;
					}
				}
			}
			return count;
		}

		public void clean() {
			map[row][column][1] = 1;
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}

	private static void initDirections() {
		directions.put(0, new int[]{-1, 0});
		directions.put(1, new int[]{0, 1});
		directions.put(2, new int[]{1, 0});
		directions.put(3, new int[]{0, -1});
	}
}
