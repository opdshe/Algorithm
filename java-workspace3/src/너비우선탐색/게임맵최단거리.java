package 너비우선탐색;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class 게임맵최단거리 {
	private static int DEST_ROW;
	private static int DEST_COLUMN;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public int solution(int[][] maps) {
		int[][] visited = new int[maps.length][maps[0].length];
		DEST_ROW = maps.length - 1;
		DEST_COLUMN = maps[0].length - 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 0});
		visited[0][0] = 1;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isAvailablePosition(nextRow, nextColumn) && visited[nextRow][nextColumn] == 0 &&
						maps[nextRow][nextColumn] == 1) {
					visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
					queue.add(new int[]{nextRow, nextColumn});
				}
			}
		}
		return visited[DEST_ROW][DEST_COLUMN] == 0 ? -1 : visited[DEST_ROW][DEST_COLUMN];
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow <= DEST_ROW &&
				nextColumn >= 0 && nextColumn <= DEST_COLUMN;
	}
}
