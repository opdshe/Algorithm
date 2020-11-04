package 구현;

import java.util.Scanner;

public class 소수찾기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int count = 0;
		for (int idx = 0; idx < countOfNumber; idx++) {
			int target = scanner.nextInt();
			if (target == 1) {
				continue;
			}
			int rootTarget = (int) Math.sqrt(target);
			boolean isPrime = true;
			for (int num = 2; num <= rootTarget; num++) {
				if (target % num == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) count++;
		}
		System.out.println(count);
	}

}
