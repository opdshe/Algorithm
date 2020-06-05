package programmers.etc;


import java.util.Arrays;

public class 최고의집합 {
    public static void main(String[] args) {
        solution(2, 9);
    }

    public static int[] solution(int n, int s) {
        int share = s / n;
        int remainder = s % n;
        if(share == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = share;
        }
        for (int i = 0; i < remainder; i++) {
            answer[n - 1 - i] += 1;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
