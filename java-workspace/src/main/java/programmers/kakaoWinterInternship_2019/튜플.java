package programmers.kakaoWinterInternship_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 튜플 {
    static List <List<Integer>> tuple = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public static int[] solution(String s) {
        toElementList(s);
        getTuple();
        System.out.println(Arrays.toString(answer.toArray()));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void getTuple() {
        tuple.sort((a,b) -> a.size() > b.size()?1:-1);
        for (List<Integer> el : tuple) {
            for (Integer integer : el) {
                if (!answer.contains(integer)) {
                    answer.add(integer);
                }
            }
        }
    }

    private static void toElementList(String s) {
       Arrays.stream(s.split("\\{"))
               .filter(str->!str.isEmpty())
               .map(str->str.replaceAll("[}]", ""))
               .forEach(str -> {
                   List<Integer> element = new ArrayList<>();
                   Arrays.stream(str.split(","))
                           .forEach(integer -> element.add(Integer.parseInt(integer)));
                   tuple.add(element);
               });
    }

}
