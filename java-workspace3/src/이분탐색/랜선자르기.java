package 이분탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 랜선자르기 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfLine = scanner.nextInt();
        int need = scanner.nextInt();
        List<Integer> lines = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            lines.add(scanner.nextInt());
        }
        long maxLength = getMaxLength(lines, need);
        System.out.println(maxLength);
    }

    private static long getMaxLength(List<Integer> lines, int need) {
        lines.sort(Comparator.naturalOrder());
        long left = 1;
        long right = lines.get(lines.size() - 1);
        long maxLength = 0;
        while (left <= right) {
            long length = (left + right) / 2;
            int piece = 0;
            for (Integer line : lines) {
                if (line >= length) {
                    piece += (line / length);
                }
            }
            if (piece >= need) {
                maxLength = Math.max(maxLength, length);
                left = length + 1;
            } else {
                right = length - 1;
            }
        }
        return maxLength;
    }
}
