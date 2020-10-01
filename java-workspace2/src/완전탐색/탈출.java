package 완전탐색;

import java.util.*;

//비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'
public class 탈출 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static int beaverY;
	static int beaverX;
	static char[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);


	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		scanner.nextLine();
		int hedgehogY = -1;
		int hedgehogX = -1;
		map = new char[maxRow][maxColumn];
		List<Water> waters = new ArrayList<>();
		for (int row = 0; row < maxRow; row++) {
			String line = scanner.nextLine();
			for (int idx = 0; idx < line.length(); idx++) {
				char value = line.charAt(idx);
				map[row][idx] = value;
				if (value == 'D') {
					beaverY = row;
					beaverX = idx;
				} else if (value == 'S') {
					hedgehogY = row;
					hedgehogX = idx;
				} else if (value == '*') {
					waters.add(new Water(row, idx, 1));
				}
			}
		}
		solution(waters, hedgehogY, hedgehogX);
	}

	private static void solution(List<Water> waters, int hedgehogY, int hedgehogX) {
		Queue<int[]> hedgehogPositions = new ArrayDeque<>();
		Queue<Water> nextTurnMoveWaters = new ArrayDeque<>(waters);
		hedgehogPositions.add(new int[]{hedgehogY, hedgehogX});
		int[][] visited = new int[maxRow][maxColumn];
		visited[hedgehogY][hedgehogX] = 1;
		int time = 1;

		while (true) {
			while (nextTurnMoveWaters.size() > 0) {
				if (nextTurnMoveWaters.peek().time == time) {
					Water water = nextTurnMoveWaters.poll();
					water.move(nextTurnMoveWaters);
				} else {
					break;
				}
			}
			while (!hedgehogPositions.isEmpty()) {
				if (visited[hedgehogPositions.peek()[0]][hedgehogPositions.peek()[1]] == time) {
					int[] current = hedgehogPositions.poll();
					for (int[] direction : directions) {
						int nextRow = current[0] + direction[0];
						int nextColumn = current[1] + direction[1];
						if (isAvailablePosition(nextRow, nextColumn)) {
							if (visited[nextRow][nextColumn] == 0 &&
									(map[nextRow][nextColumn] == '.' || map[nextRow][nextColumn] == 'D')) {
								visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
								hedgehogPositions.add(new int[]{nextRow, nextColumn});
							}
						}
					}
				} else {
					break;
				}

			}
			time++;
			if (hedgehogPositions.size() < 1) {
				break;
			}
		}
		System.out.println(visited[beaverY][beaverX] == 0 ? "KAKTUS" : visited[beaverY][beaverX] - 1);
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}

	private static class Water {
		private int y;
		private int x;
		private int time;

		public Water(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}

		private void move(Queue<Water> nextTurnMoveWaters) {
			for (int[] direction : directions) {
				int nextRow = y + direction[0];
				int nextColumn = x + direction[1];
				if (isAvailablePosition(nextRow, nextColumn)) {
					if (map[nextRow][nextColumn] == '.') {
						map[nextRow][nextColumn] = '*';
						nextTurnMoveWaters.add(new Water(nextRow, nextColumn, time + 1));
					}
				}
			}
		}
	}
}
