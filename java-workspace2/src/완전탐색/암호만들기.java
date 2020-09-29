package 완전탐색;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 암호만들기 {
	static Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
	static int[] array;
	static boolean[] visited;
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		String[] characters = bufferedReader.readLine().split(" ");
		Arrays.sort(characters);
		visited = new boolean[input[1]];
		array = new int[input[0]];
		solution(characters, input[0], 0, 0);
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedWriter.close();
	}

	private static void solution(String[] characters, int count, int level, int start) throws IOException {
		if (level == count) {
			StringBuilder stringBuilder = new StringBuilder();
			int countOfVowel = 0;
			int countOfConsonant = 0;
			for (int idx = 0; idx < count; idx++) {
				if (vowels.contains(characters[array[idx]])) {
					countOfVowel++;
				} else {
					countOfConsonant++;
				}
				stringBuilder.append(characters[array[idx]]);
			}
			if (countOfVowel >= 1 && countOfConsonant >= 2) {
				bufferedWriter.write(String.valueOf(stringBuilder) + "\n");
			}
			return;
		}
		for (int idx = start; idx < characters.length; idx++) {
			if (!visited[idx]) {
				visited[idx] = true;
				array[level] = idx;
				solution(characters, count, level + 1, idx + 1);
				visited[idx] = false;
			}
		}
	}
}
