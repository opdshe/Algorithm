package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int N = input[0];
		int M = input[1];
		int[] numbers = new int[N];
		for (int idx = 0; idx < N; idx++) {
			numbers[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		Arrays.sort(numbers);
		solution(N, M, numbers);
	}

	private static void solution(int N, int M, int[] numbers) {
		int left = 1;
		int right = numbers[N - 1] - numbers[0];
		int answer = -1;
		while (left <= right) {
			int pivot = numbers[0];
			int count = 1;
			int minDistance = (left + right) / 2;
			for (int idx = 1; idx < N; idx++) {
				int distance = numbers[idx] - pivot;
				if (distance >= minDistance) {
					count++;
					pivot = numbers[idx];
				}
			}
			if (count >= M) {
				answer = Math.max(answer, minDistance);
				left = minDistance + 1;
			} else {
				right = minDistance - 1;
			}
		}
		System.out.println(answer);
	}
}
