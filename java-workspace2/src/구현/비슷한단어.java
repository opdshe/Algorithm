package 구현;

import java.util.*;

public class 비슷한단어 {
	static Scanner scanner = new Scanner(System.in);
	static List<String> convertedWord = new ArrayList<>();

	public static void main(String[] args) {
		int countOfWord = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < countOfWord; i++) {
			String word = scanner.nextLine();
			convertedWord.add(getConvertedWord(word));
		}

		int answer = 0;
		for (int pivotIdx = 0; pivotIdx < countOfWord - 1; pivotIdx++) {
			String pivot = convertedWord.get(pivotIdx);
			for (int targetIdx = pivotIdx + 1; targetIdx < countOfWord; targetIdx++) {
				String target = convertedWord.get(targetIdx);
				if (pivot.equals(target)) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static String getConvertedWord(String word) {
		Map<Character, String> map = new HashMap<>();
		StringBuilder result = new StringBuilder();
		int num = 1;
		for (int idx = 0; idx < word.length(); idx++) {
			if (map.containsKey(word.charAt(idx))) {
				result.append(map.get(word.charAt(idx)));
			} else {
				map.put(word.charAt(idx), String.valueOf(num));
				num++;
			}
		}
		return result.toString();
	}
}
