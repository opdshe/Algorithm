package 백준.dfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Integer> cost = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cost.get(i) * (N - i);
        }
        System.out.println(sum);
    }
}
