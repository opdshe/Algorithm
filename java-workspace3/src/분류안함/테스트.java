package 분류안함;

import java.util.ArrayDeque;
import java.util.Queue;

public class 테스트 {
    public static void main(String[] args) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 1});
        System.out.println(queue.contains(new int[]{0, 1}));
    }
}
