package 이분탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 나무자르기 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfWood = scanner.nextInt();
        int minLength = scanner.nextInt();
        List<Integer> woodLengths = new ArrayList<>();
        for (int i = 0; i < countOfWood; i++) {
            woodLengths.add(scanner.nextInt());
        }

        long maxHeight = getMaxHeight(woodLengths, minLength);
        System.out.println(maxHeight);
    }

    private static long getMaxHeight(List<Integer> woodLengths, int minLength) {
        woodLengths.sort(Comparator.naturalOrder());
        long left = 0;
        long right = woodLengths.get(woodLengths.size() - 1);
        long maxHeight = 0;
        while (left <= right) {
            long height = (left + right) / 2;
            long sum = 0;
            for (Integer woodLength : woodLengths) {
                if (woodLength > height) {
                    sum += woodLength - height;
                }
            }
            if (sum >= minLength) {
                maxHeight = Math.max(maxHeight, height);
                left = height + 1;
            } else {
                right = height - 1;
            }
        }
        return maxHeight;
    }
}
