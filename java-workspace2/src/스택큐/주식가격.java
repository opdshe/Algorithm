package 스택큐;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        solution(new int[]{4, 5, 3, 5, 2});
    }

    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for (int idx = 0; idx < prices.length; idx++) {
            int current = prices[idx];
            if (stack.isEmpty()) {
                stack.push(idx);
            } else if (prices[stack.peek()] > current) {
                while (!stack.isEmpty() && prices[stack.peek()] > current) {
                    Integer popIdx = stack.pop();
                    answer[popIdx] = idx - popIdx;
                }
                stack.push(idx);
            } else {
                stack.push(idx);
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}