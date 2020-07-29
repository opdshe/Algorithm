package 백준;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 문자열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String A = input.get(0);
        String B = input.get(1);

        int answer = A.length();

        if (A.length() == B.length()) {
            answer = getDifference(A, B);
        } else {
            for (int i = 0; i <= B.length() - A.length(); i++) {
                int diff = getDifference(A, B.substring(i, i+A.length()));
                answer = Math.min(answer, diff);
            }
        }
        System.out.println(answer);
    }

    private static int getDifference(String A, String B) {
        //System.out.println("A =" + A + ", B =" + B);
        int difference = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                difference++;
            }
        }
        return difference;
    }
}
