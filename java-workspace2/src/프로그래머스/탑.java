package 프로그래머스;

import java.util.*;

public class 탑 {
    public static void main(String[] args) {
        solution(new int[]{3, 9, 9, 3, 5, 7, 2});
    }

    public static int[] solution(int[] heights) {
        List<Integer> heightList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for (Integer integer : heights) {
            heightList.add(integer);
        }

        for (int i = 0; i < heightList.size(); i++) {
            answer.add(getCount(i, heightList));
        }
        System.out.println(Arrays.toString(answer.toArray()));
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int getCount(int index, List<Integer> heights) {
        if (index == 0) {
            return 0;
        }
        for(int i = index-1 ; i >=0; i --) {
            if (heights.get(i)> heights.get(index)){
                return i+1;
            }
        }
        return 0;
    }
}
