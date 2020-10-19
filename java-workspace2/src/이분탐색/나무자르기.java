package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나무자르기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] woods = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		solution(woods, input[0], input[1]);
	}

	private static void solution(int[] woods, int countOfWood, int target) {
		Arrays.sort(woods);
		int left = 0;
		int right = woods[countOfWood - 1];
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for (int wood : woods) {
				if (wood > mid) {
					sum += wood - mid;
				}
			}
			if (sum >= target) {
				answer = Math.max(answer, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
