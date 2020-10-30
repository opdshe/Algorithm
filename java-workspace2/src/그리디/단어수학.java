package 그리디;

import java.util.*;

public class 단어수학 {
	static Scanner scanner = new Scanner(System.in);
	static int[] values = new int[26];
	static List<Alpha> alphaList = new ArrayList<>();

	public static void main(String[] args) {
		for (int idx = 65; idx <= 90; idx++) {
			alphaList.add(new Alpha((char) idx));
		}
		int countOfWord = scanner.nextInt();
		String[] words = new String[countOfWord];
		scanner.nextLine();
		for (int count = 0; count < countOfWord; count++) {
			String word = scanner.nextLine();
			words[count] = word;
			for (int idx = word.length() - 1; idx >= 0; idx--) {
				char c = word.charAt(idx);
				Alpha alpha = alphaList.get((int) c - 65);
				alpha.count += Math.pow(10, (word.length() - idx - 1));
			}
		}
		alphaList.sort(Comparator.comparing(alpha -> alpha.count));
		Collections.reverse(alphaList);

		for (int idx = 0; idx <= 9; idx++) {
			Alpha alpha = alphaList.get(idx);
			values[(int) alpha.alphabet - 65] = 9 - idx;
		}

		int answer = 0;
		for (String word : words) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int idx = 0; idx < word.length(); idx++) {
				stringBuilder.append(values[(int) word.charAt(idx) - 65]);
			}
			answer += Integer.parseInt(stringBuilder.toString());
		}
		System.out.println(answer);
	}

	private static class Alpha {
		private char alphabet;
		private int count;
		private int value;

		public Alpha(char alphabet) {
			this.alphabet = alphabet;
		}
	}
}
