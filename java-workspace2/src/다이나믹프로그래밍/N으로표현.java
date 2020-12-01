package 다이나믹프로그래밍;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {
    static int answer = -1;

    public static void main(String[] args) {
        solution(5, 5);
    }

    public static int solution(int N, int target) {
        Set<Long>[] sets = new HashSet[9];
        for (int count = 1; count <= 8; count++) {
            sets[count] = new HashSet<>();
            sets[count].add(Long.parseLong(String.valueOf(N).repeat(count)));
        }

        for (int count = 1; count <= 8; count++) {
            for (int lower = 1; lower < count; lower++) {
                int upper = count - lower;
                for (Long l : sets[lower]) {
                    for (Long u : sets[upper]) {
                        sets[count].add(l + u);
                        sets[count].add(l - u);
                        sets[count].add(l * u);
                        if (u != 0) {
                            sets[count].add(l / u);
                        }
                    }
                }
            }
            if (sets[count].contains((long) target)) {
                answer = count;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
