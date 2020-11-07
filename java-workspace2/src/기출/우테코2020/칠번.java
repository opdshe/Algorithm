package 기출.우테코2020;


public class 칠번 {
	static int[][] directions = new int[][]{{-1, 1}, {1, -1}};
	static int currentDirection;
	static int currentY = 0;
	static int currentX = 0;

	public static void main(String[] args) {
		solution(3, false);
	}

	public static int[][] solution(int n, boolean horizontal) {
		if (horizontal) {
			currentDirection = 0;
		} else {
			currentDirection = 1;
		}
		int[][] answer = new int[n][n];
		int time = 0;
		answer[0][0] = time;
		while (true) {
			answer[currentY][currentX] = time;
			if (currentY == n - 1 && currentX == n - 1) {
				break;
			}
			int nextRow = currentY + directions[currentDirection][0];
			int nextColumn = currentX + directions[currentDirection][1];
			//못가는 경우
			if (!isAvailablePosition(n, nextRow, nextColumn)) {
				if (currentDirection == 0) {
					if (!isAvailableColumn(n, nextColumn)) {
						currentY++;
					} else if (!isAvailableRow(n, nextRow)) {
						currentX++;
					}
					currentDirection = 1;
				} else {
					if (!isAvailableRow(n, nextRow)) {
						currentX++;
					} else if (!isAvailableColumn(n, nextColumn)) {
						currentY++;
					}
					currentDirection = 0;
				}
				time++;
			} else {
				currentY = nextRow;
				currentX = nextColumn;
				time += 2;
			}

		}
	/*	for (int row = 0; row < n; row++) {
			System.out.println(Arrays.toString(answer[row]));
		}*/

		return answer;
	}

	public static boolean isAvailablePosition(int n, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < n &&
				nextColumn >= 0 && nextColumn < n;
	}

	public static boolean isAvailableRow(int n, int nextRow) {
		return nextRow >= 0 && nextRow < n;
	}

	public static boolean isAvailableColumn(int n, int nextColumn) {
		return nextColumn >= 0 && nextColumn < n;
	}
}
