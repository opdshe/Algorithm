package 완전탐색;

public class 타겟넘버 {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int target, int idx, int cost) {
        if (idx == numbers.length) {
            if (cost == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, idx + 1, cost + numbers[idx]);
        dfs(numbers, target, idx + 1, cost - numbers[idx]);
    }
}
