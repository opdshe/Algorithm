package 기출.우테코;

import java.util.Arrays;

public class 일번 {
	public static void main(String[] args) {
		solution(15000);
	}

	private static int[] solution(int money) {
		int[] units = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		int[] answer = new int[9];
		for (int idx = 0; idx < 9; idx++) {
			if (money >= units[idx]) {
				answer[idx] = money / units[idx];
				money %= units[idx];
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
