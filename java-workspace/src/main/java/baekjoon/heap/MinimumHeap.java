package baekjoon.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase > 0) {
            //System.out.println("숫자 입력");
            int inputNum = sc.nextInt();
            if (inputNum == 0) {
                if (priorityQueue.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(inputNum);
            }
            testCase--;
        }
    }
}
