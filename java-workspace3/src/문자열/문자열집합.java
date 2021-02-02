package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 문자열집합 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Set<String> entries = new HashSet<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int answer = 0;
		for (int i = 0; i < input[0]; i++) {
			String entry = bufferedReader.readLine();
			entries.add(entry);
		}
		for (int i = 0; i < input[1]; i++) {
			String target = bufferedReader.readLine();
			if (entries.contains(target)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
