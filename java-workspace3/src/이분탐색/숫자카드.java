package 이분탐색;

import java.io.*;
import java.util.Arrays;

public class 숫자카드 {
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int countOfCard = Integer.parseInt(bufferedReader.readLine());
		int[] cards = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Arrays.sort(cards);
		int countOfTarget = Integer.parseInt(bufferedReader.readLine());
		int[] targets = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int idx = 0; idx < countOfTarget; idx++) {
			bufferedWriter.write(String.valueOf(hasTarget(cards, targets[idx])));
			bufferedWriter.write(" ");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}

	private static int hasTarget(int[] cards, int target) {
		int left = 0;
		int right = cards.length - 1;
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midValue = cards[mid];
			if (target > midValue) {
				left = mid + 1;
			} else if (target < midValue) {
				right = mid - 1;
			} else {
				answer = 1;
				break;
			}
		}
		return answer;
	}
}
