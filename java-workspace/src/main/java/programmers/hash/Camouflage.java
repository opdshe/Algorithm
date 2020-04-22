package programmers.hash;

import java.util.HashMap;

public class Camouflage {
    public static void main(String[] args) {
        Solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}
class Solution {
    public static int solution(String[][] clothes) {
        int answer;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length ; i++) {
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        answer = hashMap.values().stream().mapToInt(i -> i + 1).reduce(1, (a, b) -> a * b);
        System.out.println(answer -1);
        return answer -1;
    }
}