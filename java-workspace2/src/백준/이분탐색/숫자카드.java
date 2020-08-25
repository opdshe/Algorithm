package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = scanner.nextInt();
		}
		int M = scanner.nextInt();

		Arrays.sort(cards);
		for (int i = 0; i < M; i++) {
			int target = scanner.nextInt();
			System.out.print(binarySearch(cards, target) + " ");
		}
	}

	private static int binarySearch(int[] cards, int target) {
		int left = 0;
		int right = cards.length - 1;
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int value = cards[mid];
			if (value > target) {
				right = mid - 1;
				continue;
			} else if (value < target) {
				left = mid + 1;
				continue;
			}
			answer = 1;
			break;
		}
		return answer;
	}
}
