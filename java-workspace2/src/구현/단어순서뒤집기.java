package 구현;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 단어순서뒤집기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		scanner.nextLine();
		for (int test = 1; test <= testcase; test++) {
			List<String> inputs = Arrays.stream(scanner.nextLine().split(" "))
					.collect(Collectors.toList());
			Collections.reverse(inputs);
			String result = String.join(" ", inputs);
			System.out.println("Case #" + test + ": " + result);
		}
	}
}
