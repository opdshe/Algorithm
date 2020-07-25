package 프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 쇠막대기 {
    public static void main(String[] args) {
        solution("()(((()())(())()))(())");
    }

    public static int solution(String arrangement) {
        List<String> arraneges = Arrays.stream(arrangement.split(""))
                .collect(Collectors.toList());
        Stack<String> sticks = new Stack<String>();
        int countOfStick = 0;
        int answer = 0;
        for (String arranege : arraneges) {
            if (arranege.equals("(")) {
                countOfStick++;
            }
            else {
                if (sticks.peek().equals("(")) {
                    countOfStick --;
                    answer += countOfStick;
                } else {
                    answer ++;
                    countOfStick--;
                }
            }
            sticks.add(arranege);
        }
        return answer;
    }
}
