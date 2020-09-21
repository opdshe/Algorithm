package 투포인터;

import java.util.Scanner;

public class 수열 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int K;

	public static void main(String[] args) {
		N = scanner.nextInt();
		K = scanner.nextInt();
		int[] temperates = new int[N];
		for (int i = 0; i < N; i++) {
			temperates[i] = scanner.nextInt();
		}
		solution(temperates);
	}

	private static int solution(int[] temperates) {
		int left = 0;
		int answer = -1;
		int right = 0;
		int currentSum = 0;
		while (true) {
			if (right - left >= K) {
				if (right - left == K) {
					answer = Math.max(answer, currentSum);
				}
				currentSum -= temperates[left];
				left++;
			} else if (right == N) {
				break;
			} else {
				currentSum += temperates[right];
				right++;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
