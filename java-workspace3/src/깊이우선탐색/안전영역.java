package 깊이우선탐색;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 안전영역 {
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static int[][] map;
    static int answer = 0;
    static int minHeight = Integer.MAX_VALUE;
    static int maxHeight = Integer.MIN_VALUE;
    static List<int[]> directions = Arrays.asList(
            new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}
    );

    public static void main(String[] args) {
        size = scanner.nextInt();
        map = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int value = scanner.nextInt();
                map[row][column] = value;
                minHeight = Math.min(minHeight, value);
                maxHeight = Math.max(maxHeight, value);
            }
        }
        for (int height = 0; height <= maxHeight; height++) {
            boolean[][] visited = new boolean[size][size];
            int count = 0;
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    if (map[row][column] > height && !visited[row][column]) {
                        dfs(visited, height, row, column);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    private static void dfs(boolean[][] visited, int height, int row, int column) {
        visited[row][column] = true;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (isAvailable(nextRow, nextColumn) && !visited[nextRow][nextColumn] &&
                    map[nextRow][nextColumn] > height) {
                dfs(visited, height, nextRow, nextColumn);
            }
        }
    }


    private static boolean isAvailable(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < size &&
                nextColumn >= 0 && nextColumn < size;
    }
}
