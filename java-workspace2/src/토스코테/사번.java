package 토스코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 사번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        solution(input);
    }
    private static void solution(String input) {
        List<String> inputs = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        Queue<String> recent = new ArrayDeque<>();
        for (String s : inputs) {
            if (!recent.contains(s)) {
                if (recent.size()>=5) {
                    recent.poll();
                }
            } else {
                recent.remove(s);
            }
            recent.add(s);
            printQueue(recent);
        }
    }

    private static void printQueue(Queue<String> recent) {
        List<String> recentList = new ArrayList<>(recent);
        Collections.reverse(recentList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : recentList) {
            stringBuilder.append(s).append(" ");
        }
        String result = stringBuilder.toString().trim();
        System.out.println(result);
    }
}
