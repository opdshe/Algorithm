package 프로그래머스;

public class 타겟넘버생성 {
    static int answer = 0;
    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(int[] numbers, int idx, int sum, int target) {
        if(idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, idx+1, sum+numbers[idx], target);
        dfs(numbers, idx+1, sum-numbers[idx], target);
    }
}
