package 복습;

import java.util.*;

public class 연구소 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static int[][] map;
	static List<int[]> blanks = new ArrayList<>();
	static int[] blankIdx = new int[3];
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int answer = 0;

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		map = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				map[row][column] = scanner.nextInt();
				if (map[row][column] == 0) {
					blanks.add(new int[]{row, column});
				}
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}

	private static void comb(int level, int start) {
		if (level == 3) {
			int[][] copyMap = deepCopy(map);
			for (int idx = 0; idx < 3; idx++) {
				int[] position = blanks.get(blankIdx[idx]);
				copyMap[position[0]][position[1]] = 1;
			}
			spread(copyMap);
			int count = 0;
			for (int row = 0; row < maxRow; row++) {
				for (int column = 0; column < maxColumn; column++) {
					if (copyMap[row][column] == 0) {
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
			return;
		}
		for (int idx = start; idx < blanks.size(); idx++) {
			blankIdx[level] = idx;
			comb(level + 1, idx + 1);
		}
	}


	private static void spread(int[][] copyMap) {
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				if (copyMap[row][column] == 2) {
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[]{row, column});
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						for (int[] direction : directions) {
							int nextRow = current[0] + direction[0];
							int nextColumn = current[1] + direction[1];
							if (nextRow >= 0 && nextRow < maxRow && nextColumn >= 0 && nextColumn < maxColumn) {
								if (copyMap[nextRow][nextColumn] == 0) {
									copyMap[nextRow][nextColumn] = 2;
									queue.add(new int[]{nextRow, nextColumn});
								}
							}
						}
					}
				}
			}
		}
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}
}
