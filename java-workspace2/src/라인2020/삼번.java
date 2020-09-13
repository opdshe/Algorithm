package 라인2020;

import java.util.Arrays;

public class 삼번 {
	static int length;
	static int[] answer;

	public static void main(String[] args) {
		solution(10007);
	}

	public static int[] solution(int n) {
		length = String.valueOf(n).length();
		answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
		search(String.valueOf(n), 0);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static void search(String num, int count) {
		if (num.length() == 1) {
			if (count < answer[0]) {
				answer = new int[]{count, Integer.parseInt(num)};
			}
			return;
		}
		for (int i = 1; i < num.length(); i++) {
			String left = num.substring(0, i);
			String right = num.substring(i);
			if (left.length() != 1 && left.charAt(0) == '0' ||
					right.length() != 1 && right.charAt(0) == '0') {
				continue;
			}
			System.out.println("============");
			System.out.println(left);
			System.out.println(right);
			System.out.println(String.valueOf(Integer.parseInt(left) + Integer.parseInt(right)));
			System.out.println("============");

			search(String.valueOf(Integer.parseInt(left) + Integer.parseInt(right)), count + 1);
		}
	}
}
