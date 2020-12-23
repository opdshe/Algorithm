package 깊이우선탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 바이러스 {
    static Scanner scanner = new Scanner(System.in);
    static List<Integer>[] adjacent;
    static boolean[] visited;

    public static void main(String[] args) {
        int countOfComputer = scanner.nextInt();
        int countOfEdge = scanner.nextInt();
        adjacent = new List[countOfComputer + 1];
        visited = new boolean[countOfComputer + 1];

        for (int idx = 0; idx <= countOfComputer; idx++) {
            adjacent[idx] = new ArrayList<>();
        }
        for (int i = 0; i < countOfEdge; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            adjacent[source].add(dest);
            adjacent[dest].add(source);
        }
        int answer = dfs(1) - 1;
        System.out.println(answer);
    }

    private static int dfs(int computer) {
        visited[computer] = true;
        int sum = 1;
        for (Integer adj : adjacent[computer]) {
            if (!visited[adj]) {
                sum += dfs(adj);
            }
        }
        return sum;
    }
}
