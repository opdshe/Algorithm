package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 반도체설계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] inputs = new int[n];
		int[] cache = IntStream
				.generate(() -> 1)
				.limit(n)
				.toArray();
		inputs = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		cache[0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (inputs[i] > inputs[j] && cache[i] <= cache[j]) {
					cache[i] = cache[j] + 1;
				}
			}
		}
		System.out.println(Arrays.stream(cache)
				.max()
				.getAsInt());
	}
}
