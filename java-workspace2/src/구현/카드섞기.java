package 구현;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 카드섞기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCard = scanner.nextInt();
		int[] target = new int[countOfCard];
		int[] shuffleRule = new int[countOfCard];
		int[] cards = new int[countOfCard];
		for (int idx = 0; idx < countOfCard; idx++) {
			target[idx] = scanner.nextInt();
			cards[idx] = idx;
		}
		for (int idx = 0; idx < countOfCard; idx++) {
			shuffleRule[idx] = scanner.nextInt();
		}

		Set<String> candidateSet = new HashSet<>();
		int time = 0;
		while (true) {
			if (isValid(target, cards, countOfCard)) {
				break;
			}
			String strCards = toString(cards, countOfCard);
			if (candidateSet.contains(strCards)) {
				time = -1;
				break;
			} else {
				candidateSet.add(strCards);
			}
			cards = shuffle(cards, shuffleRule);
			time++;
		}
		System.out.println(time);
	}

	private static String toString(int[] cards, int countOfCards) {
		StringBuilder result = new StringBuilder();
		for (int idx = 0; idx < countOfCards; idx++) {
			result.append(cards[idx]);
		}
		return result.toString();
	}

	private static boolean isValid(int[] target, int[] cards, int countOfCards) {
		boolean isValid = true;
		for (int idx = 0; idx < target.length; idx++) {
			int correctPosition = target[idx];
			boolean hasTarget = false;
			for (int candidate = correctPosition; candidate < countOfCards; candidate += 3) {
				if (cards[candidate] == idx) {
					hasTarget = true;
					break;
				}
			}
			if (!hasTarget) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	private static int[] shuffle(int[] origin, int[] shuffleRule) {
		int[] shuffledCard = new int[origin.length];
		for (int idx = 0; idx < origin.length; idx++) {
			shuffledCard[shuffleRule[idx]] = origin[idx];
		}
		return shuffledCard;
	}
}
