package 스택;

import java.util.ArrayDeque;
import java.util.Deque;

public class 큰수만들기 {
    public static void main(String[] args) {
        solution("54321", 4);
    }

    public static String solution(String number, int k) {
        int newNumberLength = number.length() - k;
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        for (int idx = 0; idx < number.length(); idx++) {
            int current = Character.getNumericValue(number.charAt(idx));
            while (!queue.isEmpty() && queue.peekLast() < current &&
                    queue.size() + (number.length() - idx) > newNumberLength) {
                queue.pollLast();
            }
            queue.add(current);
        }

        for (int i = 0; i < newNumberLength; i++) {
            int value = queue.pollFirst();
            answer.append(value);
        }
        System.out.println(answer.toString());
        return answer.toString();
    }
}
