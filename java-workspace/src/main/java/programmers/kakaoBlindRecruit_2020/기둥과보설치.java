package programmers.kakaoBlindRecruit_2020;

import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
/*[x, y, a, b]
a =0 : 기둥, a = 1 : 보
b= 0: 삭제, b = 1 : 설치*/

public class 기둥과보설치 {
    public static void main(String[] args) {
        solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
    }

    public static int[][] solution(int n, int[][] build_frame) {
        List<List<int[]>> board = init(n);
        for (int[] line : build_frame) {
            operate(n, board, line);
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                System.out.print(Arrays.toString(board.get(i).get(j)) + " ");
            }
            System.out.println();
        }
        int[][] answer = makeAnswerList(n, board);
        for (int[] a : answer) {
            System.out.println(Arrays.toString(a));
        }
        return answer;
    }

    private static List<List<int[]>> init(int n) {
        List<List<int[]>> board = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++) {
                board.get(i).add(new int[]{0, 0});
            }
        }
        return board;
    }

    private static void operate(int n, List<List<int[]>> board, int[] operation) {
        int column = operation[0];
        int row = Math.abs(operation[1] - n);
        int op = operation[3];
        int object = operation[2];
        boolean isPossible;
        System.out.println(String.valueOf(column) + " " + String.valueOf(row) + " " + String.valueOf(object) + " " + String.valueOf(op));
        if (object == 0) {
            isPossible = validatePillar(n, board, row, column);
        } else {
            isPossible = validateBridge(n, board, row, column);
        }
        if (isPossible) {
            //삭제
            if (op == 0) {
                if (object == 1) {
                    board.get(row).get(column)[object] = 0;
                    if (!(validateBridge(n, board, row, column - 1)
                            && validateBridge(n, board, row, column + 1))){
                        board.get(row).get(column)[object] = 1;
                    }
                }
                if (object == 0) {
                    board.get(row).get(column)[object] = 0;
                    if (!(validatePillar(n, board, row, column - 1)
                            && validateBridge(n, board, row, column + 1))){
                        board.get(row).get(column)[object] = 1;
                    }
                }
            } else {
                board.get(row).get(column)[object] = 1;
            }
        }
    }

    private static boolean validatePillar(int n, List<List<int[]>> board, int row, int column) {
        if (row == n) {
            return true;
        }
        return board.get(row).get(column)[1] == 1 || board.get(row).get(column - 1)[1] == 1
                || board.get(row + 1).get(column)[0] == 1;
    }

    private static boolean validateBridge(int n, List<List<int[]>> board, int row, int column) {
        if (board.get(row + 1).get(column)[0] == 1) {
            return true;
        }
        try {
            if (board.get(row + 1).get(column + 1)[0] == 1) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return board.get(row).get(column - 1)[1] == 1 && board.get(row).get(column + 1)[1] == 1;
    }

    private static int[][] makeAnswerList(int n, List<List<int[]>> board) {
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j)[0] == 1) {
                    answer.add(new int[]{j, Math.abs(n - i), 0});
                }
                if (board.get(i).get(j)[1] == 1) {
                    answer.add(new int[]{j, Math.abs(n - i), 1});
                }
            }
        }
        answer.sort(new myComparator());
        System.out.println(answer.toString());
        int[][] answerArray = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        return answerArray;
    }

    private static class myComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] > o2[0]) {
                    return 1;
                }
            }
            return -1;
        }
    }
}
