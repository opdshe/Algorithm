package 그리디;

import java.util.Scanner;

public class 일이될때까지 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		search(N, K);
	}

	private static int search(int N, int K) {
		int count = 0;
		while (true) {
			int target = (N / K) * K;
			count += N - target;
			N = target;

			if (N < K) {
				break;
			}

			N /= K;
			count++;
		}
		count += N - 1;
		System.out.println(count);
		return count;
	}
}
