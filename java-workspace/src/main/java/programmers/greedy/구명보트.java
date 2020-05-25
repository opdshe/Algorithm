package programmers.greedy;

import java.util.*;

public class 구명보트 {
    public static void main(String[] args) {
        solution(new int[]{70, 50, 80, 50}, 100);
    }

    public static int solution(int[] people, int limit) {
        List<Integer> peopleList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            peopleList.add(people[i]);
        }
        peopleList.sort((a, b) -> a < b ? 1 : -1);
        return  getCount(peopleList, limit);
    }

    private static int getCount(List<Integer> peopleList, int limit) {
        int count = 0;
        while (!peopleList.isEmpty()) {
            int first = peopleList.remove(0);
            Integer second = peopleList.stream()
                    .filter((a) -> a + first <= limit)
                    .findFirst()
                    .orElse(-1);
            if (second > 0) {
                System.out.println("current : " + peopleList.toString());
                peopleList.remove(second);
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
}
