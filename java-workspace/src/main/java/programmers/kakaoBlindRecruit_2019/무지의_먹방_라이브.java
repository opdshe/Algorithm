package programmers.kakaoBlindRecruit_2019;

import java.util.ArrayList;
import java.util.List;

public class 무지의_먹방_라이브 {
    public static void main(String[] args) {
        solution(new int[]{3, 1, 2}, 5);
    }

    public static int solution(int[] food_times, long k) {
        int arraySize = food_times.length;
        List<Pair> foods = new ArrayList<>();
        for (int i =0 ; i < arraySize ; i++) {
            foods.add(new Pair(i+1, food_times[i]));
        }

        foods.sort((a, b) -> a.rest < b.rest? 1: -1);
        foods.forEach(i-> System.out.println(i.rest));
        long preRest = 0;
        int i=0;
        for(Pair p : foods) {
            long gap = p.rest - preRest;
            if (gap != 0 ) {
                long spend = gap * arraySize;
                if (spend <= k) {
                    k -= spend;
                    preRest = p.rest;
                } else {
                    k %= arraySize;
                    foods.subList(i, food_times.length).sort((a,b) -> a.idx<b.idx?1 : -1 );
                    return foods.get(i+(int)k).idx;
                }
            }
            i++;
            arraySize--;
        }

        return -1;
    }
}

class Pair {
    int idx;
    int rest;

    public Pair(int idx, int rest) {
        this.idx = idx;
        this.rest = rest;
    }
}