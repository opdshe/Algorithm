package 프로그래머스.DFS_BFS;

public class 단어변환 {
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) {
        solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = words.length;
        boolean result = dfs(words, begin, target, 0);
        if (answer == words.length) {
            return 0;
        }
        return answer;
    }

    private static boolean dfs(String[] words, String current, String target, int count) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return true;
        }
        if (count == words.length) {
            return false;
        } else {
            for (int i = 0; i < words.length; i++) {
                if (isAvailable(current, words[i]) && !visited[i]) {
                    visited[i] = true;
                    dfs(words, words[i], target, count + 1);
                    visited[i] = false;
                }
            }
        }
        return false;
    }

    private static boolean isAvailable(String current, String target) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}