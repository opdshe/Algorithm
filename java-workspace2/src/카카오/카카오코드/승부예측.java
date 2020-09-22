package 카카오.카카오코드;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 승부예측 {
	static Scanner scanner = new Scanner(System.in);
	static Map<String, Score> scores = new HashMap<>();

	public static void main(String[] args) {
		String[] inputs = Arrays.stream(scanner.nextLine().split(" "))
				.toArray(String[]::new);
		Arrays.stream(inputs).forEach((country) -> scores.put(country, new Score()));
		for (int i = 0; i < 6; i++) {
			String[] input = Arrays.stream(scanner.nextLine().split(" "))
					.toArray(String[]::new);
			//A win
			if (Float.parseFloat(input[2]) > Float.parseFloat(input[4])) {
				scores.get(input[0]).win();
				scores.get(input[1]).lose();
			} else if (Float.parseFloat(input[2]) < Float.parseFloat(input[4])) {
				scores.get(input[0]).lose();
				scores.get(input[1]).win();
			} else {
				scores.get(input[0]).draw();
				scores.get(input[1]).draw();
			}
		}
		for (Map.Entry<String, Score> stringScoreEntry : scores.entrySet()) {
			System.out.println(stringScoreEntry.getKey() + " " + stringScoreEntry.getValue().score);
		}

	}

	private static class Score {
		private int score;

		private void win() {
			score += 3;
		}

		private void draw() {
			score += 1;
		}

		private void lose() {
			score += 0;
		}
	}
}
