package 백준.시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class 체스판다시칠하기 {
    static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = inputs[0];
        int M = inputs[1];
        answer = N * M;
        String[][] board = new String[inputs[0]][inputs[1]];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextLine().split("");
        }
        for (int startOfHeight = 0; startOfHeight <= N - 8; startOfHeight++) {
            for (int startOfWidth = 0; startOfWidth <= M - 8; startOfWidth++) {
                checkBoard(board, startOfHeight, startOfWidth);
            }
        }
        System.out.println(answer);
    }

    private static void checkBoard(String[][] board, int startOfHeight, int startOfWidth) {
        int blackCount = 0;
        int whiteCount = 0;
        for (int height = startOfHeight; height < startOfHeight + 8; height++) {
            for (int width = startOfWidth; width < startOfWidth + 8; width++) {
                if (height % 2 == 0) {
                    //height 짝수, width 짝
                    if (width % 2 == 0) {
                        if (!board[height][width].equals("B")) {
                            blackCount++;
                        } else {
                            whiteCount++;
                        }
                        //height 짝수 width 홀수
                    } else {
                        if (!board[height][width].equals("W")) {
                            blackCount++;
                        } else {
                            whiteCount++;
                        }
                    }
                } else {
                    //height홀, width 짝
                    if (width % 2 == 0) {
                        if (!board[height][width].equals("W")) {
                            blackCount++;
                        } else {
                            whiteCount++;
                        }
                    } else {
                        if (!board[height][width].equals("B")) {
                            blackCount++;
                        } else {
                            whiteCount++;
                        }
                    }
                }
            }
        }
        int result = Math.min(blackCount, whiteCount);
        answer = Math.min(answer, result);
    }
}
