package 코테대비중요문제;

import java.util.Arrays;

public class 징검다리건너기 {
	public static void main(String[] args) {
		solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
	}

	public static int solution(int[] stones, int k) {
		int left = 0;
		int right = Arrays.stream(stones)
				.max()
				.getAsInt();
		int answer = 0;
		while (left <= right) {
			boolean isOkay = true;
			int passed = (left + right) / 2;
			int jump = 0;
			for (int stone : stones) {
				int realValue = stone - passed;
				if (realValue <= 0) {
					jump++;
				} else {
					jump = 0;
				}
				if (jump == k) {
					isOkay = false;
					break;
				}
			}
			if (isOkay) {
				answer = Math.max(answer, passed + 1);
				left = passed + 1;
			} else {
				right = passed - 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}