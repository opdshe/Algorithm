package 테스트;

public class NQUEEN {
    static int[] column = new int[9];

    public static void main(String[] args) {

        backtracking(0, 8);
    }

    private static boolean backtracking(int level, int size) {
        if (level == size) {
            for (int i = 0; i < size; i++) {
                System.out.println(String.valueOf(i) + column[i]);
            }
            return true;
        } else if (!isAvailablePosition(level)) {
            System.out.println("column[" + level + "] =" + column[level] + " impossible");
            return false;
        }
        for (int i = 0; i < size; i++) {
            column[level + 1] = i;
            System.out.println("column[" + (level + 1) + "] =" + i);
            if (backtracking(level + 1, size)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAvailablePosition(int level) {
        if (level == 0) {
            return true;
        }
        for (int i = 0; i < level; i++) {
            if (column[i] == column[level]) {
                return false;
            }
        }
        return Math.abs(column[level - 1] - column[level]) != 1;
    }
}
