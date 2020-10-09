package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수고르기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] numbers = new int[input[0]];
		for (int idx = 0; idx < input[0]; idx++) {
			numbers[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		Arrays.sort(numbers);
		solution(numbers, input[0], input[1]);
	}

	private static void solution(int[] numbers, int countOfNumber, int minDistance) {
		int left = 0;
		int right = 0;
		int diff = Integer.MAX_VALUE;

		while (right < countOfNumber) {
			int currentDiff = Math.abs(numbers[right] - numbers[left]);
			if (currentDiff >= minDistance) {
				if (currentDiff == minDistance) {
					diff = minDistance;
					break;
				}
				diff = Math.min(diff, currentDiff);
				left++;
			} else {
				right++;
			}
		}
		System.out.println(diff);
	}
}
