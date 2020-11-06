package 문자열;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 단어나누기 {
	static List<String> candidates = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.nextLine();
		for (int first = 1; first < input.length() - 1; first++) {
			for (int second = first + 1; second < input.length(); second++) {
				String firstWord = new StringBuilder(input.substring(0, first)).reverse().toString();
				String secondWord = new StringBuilder(input.substring(first, second)).reverse().toString();
				String thirdWord = new StringBuilder(input.substring(second)).reverse().toString();
				candidates.add(firstWord + secondWord + thirdWord);
			}
		}
		candidates.sort(Comparator.naturalOrder());
		System.out.println(candidates.get(0));
	}

}
