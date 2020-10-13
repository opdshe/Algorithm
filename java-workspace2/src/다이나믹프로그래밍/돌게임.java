package 다이나믹프로그래밍;

import java.util.Scanner;

public class 돌게임 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		System.out.println(target % 2 == 0 ? "SK" : "CY");
	}
}
