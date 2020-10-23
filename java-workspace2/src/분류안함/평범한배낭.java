package 분류안함;

import java.util.Scanner;

public class 평범한배낭 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfItem = scanner.nextInt();
		int maxWeight = scanner.nextInt();
		Item[] items = new Item[countOfItem + 1];
		for (int idx = 1; idx <= countOfItem; idx++) {
			int weight = scanner.nextInt();
			int value = scanner.nextInt();
			items[idx] = new Item(weight, value);
		}
		solution(items, countOfItem, maxWeight);
	}

	private static void solution(Item[] items, int countOfItem, int maxWeight) {
		long[][] dp = new long[countOfItem + 1][maxWeight + 1];
		for (int weight = items[1].weight; weight <= maxWeight; weight++) {
			dp[1][weight] = items[1].value;
		}
		for (int itemIdx = 2; itemIdx <= countOfItem; itemIdx++) {
			Item item = items[itemIdx];
			for (int weight = 1; weight <= maxWeight; weight++) {
				dp[itemIdx][weight] = dp[itemIdx - 1][weight];
				if (weight >= item.weight) {
					dp[itemIdx][weight] = Math.max(dp[itemIdx][weight], dp[itemIdx - 1][weight - item.weight] + item.value);
				}
			}
		}
		/*for (int idx = 1; idx <= countOfItem; idx++) {
			for (int weight = 1; weight <= maxWeight; weight++) {
				System.out.print(dp[idx][weight] + " ");
			}
			System.out.println();
		}*/
		System.out.println(dp[countOfItem][maxWeight]);
	}

	private static class Item {
		private int weight;
		private int value;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}
