package 복습;

import java.util.*;

public class 수찾기 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int countOfNumbers = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < countOfNumbers; i++) {
            numbers.add(scanner.nextInt());
        }
        numbers.sort(Comparator.naturalOrder());
        int countOfTargets = scanner.nextInt();
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i < countOfTargets; i++) {
            targets.add(scanner.nextInt());
        }
        targets.forEach((target) -> solution(numbers, target));
    }

    private static void solution(List<Integer> numbers, int target) {
        int position = Collections.binarySearch(numbers, target);
        System.out.println(position >= 0 ? 1 : 0);
    }
}
