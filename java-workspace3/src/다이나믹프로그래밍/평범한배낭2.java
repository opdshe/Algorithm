package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 평범한배낭2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfItem = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        items.add(new Item(0, 0));
        for (int i = 0; i < countOfItem; i++) {
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            int count = scanner.nextInt();
            for (int c = 1; c <= count; c++) {
                items.add(new Item(weight * c, value * c));
            }
        }
        items.sort(Comparator.comparing(item -> item.weight));
        long maxValue = getMaxValue(items, maxWeight);
        System.out.println(maxValue);
    }

    private static long getMaxValue(List<Item> items, int maxWeight) {
        long[][] dp = new long[items.size() + 1][maxWeight + 1];
        for (int itemIdx = 1; itemIdx <= items.size() - 1; itemIdx++) {
            for (int weight = 1; weight <= maxWeight; weight++) {
                Item item = items.get(itemIdx);
                if (weight >= item.weight) {
                    dp[itemIdx][weight] = Math.max(dp[itemIdx - 1][weight],
                            dp[itemIdx - 1][weight - item.weight] + item.value);
                } else {
                    dp[itemIdx][weight] = dp[itemIdx - 1][weight];
                }
            }
        }
        return dp[items.size() - 1][maxWeight];
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
