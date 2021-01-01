package 구현;

public class 가장큰정사각형찾기 {
    public static void main(String[] args) {

    }

    public static int solution(int[][] board) {
        int answer = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 1) {
                    try {
                        int size = 1;
                        while (isSquare(board, row, column, size)) {
                            answer = Math.max(answer, size * size);
                            size++;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean isSquare(int[][] board, int row, int column, int size) {
        for (int r = row; r < row + size; r++) {
            for (int c = column; c < column + size; c++) {
                if (board[r][c] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
