package 테스트;

import java.util.stream.IntStream;

public class 이진탐색재귀 {
    public static void main(String[] args) {
        int[] numbers = IntStream.rangeClosed(1, 50)
                .toArray();
        System.out.println(binarySearch(numbers, 3, 0, 49));
    }

    private static int binarySearch(int[] numbers, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        } else {
            int mid = (begin + end) / 2;
            System.out.println("num[mid] = " + numbers[mid]);
            if (target == numbers[mid]) {
                return mid;
            } else if (target < numbers[mid]) {
                return binarySearch(numbers, target, begin, mid - 1);
            } else {
                return binarySearch(numbers, target, mid + 1, end);
            }
        }
    }
}
