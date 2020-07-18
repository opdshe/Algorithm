package 프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 타겟넘버 {
    private static int answer = 0;

    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public static int solution(int[] numbers, int target) {
        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        dfs(numberList, 0, 0, target);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(List<Integer> numberList, int idx, int sum, int target) {
        if (idx == numberList.size()) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numberList, idx + 1, sum + numberList.get(idx), target);
        dfs(numberList, idx + 1, sum - numberList.get(idx), target);
    }
}
