package 브루트포스;

public class 숫자의표현 {
    static int answer = 0;

    public int solution(int n) {
        for (int start = 1; start <= n; start++) {
            dfs(n, start, start);
        }
        return answer;
    }

    private static void dfs(int target, int current, int cost) {
        if (cost >= target) {
            if (cost == target) {
                answer++;
            }
            return;
        }
        dfs(target, current + 1, cost + (current + 1));
    }
}
