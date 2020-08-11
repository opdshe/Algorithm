package 백준.시뮬레이션;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 회전하는큐 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> queue = IntStream.rangeClosed(1, inputs[0])
                .boxed()
                .collect(Collectors.toList());
        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(targets)
                .forEach((target) -> pop(queue, target));
        System.out.println(answer);
    }

    private static void pop(List<Integer> queue, int target) {
        while (true) {
            if (target == queue.get(0)) {
                queue.remove(0);
                break;
            }
            int naturalOrderCount = queue.indexOf(target);
            int reverseOrderCount = queue.size() - naturalOrderCount;
            if (naturalOrderCount <= reverseOrderCount) {
                rotateByNaturalOrder(queue);
            } else {
                rotateByReverseOrder(queue);
            }
            answer++;
        }
    }

    private static void rotateByNaturalOrder(List<Integer> queue) {
        int head = queue.remove(0);
        queue.add(head);
    }

    private static void rotateByReverseOrder(List<Integer> queue) {
        int tail = queue.remove(queue.size() - 1);
        queue.add(0, tail);
    }
}
