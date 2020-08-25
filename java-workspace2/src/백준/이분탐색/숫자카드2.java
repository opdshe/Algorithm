package 백준.이분탐색;

import java.util.Scanner;

public class 숫자카드2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] cards = new int[20000001];
		for (int i = 0; i < N; i++) {
			int value = scanner.nextInt();
			cards[value + 10000000] += 1;
		}
		int M = scanner.nextInt();
		for (int i = 0; i < M; i++) {
			int value = scanner.nextInt();
			System.out.print(cards[value + 10000000] + " ");
		}
	}
}