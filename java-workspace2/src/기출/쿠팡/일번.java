package 기출.쿠팡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일번 {
	public static void main(String[] args) {
		solution(10);
	}

	private static int[] solution(int N) {
		int maxValue = -1;
		int maxK = -1;
		for (int unit = 2; unit < 10; unit++) {
			String converted = convert(N, unit);
			int mul = 1;
			for (int idx = 0; idx < converted.length(); idx++) {
				if (converted.charAt(idx) != '0') {
					mul *= Integer.parseInt(String.valueOf(converted.charAt(idx)));
				}
			}
			if (mul >= maxValue) {
				maxValue = mul;
				maxK = unit;
			}
		}
		System.out.println(maxK + " " + maxValue);
		return new int[]{maxK, maxValue};
	}

	private static String convert(int N, int unit) {
		List<Integer> numbers = new ArrayList<>();
		while (N > 0) {
			numbers.add(N % unit);
			N /= unit;
		}
		Collections.reverse(numbers);
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer number : numbers) {
			stringBuilder.append(number);
		}
		return stringBuilder.toString();
	}
}