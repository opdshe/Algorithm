package programmers.maester;

import java.util.HashMap;
import java.util.Map;

public class 포켓몬 {
    public static void main(String[] args) {
        solution(new int []{3,3,3,2,2,4});
    }

    public static int solution(int[] nums) {
        int countOfMon = nums.length;
        int maxCount = countOfMon/2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0) +1);
        }
        System.out.println(map);
        int answer;
        if(maxCount> map.size()) {
            answer = map.size();
        } else{
            answer= maxCount;
        }
        System.out.println(answer);
        return answer;
    }
}
