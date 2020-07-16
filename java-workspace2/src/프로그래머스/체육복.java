package 프로그래머스;

import java.util.*;
import java.util.stream.Collectors;

public class 체육복 {
    public static void main(String[] args) {
        solution(5, new int[]{2,4}, new int[]{4, 5});
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> distinct = new ArrayList<>();
        lostList.forEach(lst -> {
            if (reserveList.contains(lst)){
                distinct.add(lst);
            }
        });

        lostList.removeAll(distinct);
        reserveList.removeAll(distinct);

        reserveList.forEach(res->lent(res, lostList));
        int answer = n - lostList.size();
        System.out.println(answer);
        return answer;
    }
    private static void lent (Integer reserve, List<Integer> lostList) {
        if (lostList.contains(reserve-1)) {
            lostList.remove((Integer)(reserve-1));
            return;
        }
        if (lostList.contains(reserve+1)) {
            lostList.remove((Integer)(reserve+1));
        }
    }
}
