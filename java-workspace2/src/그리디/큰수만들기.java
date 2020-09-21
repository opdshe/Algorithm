package 그리디;

public class 큰수만들기 {
	static boolean[] visited;
	static int[] array;
	static int answer = -1;

	public static void main(String[] args) {
		solution("1924", 2);
	}

	public static String solution(String number, int k) {
		combine(number, number.length() - k);
		System.out.println(answer);
		return String.valueOf(answer);
	}

	private static void combine(String number, int n) {
		visited = new boolean[number.length()];
		array = new int[n];
		dfs(number, 0, 0);
	}

	private static void dfs(String number, int start, int level) {
		if (level == array.length) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int value : array) {
				stringBuilder.append(number.charAt(value));
			}
			answer = Math.max(answer, Integer.parseInt(stringBuilder.toString()));
			return;
		}

		for (int i = start; i < number.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[level] = i;
				dfs(number, i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}