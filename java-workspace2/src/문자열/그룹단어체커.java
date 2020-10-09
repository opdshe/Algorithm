package 문자열;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 그룹단어체커 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfWord = scanner.nextInt();
		int count = 0;
		scanner.nextLine();
		for (int idx = 0; idx < countOfWord; idx++) {
			String word = scanner.nextLine();
			if (isGroupWord(word)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean isGroupWord(String word) {
		Map<Character, Boolean> map = new HashMap<>();
		boolean isOkay = true;
		for (int idx = 0; idx < word.length(); idx++) {
			if (map.containsKey(word.charAt(idx))) {
				if (word.charAt(idx - 1) != word.charAt(idx)) {
					isOkay = false;
					break;
				}
				continue;
			}
			map.put(word.charAt(idx), true);
		}
		return isOkay;
	}
}
