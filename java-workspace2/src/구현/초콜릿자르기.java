package 구현;

import java.util.Scanner;

public class 초콜릿자르기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		System.out.println(row * column - 1);
	}
}
