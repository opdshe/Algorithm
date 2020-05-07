package programmers.kakaoBlindRecruit_2020;

import java.util.Arrays;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int a = 5;
        //rotateA(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}});
    }
    static int change(int a ) {
        a = 8;
        return a;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        return answer;
    }

    static int[][] rotateA(int[][] square) {
        int n = square.length;
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                clone[j][n - 1 - i] = square[i][j];
            }
        }
        return clone;
    }

    static int[][] goRight(int[][] square) {
        int n = square.length;
        int[][] clone = new int[n][n];
        return clone;

    }
}
