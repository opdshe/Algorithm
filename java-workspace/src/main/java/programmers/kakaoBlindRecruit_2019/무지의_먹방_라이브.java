package programmers.kakaoBlindRecruit_2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 무지의_먹방_라이브 {
    public static void main(String[] args) {
        solution(new int[]{3, 1, 2}, 5);
    }

    public static int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<>();
        int countOfFood = food_times.length;
        for(int i = 0 ; i < countOfFood; i ++) {
            foods.add(new Food(i, food_times[i]));
        }
        foods.sort(Comparator.comparing((a)->a.rest));
        while (true) {
            if(foods.get(0).rest * foods.size() <= k){
                k -= foods.get(0).rest * foods.size();
                foods.remove(0);
                continue;
            }
            break;
        }
        foods.sort(Comparator.comparing((a)->a.idx));
        for(Food f : foods) {
            System.out.println(f.idx + ", " + f.rest);
        }
        int next = (int) (foods.size()%k);
        int answer = foods.get(next).idx +1 ;
        System.out.println(answer);
        return  answer;
    }
    private static class Food {
        int idx;
        int rest;

        public Food(int idx, int rest) {
            this.idx = idx;
            this.rest = rest;
        }
    }
}