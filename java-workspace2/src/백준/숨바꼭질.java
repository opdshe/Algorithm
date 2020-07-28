package 백준;

import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(input[0] + input[1]);
    }
}
