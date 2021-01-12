package 그래프.탐색;

public class 네트워크 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		for (int com = 0; com < n; com++) {
			if (!visited[com]) {
				answer++;
				connect(computers, visited, com);
			}
		}
		return answer;
	}

	private static void connect(int[][] computers, boolean[] visited, int current) {
		visited[current] = true;
		for (int com = 0; com < computers.length; com++) {
			if (!visited[com] && computers[current][com] == 1) {
				connect(computers, visited, com);
			}
		}
	}
}
