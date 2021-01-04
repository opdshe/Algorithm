package 구현;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        char head = words[0].charAt(0);
        Set<String> wordSet = new HashSet<>();
        for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {
            String word = words[wordIdx];
            if (isAvailableWord(wordSet, word, head)) {
                wordSet.add(word);
                head = word.charAt(word.length() - 1);
            } else {
                answer = new int[]{(wordIdx % n) + 1, (wordIdx / n) + 1};
                break;
            }
        }
        return answer;
    }

    private static boolean isAvailableWord(Set<String> wordSet, String word, char head) {
        return word.length() >= 2 && word.charAt(0) == head && !wordSet.contains(word);
    }
}
