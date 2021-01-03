package 구현;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int countOfTarget = nums.length / 2;
        return Math.min(set.size(), countOfTarget);
    }
}
