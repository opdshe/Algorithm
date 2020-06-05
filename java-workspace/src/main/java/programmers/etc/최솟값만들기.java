package programmers.etc;

import java.util.*;

public class 최솟값만들기 {
    public static void main(String[] args) {
        solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
    }

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int count = A.length;
        for(int i = 0 ; i <count; i ++) {
            int mul = A[i] * B[count-1-i];
            answer += mul;
        }
        return answer;
    }
}
