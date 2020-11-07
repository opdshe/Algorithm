package 기출.우테코2020;

public class 사번 {
	static int currentY = 0;
	static int currentX = 0;

	public static void main(String[] args) {
		solution(3, new int[][]{{3, 5, 6}, {9, 2, 7}, {4, 1, 8}});
	}

	public static int solution(int n, int[][] board) {
		int sum = 0;
		for (int target = 1; target <= n * n; target++) {
			int[] nextPosition = getNextTargetPosition(board, n, target);
			sum += getMinRowMovement(n, nextPosition[0]) + getMinColumnMovement(n, nextPosition[1]) + 1;
			currentY = nextPosition[0];
			currentX = nextPosition[1];
		}
		System.out.println(sum);
		return sum;
	}

	private static int getMinRowMovement(int n, int nextRow) {
		int upperDirection;
		int lowerDirection;
		if (currentY == nextRow) {
			return 0;
		} else if (currentY < nextRow) {
			upperDirection = currentY + ((n - 1) - nextRow) + 1;
			lowerDirection = nextRow - currentY;
		} else {
			upperDirection = currentY - nextRow;
			lowerDirection = ((n - 1) - currentY) + nextRow + 1;
		}
		return Math.min(upperDirection, lowerDirection);
	}

	private static int getMinColumnMovement(int n, int nextColumn) {
		int leftDirection;
		int rightDirection;
		if (currentX == nextColumn) {
			return 0;
		} else if (currentX < nextColumn) {
			leftDirection = currentX + ((n - 1) - nextColumn) + 1;
			rightDirection = nextColumn - currentX;
		} else {
			leftDirection = currentX - nextColumn;
			rightDirection = ((n - 1) - currentX) + nextColumn + 1;
		}
		return Math.min(leftDirection, rightDirection);
	}

	private static int[] getNextTargetPosition(int[][] board, int n, int nextTarget) {
		int[] position = new int[2];
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < n; column++) {
				if (board[row][column] == nextTarget) {
					position[0] = row;
					position[1] = column;
				}
			}
		}
		return position;
	}
}
