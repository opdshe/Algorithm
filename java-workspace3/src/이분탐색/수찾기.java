package 이분탐색;

import java.util.*;

public class 수찾기 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> targets = new ArrayList<>();
        int countOfNumbers = scanner.nextInt();
        for (int idx = 0; idx < countOfNumbers; idx++) {
            numbers.add(scanner.nextInt());
        }
        int countOfTargets = scanner.nextInt();
        for (int idx = 0; idx < countOfTargets; idx++) {
            targets.add(scanner.nextInt());
        }

        numbers.sort(Comparator.naturalOrder());
        for (Integer target : targets) {
            boolean isExist = isExist(numbers, target);
            System.out.println(isExist ? 1 : 0);
        }
    }

    private static boolean isExist(List<Integer> numbers, int target) {
        int position = Collections.binarySearch(numbers, target);
        return position >= 0;
    }
}
