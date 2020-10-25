package 분류안함;

import java.io.*;
import java.util.Arrays;

public class N과M2 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] answer;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		answer = new int[input[1]];
		boolean[] visited = new boolean[input[0] + 1];
		dfs(visited, input[0], input[1], 1, 0);
		bufferedWriter.flush();
	}

	private static void dfs(boolean[] visited, int max, int length, int start, int level) throws IOException {
		if (length == level) {
			for (int idx = 0; idx < length; idx++) {
				bufferedWriter.write(answer[idx] + " ");
			}
			bufferedWriter.newLine();
			return;
		}
		for (int num = start; num <= max; num++) {
			if (!visited[num]) {
				visited[num] = true;
				answer[level] = num;
				dfs(visited, max, length, num + 1, level + 1);
				visited[num] = false;
			}
		}
	}
}
