package 완전탐색.DFS;

import java.util.*;

public class 적록색약 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static boolean[][] visited;

	public static void main(String[] args) {
		size = scanner.nextInt();
		scanner.nextLine();
		char[][] board = new char[size][size];
		for (int row = 0; row < size; row++) {
			board[row] = scanner.nextLine().toCharArray();
		}
		int normal = getCountOfSpotForNormalPeople(board);
		int special = getCountOfSpotForSpecialPeople(board);
		System.out.println(normal + " " + special);
	}

	private static int getCountOfSpotForNormalPeople(char[][] board) {
		visited = new boolean[size][size];
		int countOfSpot = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (!visited[row][column]) {
					char target = board[row][column];
					countOfSpot++;
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[]{row, column});
					visited[row][column] = true;
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						for (int[] direction : directions) {
							int nextRow = current[0] + direction[0];
							int nextColumn = current[1] + direction[1];
							if (isAvailablePosition(nextRow, nextColumn)) {
								if (!visited[nextRow][nextColumn] && board[nextRow][nextColumn] == target) {
									visited[nextRow][nextColumn] = true;
									queue.add(new int[]{nextRow, nextColumn});
								}
							}
						}
					}
				}
			}
		}
		return countOfSpot;
	}

	private static int getCountOfSpotForSpecialPeople(char[][] board) {
		visited = new boolean[size][size];
		int countOfSpot = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (!visited[row][column]) {
					char target = board[row][column];
					countOfSpot++;
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[]{row, column});
					visited[row][column] = true;
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						for (int[] direction : directions) {
							int nextRow = current[0] + direction[0];
							int nextColumn = current[1] + direction[1];
							if (isAvailablePosition(nextRow, nextColumn)) {
								if (!visited[nextRow][nextColumn]) {
									if (target == 'G' || target == 'R') {
										if (board[nextRow][nextColumn] == 'G' || board[nextRow][nextColumn] == 'R') {
											visited[nextRow][nextColumn] = true;
											queue.add(new int[]{nextRow, nextColumn});
										}
									} else {
										if (target == board[nextRow][nextColumn]) {
											visited[nextRow][nextColumn] = true;
											queue.add(new int[]{nextRow, nextColumn});
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return countOfSpot;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
