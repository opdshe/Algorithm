package 프로그래머스;

import java.util.*;
import java.util.stream.Collectors;

public class 라면공장 {
    public static void main(String[] args) {
        solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30);
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        Queue<Integer> suppliesQueue = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> datesList = Arrays.stream(dates).boxed().collect(Collectors.toList());
        List<Integer> suppliesList = Arrays.stream(supplies).boxed().collect(Collectors.toList());
        int currentIdx = 0;
        int answer = 0;
        while (stock < k) {
            for(int i = currentIdx; i < dates.length; i++){
                if(datesList.get(i) <= stock) {
                    suppliesQueue.add(suppliesList.get(i));
                    currentIdx++;
                    continue;
                }
                break;
            }
            stock += suppliesQueue.poll();
            answer++;
        }
        return answer;
    }
}
