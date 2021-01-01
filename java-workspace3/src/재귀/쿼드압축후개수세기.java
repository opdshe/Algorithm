package 재귀;

public class 쿼드압축후개수세기 {
    static int countOfZero = 0;
    static int countOfOne = 0;

    public static void main(String[] args) {
        solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
    }

    public static int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        System.out.println(countOfZero + " " + countOfOne);
        return new int[]{countOfZero, countOfOne};
    }

    private static void compress(int[][] arr, int rowStart, int columnStart, int size) {
        int current = arr[rowStart][columnStart];
        boolean isAllSame = true;
        for (int row = rowStart; row < rowStart + size; row++) {
            for (int column = columnStart; column < columnStart + size; column++) {
                if (arr[row][column] != current) {
                    isAllSame = false;
                    break;
                }
            }
        }
        if (isAllSame) {
            if (current == 0) {
                countOfZero++;
            } else {
                countOfOne++;
            }
            return;
        }
        compress(arr, rowStart, columnStart, size / 2);
        compress(arr, rowStart, columnStart + size / 2, size / 2);
        compress(arr, rowStart + size / 2, columnStart, size / 2);
        compress(arr, rowStart + size / 2, columnStart + size / 2, size / 2);
    }
}
