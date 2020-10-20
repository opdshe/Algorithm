package 완전탐색.DFS;

import java.util.*;

public class 다리놓기 {
	static int landSize = 1;
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static Map<Integer, List<int[]>> lands = new HashMap<>();
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		initLand();
		System.out.println("init");
		int answer = Integer.MAX_VALUE;
		for (int pivot = 1; pivot <= landSize - 1; pivot++) {
			for (int compare = 1; compare <= landSize - 1; compare++) {
				if (pivot == compare) {
					continue;
				}
				for (int[] pivotLand : lands.get(pivot)) {
					for (int[] compareLand : lands.get(compare)) {
						answer = Math.min(answer, getMinDistance(pivotLand, compareLand));
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static int getMinDistance(int[] source, int[] dest) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] visited = new int[size][size];
		queue.add(source);
		int dist = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			System.out.println("visit" + current[0] + "," + current[1]);
			if (current[0] == dest[0] && current[1] == dest[1]) {
				dist = visited[current[0]][current[1]];
				break;
			}
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isAvailablePosition(nextRow, nextColumn)) {
					if (visited[nextRow][nextColumn] == 0) {
						visited[nextColumn][nextColumn] = visited[current[0]][current[1]] + 1;
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}
		}
		return dist;
	}

	private static void initLand() {
		boolean[][] visited = new boolean[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (!visited[row][column] && map[row][column] == 1) {
					List<int[]> landList = new ArrayList<>();
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[]{row, column});
					visited[row][column] = true;
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						landList.add(current);
						for (int[] direction : directions) {
							int nextRow = current[0] + direction[0];
							int nextColumn = current[1] + direction[1];
							if (isAvailablePosition(nextRow, nextColumn)) {
								if (!visited[nextRow][nextColumn] && map[nextRow][nextColumn] == 1) {
									visited[nextRow][nextColumn] = true;
									queue.add(new int[]{nextRow, nextColumn});
								}
							}
						}
					}
					lands.put(landSize, landList);
					landSize++;
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
