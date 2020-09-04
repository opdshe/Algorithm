package 백준.bfs;

import java.util.*;

public class 연구소 {
	static Scanner scanner = new Scanner(System.in);
	static List<int[]> candidates = new ArrayList<>();
	static List<int[]> viruses = new ArrayList<>();
	static List<int[]> directions = Arrays.asList(
			new int[]{1, 0},
			new int[]{-1, 0},
			new int[]{0, 1},
			new int[]{0, -1}
	);
	static int[] combArray = new int[3];
	static int height;
	static int width;
	static int[][] board;
	static int[][] copyBoard;
	static boolean[][] visited;
	static int answer = 0;

	public static void main(String[] args) {
		height = scanner.nextInt();
		width = scanner.nextInt();
		board = new int[height][width];
		copyBoard = new int[height][width];
		scanner.nextLine();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = scanner.nextInt();
				if (board[i][j] == 0) {
					candidates.add(new int[]{i, j});
				} else if (board[i][j] == 2) {
					viruses.add(new int[]{i, j});
				}
			}
		}
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comb(0, 0);
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>(viruses);
		int[] head = queue.peek();
		visited[head[0]][head[1]] = true;

		while ((!queue.isEmpty())) {
			int[] current = queue.poll();
			copyBoard[current[0]][current[1]] = 2;
			for (int[] offset : directions) {
				int nextY = current[0] + offset[0];
				int nextX = current[1] + offset[1];
				if (isAvailablePosition(nextY, nextX)) {
					if (!visited[nextY][nextX] && copyBoard[nextY][nextX] == 0) {
						visited[nextY][nextX] = true;
						queue.add(new int[]{nextY, nextX});
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (copyBoard[i][j] == 0) {
					count++;
				}
			}
		}
		answer = Math.max(answer, count);
	}

	private static boolean isAvailablePosition(int nextY, int nextX) {
		return nextX >= 0 && nextX < width &&
				nextY >= 0 && nextY < height;
	}

	private static void cleanAndInitCopyBoard() {
		for (int i = 0; i < height; i++) {
			if (width >= 0) System.arraycopy(board[i], 0, copyBoard[i], 0, width);
		}
		for (int i = 0; i < 3; i++) {
			int[] wallPosition = candidates.get(combArray[i]);
			copyBoard[wallPosition[0]][wallPosition[1]] = 1;
		}
		visited = new boolean[height][width];
	}

	private static void comb(int level, int start) {
		if (level == 3) {
			cleanAndInitCopyBoard();
			bfs();
			return;
		}
		for (int i = start; i < candidates.size(); i++) {
			combArray[level] = i;
			comb(level + 1, i + 1);
		}
	}

}
