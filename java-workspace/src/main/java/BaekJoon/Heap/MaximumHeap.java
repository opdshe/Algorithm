package BaekJoon.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase> 0){
            int inputNum = scanner.nextInt();
            if (inputNum == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(inputNum);
            }
            testCase --;
        }
    }
}
