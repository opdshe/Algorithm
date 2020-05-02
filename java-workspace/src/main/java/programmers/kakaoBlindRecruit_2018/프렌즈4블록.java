package programmers.kakaoBlindRecruit_2018;

import static java.lang.Character.toLowerCase;

public class 프렌즈4블록 {
    private static Character[][] board;
    private static int count = 0;
    private static int row;
    private static int column;

    public static void main(String[] args) {
        solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
    }

    public static int solution(int m, int n, String[] strBoard) {
        row = m;
        column = n;
        board = makeBoard(strBoard);
        int tempCount;
        do {
            tempCount = count;
            playOneCycle();
            for (int i = 0; i < column; i++) {
                while(hasLowerCase(i)) {
                    pullBack(i);
                }
            }
        } while (tempCount!=count);
        System.out.println(count);
        return count;
    }

    private static void pullBack(int column) {
        int idx = 0;
        for (int i = row -1 ; i >= 0 ; i--) {
            if (Character.isLowerCase(board[i][column])) {
                idx = i;
                break;
            }
        }
        for(int i = idx; i >= 0; i --) {
            if (i == 0) {
                board[i][column] = '0';
                break;
            }
            board[i][column] = board[i-1][column];
        }
        count ++;
    }
    private static boolean hasLowerCase(int column) {
        for (int i = 0 ; i < row ; i++) {
            if (Character.isLowerCase(board[i][column])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAllUpperCase() {
        for (int i = 0; i < column; i++) {
            if (hasLowerCase(i)) {
                return false;
            }
        }
        return true;
    }

    private static Character[][] makeBoard(String[] strBoard) {
        Character[][] newBoard = new Character[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newBoard[i][j] = strBoard[i].charAt(j);
            }
        }
        return newBoard;
    }

    private static void playOneCycle() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                checkSquare(r, c);
            }
        }
    }

    private static void checkSquare(int r, int c) {
        if (isSquareSame(r, c)) {
            board[r][c] = toLowerCase(board[r][c]);
            board[r][c + 1] = toLowerCase(board[r][c + 1]);
            board[r + 1][c] = toLowerCase(board[r + 1][c]);
            board[r + 1][c + 1] = toLowerCase(board[r + 1][c + 1]);
        }
    }

    private static boolean isSquareSame(int r, int c) {
        Character character = board[r][c];
        if (character == '0') {
            return false;
        }
        if (!isCorrectRange(r, c)) {
            return false;
        }
        return isSameCharacter(board[r][c + 1], character) && isSameCharacter(board[r + 1][c], character) && isSameCharacter(board[r + 1][c + 1], character);
    }

    private static boolean isCorrectRange(int r, int c) {
        return r + 1 < row && c + 1 < column;
    }

    public static boolean isSameCharacter(Character a, Character b) {
        return a.toString().equalsIgnoreCase(b.toString());
    }
}
