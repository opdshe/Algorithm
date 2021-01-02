package 문자열;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 튜플 {
    public static void main(String[] args) {
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }

    public static int[] solution(String s) {
        List<List<Integer>> candidates = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        String[] split = s.split("}");
        for (String str : split) {
            str = str.replace("{", "");
            if (str.charAt(0) == ',') {
                str = str.replaceFirst(",", "");
            }
            String[] splitStr = str.split(",");
            List<Integer> list = new ArrayList<>();
            for (String s1 : splitStr) {
                list.add(Integer.parseInt(s1));
            }
            candidates.add(list);
        }
        candidates.sort(Comparator.comparing(List::size));
        for (List<Integer> candidate : candidates) {
            for (Integer integer : candidate) {
                if (!answer.contains(integer)) {
                    answer.add(integer);
                }
            }
        }
        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
