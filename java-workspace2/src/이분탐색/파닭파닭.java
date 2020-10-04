package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파닭파닭 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int countOfPa = input[0];
		int countOfChicken = input[1];
		int[] paLength = new int[countOfPa];
		for (int idx = 0; idx < countOfPa; idx++) {
			paLength[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		solution(paLength, countOfPa, countOfChicken);
	}

	private static void solution(int[] paLength, int countOfPa, int countOfChicken) {
		Arrays.sort(paLength);
		long left = 0;
		long right = paLength[countOfPa - 1];
		long answerLength = -1;
		while (left <= right) {
			int share = 0;
			int remainder = 0;
			long mid = (left + right) / 2;
			for (int length : paLength) {
				remainder += length % mid;
				share += (length / mid);
			}
			if (share < countOfChicken) {
				right = mid - 1;
			} else {
				answerLength = mid;
				left = mid + 1;
			}
		}
		long total = 0;
		for (int i : paLength) {
			total += i;
		}
		System.out.println(total - (answerLength * countOfChicken));
	}
}
