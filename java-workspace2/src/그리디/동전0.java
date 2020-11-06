package 그리디;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 동전0 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCoins = scanner.nextInt();
		List<Integer> coins = new ArrayList<>();
		int target = scanner.nextInt();
		for (int idx = 0; idx < countOfCoins; idx++) {
			coins.add(scanner.nextInt());
		}
		coins.sort(Comparator.reverseOrder());
		solution(coins, target);
	}

	private static void solution(List<Integer> coins, int target) {
		int count = 0;
		for (Integer coin : coins) {
			if (target >= coin) {
				count += target / coin;
				target %= coin;
			}
		}
		System.out.println(count);
	}
}
