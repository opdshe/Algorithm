package 백준;

import java.util.*;

public class 동전0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0];
        int money = input[1];
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(scanner.nextLine()));
        }
        coins.sort(Comparator.reverseOrder());

        int answer = 0;
        for (Integer coin : coins) {
            while (coin <= money) {
                money -= coin;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
