package 테스트;

import java.util.function.Predicate;

public class MyMain {
	public static void main(String[] args) {
		Predicate<String> p = (String s) -> true;
		System.out.println(p.test("hi"));
	}

	private static boolean isAlpha(String origin) {
		return origin.matches("[a-zA-Z]*$");
	}

	private static boolean isDigit(String origin) {
		return origin.matches("[0-9]*$");
	}
}
