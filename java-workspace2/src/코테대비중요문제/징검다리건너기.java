package 코테대비중요문제;

import java.util.Arrays;

public class 징검다리건너기 {
	public static void main(String[] args) {
		solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
	}

	public static int solution(int[] stones, int k) {
		return binarySearch(stones, k);
	}

	private static int binarySearch(int[] stones, int k) {
		long left = 0;
		long right = Arrays.stream(stones)
				.max()
				.getAsInt();
		int answer = 0;

		while (left <= right) {
			long pass = (left + right) / 2;
			int jump = 0;
			boolean isAvailable = true;
			for (int stone : stones) {
				if (stone - pass <= 0) {
					jump++;
				} else {
					jump = 0;
				}
				if (jump >= k) {
					isAvailable = false;
					break;
				}
			}
			if (isAvailable) {
				answer = Math.max(answer, (int) pass + 1);
				left = pass + 1;
			} else {
				right = pass - 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}