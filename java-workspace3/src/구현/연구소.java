package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 연구소 {
    static Scanner scanner = new Scanner(System.in);
    static int maxRow;
    static int maxColumn;
    static int[][] map;
    static List<int[]> blanks = new ArrayList<>();
    static int[] wallIdx;
    static List<int[]> directions = Arrays.asList(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );
    static int answer = 0;

    public static void main(String[] args) {
        init();
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int wallCount, int start) {
        if (wallCount == 3) {
            int[][] copyMap = deepCopy(map);
            for (int idx : wallIdx) {
                int[] wallPosition = blanks.get(idx);
                copyMap[wallPosition[0]][wallPosition[1]] = 1;
            }
            for (int row = 0; row < maxRow; row++) {
                for (int column = 0; column < maxColumn; column++) {
                    if (copyMap[row][column] == 2) {
                        spread(copyMap, row, column);
                    }
                }
            }
            answer = Math.max(answer, getSafeArea(copyMap));
            return;
        }
        for (int idx = start; idx < blanks.size(); idx++) {
            wallIdx[wallCount] = idx;
            dfs(wallCount + 1, idx + 1);
        }
    }

    private static int getSafeArea(int[][] map) {
        int count = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                if (map[row][column] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void spread(int[][] map, int row, int column) {
        map[row][column] = 2;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (isAvailable(nextRow, nextColumn) && map[nextRow][nextColumn] == 0) {
                spread(map, nextRow, nextColumn);
            }
        }
    }

    private static boolean isAvailable(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < maxRow &&
                nextColumn >= 0 && nextColumn < maxColumn;
    }

    private static void init() {
        maxRow = scanner.nextInt();
        maxColumn = scanner.nextInt();
        map = new int[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                int value = scanner.nextInt();
                map[row][column] = value;
                if (value == 0) {
                    blanks.add(new int[]{row, column});
                }
            }
        }
        wallIdx = new int[3];
    }

    private static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }
        return result;
    }
}
