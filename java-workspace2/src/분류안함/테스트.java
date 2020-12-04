package 분류안함;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 테스트 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String raw = scanner.nextLine();
        List<String> list = Arrays.stream(raw.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        System.out.println(list.size() == 1);
        System.out.println(list.get(0).isEmpty());
    }
}
