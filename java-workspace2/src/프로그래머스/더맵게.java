package 프로그래머스;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3,9 ,10 ,12}, 7);
    }
    public static int solution(int[] scoville, int K) {
        Queue<Integer> foods = new PriorityQueue<>(Comparator.naturalOrder());
        for(int food : scoville) {
            foods.add(food);
        }
        int answer = 0;
        try {
            while (foods.peek()<= K) {
                mix(foods);
                answer++;
            }
        } catch (Exception e) {
            return -1;
        }

        System.out.println(answer);
        return answer;
    }
    private static void mix(Queue<Integer> foods){
        int first = foods.poll();
        int second = foods. poll();
        int newFoods = first + (second * 2);
        foods.add(newFoods);
    }
}
