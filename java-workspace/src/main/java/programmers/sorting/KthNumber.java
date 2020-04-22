package programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthNumber {
    public static void main(String[] args) {
        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

    }
    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        Arrays.stream(commands).forEach(command -> {
            int[] subArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(subArray);
            answer.add(subArray[command[2]-1]);
        });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
