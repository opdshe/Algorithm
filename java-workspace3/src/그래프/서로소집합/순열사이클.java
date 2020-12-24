package 그래프.서로소집합;

import java.util.Scanner;

public class 순열사이클 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = scanner.nextInt();
        for (int test = 0; test < testCase; test++) {
            int countOfNumber = scanner.nextInt();
            int[] numbers = new int[countOfNumber + 1];
            int[] parents = initParents(countOfNumber);
            for (int idx = 1; idx <= countOfNumber; idx++) {
                numbers[idx] = scanner.nextInt();
            }
            int count = 0;
            for (int idx = 1; idx <= countOfNumber; idx++) {
                if (idx == parents[idx]) {
                    dfs(numbers, parents, idx);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int[] numbers, int[] parents, int idx) {
        if (parents[idx] == parents[numbers[idx]]) {
            return;
        }
        union(parents, idx, numbers[idx]);
        dfs(numbers, parents, numbers[idx]);
    }

    private static void union(int[] parents, int a, int b) {
        int parentA = find(parents, a);
        int parentB = find(parents, b);
        if (parentA > parentB) {
            parents[parentA] = parentB;
        } else {
            parents[parentB] = parentA;
        }
    }

    private static int find(int[] parents, int target) {
        if (parents[target] != target) {
            parents[target] = find(parents, parents[target]);
        }
        return parents[target];
    }

    private static int[] initParents(int countOfNumber) {
        int[] parents = new int[countOfNumber + 1];
        for (int idx = 1; idx <= countOfNumber; idx++) {
            parents[idx] = idx;
        }
        return parents;
    }
}
