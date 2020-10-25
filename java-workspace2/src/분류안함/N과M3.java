package 분류안함;

import java.io.*;
import java.util.Arrays;

public class N과M3 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] answer;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		answer = new int[input[1]];
		dfs(input[0], input[1], 0);
		bufferedWriter.flush();
	}

	private static void dfs(int max, int length, int level) throws IOException {
		if (length == level) {
			for (int idx = 0; idx < length; idx++) {
				bufferedWriter.write(answer[idx] + " ");
			}
			bufferedWriter.newLine();
			return;
		}
		for (int num = 1; num <= max; num++) {
			answer[level] = num;
			dfs(max, length, level + 1);
		}
	}
}
