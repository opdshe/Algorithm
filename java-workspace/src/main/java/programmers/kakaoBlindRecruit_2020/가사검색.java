package programmers.kakaoBlindRecruit_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
효율성 테스트 1-3 번 통과하지못함
*/

public class 가사검색 {

    public static void main(String[] args) {
        solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[] {"fro??", "????o", "fr???", "fro???", "pro?"});
    }

    public static int[] solution(String[] words, String[] queries) {
        Arrays.sort(words, Comparator.comparing(String::length));

        List<Integer> answer = new ArrayList<>();
        for(String query: queries) {
            answer.add(countOfMatch(words, query));
        }
        System.out.println(answer.toString());
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int countOfMatch(String [] words, String query){
        int count = 0;
        for (String word : words) {
            if(word.length() > query.length()) {
                break;
            }
            if(word.length()!= query.length()){
                continue;
            }
            //길이 일치하는경우
            if(isMatch(word, query)){
                count++;
            }
        }
        return count;
    }

    private static boolean isMatch(String word, String query) {
        for(int i = 0; i <word.length(); i++) {
            if (word.charAt(i)!=query.charAt(i)) {
                if (query.charAt(i)=='?'){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
