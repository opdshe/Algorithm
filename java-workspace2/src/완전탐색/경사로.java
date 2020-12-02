package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 경사로 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int size;
    static int lenOfBridge;
    static int[][] map;
    static boolean[][][] installed;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        for (int row = 0; row < size; row++) {
            if (columnCheck(row)) {
                answer++;
            }
        }
        for (int column = 0; column < size; column++) {
            if (rowCheck(column)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        int[] inputs = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        size = inputs[0];
        lenOfBridge = inputs[1];
        map = new int[size][size];
        installed = new boolean[size][size][2];
        for (int row = 0; row < size; row++) {
            map[row] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static boolean rowCheck(int column) {
        int currentIdx = 0;
        int currentHeight = map[0][column];
        boolean result = true;
        while (currentIdx < size) {
            try {
                int height = map[currentIdx][column];
                if (height == currentHeight) {
                    currentIdx++;
                } else if (height == currentHeight + 1) {
                    for (int prevRow = currentIdx - 1; prevRow >= currentIdx - lenOfBridge; prevRow--) {
                        if (map[prevRow][column] != height - 1 || installed[prevRow][column][0]) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        installed[prevRow][column][0] = true;
                    }
                    currentHeight = height;
                    currentIdx++;
                } else if (height == currentHeight - 1) {
                    for (int nextRow = currentIdx; nextRow < currentIdx + lenOfBridge; nextRow++) {
                        if (map[nextRow][column] != currentHeight - 1 || installed[nextRow][column][0]) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        installed[nextRow][column][0] = true;
                    }
                    currentHeight = height;
                    currentIdx += lenOfBridge;
                } else {
                    result = false;
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean columnCheck(int row) {
        int currentIdx = 0;
        int currentHeight = map[row][0];
        boolean result = true;
        while (currentIdx < size) {
            try {
                int height = map[row][currentIdx];
                if (height == currentHeight) {
                    currentIdx++;
                } else if (height == currentHeight + 1) {
                    for (int prevColumn = currentIdx - 1; prevColumn >= currentIdx - lenOfBridge; prevColumn--) {
                        if (map[row][prevColumn] != height - 1 || installed[row][prevColumn][1]) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        installed[row][prevColumn][1] = true;
                    }
                    currentHeight = height;
                    currentIdx++;
                } else if (height == currentHeight - 1) {
                    for (int nextColumn = currentIdx; nextColumn < currentIdx + lenOfBridge; nextColumn++) {
                        if (map[row][nextColumn] != currentHeight - 1 || installed[row][nextColumn][1]) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        installed[row][nextColumn][1] = true;
                    }
                    currentHeight = height;
                    currentIdx += lenOfBridge;
                } else {
                    result = false;
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                result = false;
                break;
            }
        }
        return result;
    }
}
