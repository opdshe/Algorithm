package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두수의합 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(bufferedReader.readLine());
		int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int target = Integer.parseInt(bufferedReader.readLine());
		Arrays.sort(numbers);
		solution(numbers, countOfNumber, target);
	}

	private static void solution(int[] numbers, int countOfNumber, int target) {
		int left = 0;
		int right = countOfNumber - 1;
		int count = 0;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum >= target) {
				if (sum == target) {
					count++;
				}
				right--;
			} else {
				left++;
			}
		}
		System.out.println(count);
	}
}
