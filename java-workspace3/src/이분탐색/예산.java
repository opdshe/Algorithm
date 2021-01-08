package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 예산 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfCity = scanner.nextInt();
        int[] cities = new int[countOfCity];
        for (int idx = 0; idx < countOfCity; idx++) {
            cities[idx] = scanner.nextInt();
        }
        int total = scanner.nextInt();

        long maxMoney = getMaxMoney(cities, total);
        System.out.println(maxMoney);
    }

    private static long getMaxMoney(int[] cities, int total) {
        Arrays.sort(cities);
        long left = 1;
        long right = cities[cities.length - 1];
        long maxMoney = 0;
        while (left <= right) {
            long money = (left + right) / 2;
            long sum = 0;
            for (int city : cities) {
                if (city >= money) {
                    sum += money;
                } else {
                    sum += city;
                }
            }
            if (sum > total) {
                right = money - 1;
            } else {
                maxMoney = Math.max(maxMoney, money);
                left = money + 1;
            }
        }
        return maxMoney;
    }
}
