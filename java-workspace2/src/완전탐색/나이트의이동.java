package 완전탐색;

import java.util.*;

public class 나이트의이동 {
	static Scanner scanner = new Scanner(System.in);
	static List<int[]> offsets = Arrays.asList(
			new int[]{-2, 1},
			new int[]{-1, 2},
			new int[]{1, 2},
			new int[]{2, 1},
			new int[]{2, -1},
			new int[]{1, -2},
			new int[]{-1, -2},
			new int[]{-2, -1}
	);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int size = scanner.nextInt();
			int[][] map = new int[size][size];
			int nightY = scanner.nextInt();
			int nightX = scanner.nextInt();
			int targetY = scanner.nextInt();
			int targetX = scanner.nextInt();
			solution(map, size, nightY, nightX, targetY, targetX);
		}
	}

	private static void solution(int[][] map, int size, int nightY, int nightX, int targetY, int targetX) {
		int[][] visited = new int[size][size];
		int answer = -1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{nightY, nightX});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (current[0] == targetY && current[1] == targetX) {
				answer = visited[current[0]][current[1]];
				break;
			}
			for (int[] offset : offsets) {
				int nextRow = current[0] + offset[0];
				int nextColumn = current[1] + offset[1];
				if (isAvailablePosition(size, nextRow, nextColumn)) {
					if (visited[nextRow][nextColumn] == 0) {
						visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean isAvailablePosition(int size, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
