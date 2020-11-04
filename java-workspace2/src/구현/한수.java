package 구현;

import java.util.Scanner;

public class 한수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int count = 0;
		for (int num = 1; num <= target; num++) {
			if (isHanNumber(num)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean isHanNumber(int num) {
		String convertedNum = String.valueOf(num);
		if (convertedNum.length() == 1) {
			return true;
		}
		int prevDiff = (int) convertedNum.charAt(1) - (int) convertedNum.charAt(0);
		boolean isHanNumber = true;
		for (int idx = 1; idx < convertedNum.length() - 1; idx++) {
			int diff = (int) convertedNum.charAt(idx + 1) - (int) convertedNum.charAt(idx);
			if (diff != prevDiff) {
				isHanNumber = false;
				break;
			}
		}
		return isHanNumber;
	}
}
