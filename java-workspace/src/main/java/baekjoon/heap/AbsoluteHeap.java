package baekjoon.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AbsoluteHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new myComparator());
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

class myComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (Math.abs(o1) > Math.abs(o2)) {
            return 2;
        } else if (Math.abs(o1) == Math.abs(o2)) {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        }
        return -2;
    }
}