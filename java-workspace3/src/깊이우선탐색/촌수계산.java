package 깊이우선탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 촌수계산 {
    static Scanner scanner = new Scanner(System.in);
    static int answer = -1;

    public static void main(String[] args) {
        int countOfPeople = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int countOfEdge = scanner.nextInt();
        List<Integer>[] adjacent = new List[countOfPeople + 1];
        boolean[] visited = new boolean[countOfPeople + 1];
        for (int idx = 1; idx <= countOfPeople; idx++) {
            adjacent[idx] = new ArrayList<>();
        }
        for (int i = 0; i < countOfEdge; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            adjacent[parent].add(child);
            adjacent[child].add(parent);
        }
        dfs(visited, adjacent, a, b, 0);
        System.out.println(answer);
    }

    private static void dfs(boolean[] visited, List<Integer>[] adjacent, int current, int target, int count) {
        if (current == target) {
            answer = count;
        }
        visited[current] = true;
        for (Integer adj : adjacent[current]) {
            if (!visited[adj]) {
                dfs(visited, adjacent, adj, target, count + 1);
            }
        }
    }
}
