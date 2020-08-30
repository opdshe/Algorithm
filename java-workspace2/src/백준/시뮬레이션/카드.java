package 백준.시뮬레이션;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 카드 {
	static int N;
	static List<Integer> cards;
	static List<Integer> removedCards = new ArrayList<>();
	static int turn = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		cards = IntStream.rangeClosed(1, N)
				.boxed()
				.collect(Collectors.toList());
		while (cards.size() > 1) {
			if (turn % 2 == 1) {
				removedCards.add(cards.remove(0));
			} else {
				cards.add(cards.remove(0));
			}
			turn++;
		}
		for (Integer removedCard : removedCards) {
			System.out.print(removedCard + " ");
		}
		System.out.print(cards.get(0));
	}
}
