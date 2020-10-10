package 기출.카카오;

import java.util.Arrays;

public class 예산 {
	public static void main(String[] args) {
		solution(new int[]{1, 3, 2, 5, 4}, 9);
	}

	public static int solution(int[] d, int budget) {
		Arrays.sort(d);
		int sum = 0;
		int answer = -1;
		for (int idx = 0; idx < d.length; idx++) {
			if (sum + d[idx] <= budget) {
				sum += d[idx];
			} else {
				answer = idx;
				break;
			}
		}
		if (answer == -1) {
			answer = d.length;
		}
		return answer;
	}
}
