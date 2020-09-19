package 카카오.카카오2019인턴;

import java.util.Arrays;

public class 징검다리건너기 {
	public static void main(String[] args) {
		solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
	}

	public static int solution(int[] stones, int k) {
		return search(stones, k);
	}

	private static int search(int[] stones, int k) {
		int answer = -1;
		int left = 0;
		int right = Arrays.stream(stones)
				.max().getAsInt();
		while (left <= right) {
			int pass = (left + right) / 2;
			int jump = 0;
			//System.out.println("current pass " + pass);
			boolean isNotAvailableToGo = false;
			for (int i = 0; i < stones.length; i++) {
				if (stones[i] - pass <= 0) {
					jump++;
				} else {
					jump = 0;
				}
				if (jump >= k) {
					isNotAvailableToGo = true;
					break;
				}
			}
			if (isNotAvailableToGo) {
				//System.out.println("불가능");
				right = pass - 1;
			} else {
				//System.out.println("가능 ");
				answer = Math.max(answer, pass + 1);
				left = pass + 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}