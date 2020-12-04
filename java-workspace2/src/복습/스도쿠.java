package 복습;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스도쿠 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map = new int[9][9];
    private static List<int[]> blanks = new ArrayList<>();
    private static int[][] answer;

    public static void main(String[] args) {
        init();
        dfs(0);
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                System.out.print(answer[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void init() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                int value = scanner.nextInt();
                map[row][column] = value;
                if (value == 0) {
                    blanks.add(new int[]{row, column});
                }
            }
        }
    }

    private static void dfs(int blankIdx) {
        if (blankIdx == blanks.size()) {
            answer = deepCopy(map);
            return;
        }
        int targetRow = blanks.get(blankIdx)[0];
        int targetColumn = blanks.get(blankIdx)[1];
        for (int number = 1; number <= 9; number++) {
            boolean isAvailable = isAvailableRow(number, targetColumn) && isAvailableColumn(number, targetRow) &&
                    isAvailableSquare(number, targetRow, targetColumn);
            if (isAvailable) {
                map[targetRow][targetColumn] = number;
                dfs(blankIdx + 1);
                map[targetRow][targetColumn] = 0;
            }
        }
    }

    private static boolean isAvailableSquare(int number, int targetRow, int targetColumn) {
        int startRow = (targetRow / 3) * 3;
        int startColumn = (targetColumn / 3) * 3;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                if (map[row][column] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAvailableRow(int number, int targetColumn) {
        for (int row = 0; row < 9; row++) {
            if (map[row][targetColumn] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAvailableColumn(int number, int targetRow) {
        boolean result = true;
        for (int column = 0; column < 9; column++) {
            if (map[targetRow][column] == number) {
                return false;
            }
        }
        return true;
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
