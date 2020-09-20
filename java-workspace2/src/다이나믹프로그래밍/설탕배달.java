package 다이나믹프로그래밍;

import java.util.Scanner;

public class 설탕배달 {
	static int target;
	static int ans = -1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		target = scanner.nextInt();
		int maxFive = target / 5;
		for (int i = maxFive; i >= 0; i--) {
			if ((target - (i * 5)) % 3 != 0) {
				continue;
			}
			ans = i + (target - (i * 5)) / 3;
			break;
		}
		System.out.println(ans);
	}
}
