package 구현;

import java.util.*;

public class 듣보잡 {
    static Scanner scanner = new Scanner(System.in);
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        int countOfNoHear = scanner.nextInt();
        int countOfNoSee = scanner.nextInt();
        scanner.nextLine();
        Set<String> noHears = new HashSet<>();
        for (int i = 0; i < countOfNoHear; i++) {
            noHears.add(scanner.nextLine());
        }
        for (int i = 0; i < countOfNoSee; i++) {
            String name = scanner.nextLine();
            if (noHears.contains(name)) {
                answer.add(name);
            }
        }
        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }
}
