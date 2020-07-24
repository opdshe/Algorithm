package 프로그래머스;

import java.util.*;
import java.util.stream.Collectors;

public class 보석쇼핑 {
    static int[] answer;
    public static void main(String[] args) {
        solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
    }

    public static int[] solution(String[] gems) {
        answer = new int[]{1, gems.length};
        List<String> gemList = Arrays.stream(gems)
                .collect(Collectors.toList());
        Set gemSet = new HashSet(Arrays.asList(gems));
        int left = gemList.size();
        int right = 0;
        for (Object o : gemSet) {
            left = Math.min(left, gemList.indexOf(o));
            right = Math.max(right, gemList.indexOf(o));
        }
        checkFromLeftToRight(left, right, gemSet, gemList);
        checkFromRightToLeft(left, right, gemSet, gemList);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static void checkFromLeftToRight(int left, int right, Set gemSet, List<String> gemList) {
        while ((right-left+1)>=gemSet.size()){
            List<String> subList = gemList.subList(left,right+1);
            if (subList.containsAll(gemSet)) {
                if ((right-left) < answer[1]-answer[0]) {
                    answer = new int[]{left+1, right+1};
                }
            }
            left++;
        }
    }

    private static void checkFromRightToLeft(int left, int right, Set gemSet, List<String> gemList) {
        while ((right-left+1)>=gemSet.size()){
            List<String> subList = gemList.subList(left,right+1);
            if (subList.containsAll(gemSet)) {
                if ((right-left) < answer[1]-answer[0]) {
                    answer = new int[]{left+1, right+1};
                }
            }
            right--;
        }
    }
}
