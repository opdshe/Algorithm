package 깊이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 단지번호붙이기 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> directions = Arrays.asList(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void init() throws IOException {
        size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];
        for (int row = 0; row < size; row++) {
            map[row] = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void solution() {
        List<Integer> answers = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (map[row][column] == 1 && !visited[row][column]) {
                    answers.add(dfs(row, column));
                }
            }
        }
        answers.sort(Comparator.naturalOrder());
        System.out.println(answers.size());
        answers.forEach(System.out::println);
    }

    private static int dfs(int row, int column) {
        int sum = 1;
        visited[row][column] = true;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (isAvailablePosition(nextRow, nextColumn) && map[nextRow][nextColumn] == 1 &&
                    !visited[nextRow][nextColumn]) {
                sum += dfs(nextRow, nextColumn);
            }
        }
        return sum;
    }


    private static boolean isAvailablePosition(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < size &&
                nextColumn >= 0 && nextColumn < size;
    }
}
