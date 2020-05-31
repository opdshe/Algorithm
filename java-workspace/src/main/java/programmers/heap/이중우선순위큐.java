package programmers.heap;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});


    }

    public static int[] solution(String[] operations) {
        List<Integer> queue = new ArrayList<>();
        Arrays.stream(operations)
                .forEach(operation -> operate(queue, operation ));
        int[] answer;
        if (queue.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            int min = queue.get(0);
            int max = queue.get(queue.size() - 1);
            answer = new int[]{max, min};
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static void operate(List<Integer> queue, String operation) {
        try {
            if (operation.contains("I")) {
                int val = Integer.parseInt(operation.split(" ")[1]);
                queue.add(val);
                queue.sort(Integer::compareTo);
                return;
            }
            if (operation.equals("D 1")) {
                int val = queue.remove(queue.size() - 1);
                return;
            }
            int val = queue.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
