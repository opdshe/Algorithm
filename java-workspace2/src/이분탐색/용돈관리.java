package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 용돈관리 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] days = new int[input[0]];
		int sum = 0;
		for (int day = 0; day < input[0]; day++) {
			int value = Integer.parseInt(bufferedReader.readLine());
			days[day] = value;
			sum += value;
		}
		solution(days, input[0], input[1], sum);
	}

	private static void solution(int[] days, int countOfDays, int withdraw, int sum) {
		long left = Arrays.stream(days)
				.max()
				.getAsInt();
		long right = sum;
		long answer = right;

		while (left <= right) {
			long mid = (left + right) / 2;
			long current = mid;
			int countOfWithdraw = 1;
			for (int day : days) {
				if (current >= day) {
					current -= day;
				} else {
					countOfWithdraw++;
					current = mid - day;
				}
			}
			if (countOfWithdraw > withdraw) {
				left = mid + 1;
			} else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
