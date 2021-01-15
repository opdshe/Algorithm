package 깊이우선탐색;

public class 단어변환 {
	static int answer = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];
		dfs(words, visited, begin, target, 0);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	private static void dfs(String[] words, boolean[] visited, String current, String target, int count) {
		if (current.equals(target)) {
			answer = Math.min(answer, count);
		}
		for (int idx = 0; idx < words.length; idx++) {
			if (isAvailableToChange(current, words[idx]) && !visited[idx]) {
				visited[idx] = true;
				dfs(words, visited, words[idx], target, count + 1);
				visited[idx] = false;
			}
		}
	}

	private static boolean isAvailableToChange(String a, String b) {
		int count = 0;
		for (int idx = 0; idx < a.length(); idx++) {
			if (a.charAt(idx) != b.charAt(idx)) {
				count++;
			}
		}
		return count == 1;
	}
}
