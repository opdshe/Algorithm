package 깊이우선탐색;

public class NQUEEN {
	static int[] positions;

	public static void main(String[] args) {
		solution(4);
	}

	//퀸은 대각선, 직선 가능
	public static int solution(int n) {
		positions = new int[n];
		int answer = search(n, 0);
		System.out.println(answer);
		return answer;
	}

	private static int search(int n, int level) {
		if (level == n) {
			return 1;
		}

		int sum = 0;
		for (int column = 0; column < n; column++) {
			if (isAvailable(column, level)) {
				positions[level] = column;
				sum += search(n, level + 1);
			}
		}
		return sum;
	}

	private static boolean isAvailable(int column, int level) {
		if (level == 0) {
			return true;
		}
		for (int prev = 0; prev < level; prev++) {
			float slope = Math.abs(((float) (column - positions[prev]) / (float) (level - prev)));
			if (slope == 1 || slope == 0) {
				return false;
			}
		}
		return true;
	}
}
