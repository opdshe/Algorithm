package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나잡아봐라 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution("11 2");
    }

    private static int solution(String input) {
        int[] startPoint = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int conyPosition = startPoint[0];
        int brownPosition = startPoint[1];
        System.out.println(answer);
        return 0;
    }


    private static List<Integer> getBrownNextPositions(int currentPosition) {
        List<Integer> nextPositions = new ArrayList<>();
        nextPositions.add(currentPosition - 1);
        nextPositions.add(currentPosition + 1);
        nextPositions.add(currentPosition * 2);
        return nextPositions;
    }
}
