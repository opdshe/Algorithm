package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 디저트_카페 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board;
    static boolean[][] visitBoard;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(bf.readLine().trim());
        for (int i = 0; i < testCase; i++) {
            answer = 0;
            N = Integer.parseInt(bf.readLine().trim());
            board = createBoard(N);
            visitBoard = createVisitBoard();
            run();
        }
    }

    private static int[][] createBoard(int N) throws IOException {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return board;
    }

    private static boolean[][] createVisitBoard() {
        return new boolean[N][N];
    }

    private static void run() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                makeSquare(i, j, i, j, new ArrayList<>(), DIR.RIGHTDOWN);
            }
        }
        System.out.println(answer);
    }

    private static void makeSquare(int startR, int startC, int currentR, int currentC, List<Integer> dessert, DIR dir) {
        System.out.println("currentR: " +currentR + " currentC: " + currentC + " DIR: " + dir);
        if (dessert.contains(board[currentR][currentC])) {
            return;
        }
        visitBoard[startR][startC] = true;
        dessert.add(board[currentR][currentC]);
        System.out.println(Arrays.toString(dessert.toArray()));
        switch (dir) {
            case RIGHTDOWN:
                if (validateRange(currentR + 1, currentC + 1)) {
                    makeSquare(startR, startC, currentR + 1, currentC + 1, dessert, DIR.RIGHTDOWN);
                }
                if (validateRange(currentR + 1, currentC - 1)) {
                    makeSquare(startR, startC, currentR + 1, currentC - 1, dessert, DIR.LEFTDOWN);
                }
                break;
            case LEFTDOWN:
                if (validateRange(currentR + 1, currentC - 1)) {
                    makeSquare(startR, startC, currentR + 1, currentC - 1, dessert, DIR.LEFTDOWN);
                }
                if (validateRange(currentR - 1, currentC - 1)) {
                    makeSquare(startR, startC, currentR - 1, currentC - 1, dessert, DIR.LEFTUP);
                }
                break;
            case LEFTUP:
                if (validateRange(currentR - 1, currentC - 1)) {
                    makeSquare(startR, startC, currentR - 1, currentC - 1, dessert, DIR.LEFTUP);
                }
                if (validateRange(currentR - 1, currentC + 1)) {
                    makeSquare(startR, startC, currentR - 1, currentC + 1, dessert, DIR.RIGHTUP);
                }
                break;
            case RIGHTUP:
                if (validateRange(currentR - 1, currentC + 1)) {
                    makeSquare(startR, startC, currentR - 1, currentC + 1, dessert, DIR.RIGHTUP);
                }
                break;
        }
    }
    private static boolean validateRange(int NextR, int NextC) {
        return NextR >= 0 && NextR < N && NextC >= 0 && NextC < N;
    }
}

enum DIR {
    RIGHTDOWN, LEFTDOWN, LEFTUP, RIGHTUP
}