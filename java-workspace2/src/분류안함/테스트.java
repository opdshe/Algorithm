package 분류안함;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 테스트 {
    private static Scanner scanner = new Scanner(System.in);
    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2020, 8, 22, 12, 22);
        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
