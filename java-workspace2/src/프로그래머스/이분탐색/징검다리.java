package 프로그래머스.이분탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 징검다리 {
    public static void main(String[] args) {
        //2 11 14 17 21   | 25
        solution(25, new int[]{2, 14, 11, 17, 21}, 2);
    }

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        printDiff(rocks, distance);
        int answer = 0;
        return answer;
    }

    private static void printDiff(int[] rocks, int distance) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rocks.length - 1; i++) {
            result.add(rocks[i + 1] - rocks[i]);
        }
        result.add(0, rocks[0]);
        result.add(distance - rocks[rocks.length - 1]);
        result.forEach(System.out::println);
    }
}
