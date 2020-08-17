package 프로그래머스.DFS_BFS;

public class 타겟넘버 {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    private static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        System.out.println(answer);
        return answer;
    }

    private static int dfs(int[] numbers, int target, int idx, int sum) {
        if (numbers.length == idx) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, target, idx + 1, sum + numbers[idx]) +
                dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
