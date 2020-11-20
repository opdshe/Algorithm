package 복습;

public class 네트워크 {
	static int countOfComputer;
	static int[][] map;

	public static void main(String[] args) {

	}

	public int solution(int n, int[][] computers) {
		countOfComputer = n;
		map = computers;
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int idx = 0; idx < n; idx++) {
			if (!visited[idx]) {
				count++;
				connect(visited, idx);
			}
		}
		System.out.println(count);
		return count;
	}

	private static void connect(boolean[] visited, int current) {
		visited[current] = true;

		for (int idx = 0; idx < countOfComputer; idx++) {
			if (idx != current && !visited[idx] && map[current][idx] == 1) {
				connect(visited, idx);
			}
		}
	}
}
