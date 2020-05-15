package programmers.stack;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 2, 3});
    }

    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        for (int i = 0; i < len -1 ; i++) {
            int gap = 0;
            for(int j = i+1; j < len; j++) {
                gap++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = gap;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
