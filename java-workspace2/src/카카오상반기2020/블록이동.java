package 카카오상반기2020;

import java.util.Arrays;
import java.util.List;

public class 블록이동 {
	static List<int[]> directions = Arrays.asList(
			new int[]{1, 0},
			new int[]{-1, 0},
			new int[]{0, 1},
			new int[]{0, -1}
	);
	static int size;
	static int[] dest;
	static int answer;
	static boolean[][] visited;

	public static void main(String[] args) {
		solution(new int[][]{
				{0, 0, 0, 1, 1},
				{0, 0, 0, 1, 0},
				{0, 1, 0, 1, 1},
				{1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0}});
	}

	public static int solution(int[][] board) {
		size = board.length;
		dest = new int[]{size - 1, size - 1};
		answer = size * size;
		visited = new boolean[size][size];
		visited[0][1] = true;
		visited[0][0] = true;
		dfs(board, new int[]{0, 1}, new int[]{0, 0}, 0);
		System.out.println(answer);
		return answer;
	}

	private static void dfs(int[][] board, int[] head, int[] tail, int count) {
		if (Arrays.equals(head, dest) || Arrays.equals(tail, dest)) {
			answer = Math.min(answer, count);
			return;
		}
		System.out.println("head " + Arrays.toString(head) + ", tail " + Arrays.toString(tail));
		for (int[] offset : directions) {
			int nextHeadY = head[0] + offset[0];
			int nextHeadX = head[1] + offset[1];
			int nextTailY = tail[0] + offset[0];
			int nextTailX = tail[1] + offset[1];

			if (isAvailablePosition(board, nextHeadY, nextHeadX, nextTailY, nextTailX)) {
				visited[nextHeadY][nextHeadX] = true;
				visited[nextTailY][nextTailX] = true;
				dfs(board, new int[]{nextHeadY, nextHeadX}, new int[]{nextTailY, nextTailX}, count + 1);
				visited[nextHeadY][nextHeadX] = false;
				visited[nextTailY][nextTailX] = false;
			}
		}
		if (isAvailableRange(tail[0] + 1, tail[1])) {
			if (board[tail[0] + 1][tail[1]] == 0) {
				if (isAvailablePosition(board, head[0], head[1], tail[0] + 1, tail[1] + 1)) {
					visited[head[0]][head[1]] = true;
					visited[tail[0] + 1][tail[1] + 1] = true;
					dfs(board, new int[]{head[0], head[1]}, new int[]{tail[0] + 1, tail[1] + 1}, count + 1);
					visited[head[0]][head[1]] = false;
					visited[tail[0] + 1][tail[1] + 1] = false;
				}
			}
		}
		if (isAvailableRange(head[0] + 1, head[1])) {
			if (board[head[0] + 1][head[1]] == 0) {
				if (isAvailablePosition(board, head[0] + 1, head[1] - 1, tail[0], tail[1])) {
					visited[tail[0]][tail[1]] = true;
					visited[head[0] + 1][head[1] - 1] = true;
					dfs(board, new int[]{head[0] + 1, head[1] - 1}, new int[]{tail[0], tail[1]}, count + 1);
					visited[tail[0]][tail[1]] = false;
					visited[head[0] + 1][head[1] - 1] = false;
				}
			}
		}
	}

	private static boolean isAvailableRange(int height, int width) {
		return height >= 0 && height < size &&
				width >= 0 && width < size;
	}

	private static boolean isAvailablePosition(int[][] board, int nextHeadY, int nextHeadX, int nextTailY, int nextTailX) {
		if (nextHeadY < 0 || nextHeadY >= size || nextHeadX < 0 || nextHeadX >= size ||
				nextTailY < 0 || nextTailY >= size || nextTailX < 0 || nextTailX >= size) {
			return false;
		}
		if (visited[nextHeadY][nextHeadX] && visited[nextTailY][nextTailX]) {
			return false;
		}
		return board[nextHeadY][nextHeadX] == 0 && board[nextTailY][nextTailX] == 0;
	}
}