package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 단어변환 {
    static int answer;

    public static void main(String[] args) {
        solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

    public static int solution(String begin, String target, String[] words) {
        answer = words.length + 1;
        List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        dfs(0, wordList, new ArrayList<>(), begin, target);
        if (answer == wordList.size()+1) {
            answer = 0;
        }
        System.out.println(answer);
        return answer;
    }

    private static void dfs(int countOfChange, List<String> wordList, List<String> visited, String current, String target) {
        if (current.equals(target)) {
            answer = Math.min(answer, countOfChange);
            return;
        }
        if(countOfChange == wordList.size()){
            return;
        }
        for (String tar : wordList) {
            if (isAvailableToGo(current, tar) && !visited.contains(tar)) {
                List<String> newVisited = new ArrayList<>(visited);
                newVisited.add(tar);
                dfs(countOfChange + 1, wordList,newVisited, tar, target);
            }
        }
    }

    private static boolean isAvailableToGo(String ori, String tar) {
        int diff = 0;
        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) != tar.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
