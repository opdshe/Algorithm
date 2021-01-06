package 구현;

import java.util.ArrayList;
import java.util.List;

public class 프렌즈블록 {
    static List<Block>[] blocks;
    static int maxRow;
    static int maxColumn;
    static int countOfRemoval = 0;

    public static void main(String[] args) {
        solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println(countOfRemoval);
    }

    public static int solution(int m, int n, String[] board) {
        blocks = new ArrayList[n];
        maxRow = m;
        maxColumn = n;
        for (int column = 0; column < n; column++) {
            blocks[column] = new ArrayList<>();
        }
        for (int column = 0; column < n; column++) {
            for (int row = m - 1; row >= 0; row--) {
                blocks[column].add(new Block(board[row].charAt(column)));
            }
        }
        checkDestroyFromAll();
        while (hasDestroyFromTotal()) {
            for (int column = 0; column < maxColumn; column++) {
                if (hasDestroy(blocks[column])) {
                    pull(blocks[column]);
                }
            }
            checkDestroyFromAll();
        }
        return countOfRemoval;
    }

    private static boolean hasDestroyFromTotal() {
        for (int column = 0; column < maxColumn; column++) {
            if (hasDestroy(blocks[column])) {
                return true;
            }
        }
        return false;
    }

    private static void pull(List<Block> list) {
        int currentSize = list.size();
        list.removeIf(block -> block.destroy);
        countOfRemoval += currentSize - list.size();
    }

    private static boolean hasDestroy(List<Block> list) {
        return list.stream()
                .anyMatch(block -> block.destroy);
    }

    private static void checkDestroyFromAll() {
        for (int column = 0; column < maxColumn; column++) {
            for (int row = 0; row < maxRow; row++) {
                if (isSquare(row, column)) {
                    checkDestroy(row, column);
                }
            }
        }
    }

    private static void checkDestroy(int row, int column) {
        for (int r = row; r < row + 2; r++) {
            for (int c = column; c < column + 2; c++) {
                blocks[c].get(r).destroy = true;
            }
        }
    }

    private static boolean isSquare(int row, int column) {
        try {
            char name = blocks[column].get(row).name;
            for (int r = row; r < row + 2; r++) {
                for (int c = column; c < column + 2; c++) {
                    if (blocks[c].get(r).name != name) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static class Block {
        char name;
        boolean destroy;

        public Block(char name) {
            this.name = name;
        }
    }
}
