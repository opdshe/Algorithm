package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 평범한배낭 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfItem = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        Item[] items = new Item[countOfItem + 1];
        items[0] = new Item(0, 0);
        for (int i = 1; i <= countOfItem; i++) {
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }
        Arrays.sort(items, Comparator.comparing(item -> item.weight));
        int answer = getMaxValue(items, countOfItem, maxWeight);
    }

    private static int getMaxValue(Item[] items, int countOfItem, int maxWeight) {
        int[][] dp = new int[countOfItem + 1][maxWeight + 1];
        for (int itemIdx = 1; itemIdx <= countOfItem; itemIdx++) {
            for (int weight = 1; weight <= maxWeight; weight++) {
                Item item = items[itemIdx];
                if (weight >= item.weight) {
                    dp[itemIdx][weight] = Math.max(dp[itemIdx - 1][weight],
                            dp[itemIdx - 1][weight - item.weight] + item.value);
                } else {
                    dp[itemIdx][weight] = dp[itemIdx - 1][weight];
                }
            }
        }
        System.out.println(dp[countOfItem][maxWeight]);
        return dp[countOfItem][maxWeight];
    }

    private static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
