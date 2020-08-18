package 백준.dfs;

import java.util.Scanner;

public class 로또 {
    static boolean[] visited;
    static int countOfNumbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            countOfNumbers = scanner.nextInt();
            if (countOfNumbers == 0) {
                return;
            }

            visited = new boolean[countOfNumbers];
            String[] lotto = new String[countOfNumbers];

            for (int i = 0; i < countOfNumbers; i++) {
                lotto[i] = String.valueOf(scanner.nextInt());
            }

            dfs(lotto, 0, 0);
            System.out.println();
        }
    }

    private static void dfs(String[] lotto, int idx, int count) {
        if (count == 6) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < countOfNumbers; i++) {
                if (visited[i]) {
                    System.out.print(lotto[i] + " ");
                    //answer.append(lotto[i]).append(" ");
                }
            }
            System.out.println();
            //System.out.println(answer);
        }
        for (int i = idx; i < countOfNumbers; i++) {
            visited[i] = true;
            dfs(lotto, i + 1, count + 1);
            visited[i] = false;
        }
    }
}
