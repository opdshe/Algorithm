package baekjoon.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JewelryRobber {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            jewelries[i] =new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            bags[i] =(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewelries);
        Arrays.sort(bags);
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int i =0; i < K; i++) {
            for (int j =idx; j < N; j++) {
                if (jewelries[j].weight <= bags[i]) {
                    priorityQueue.add(jewelries[j].price);
                    idx = j+1;
                } else {
                    break;
                }
            }
            answer += priorityQueue.poll();
        }
        System.out.println(answer);
    }
}

class Jewelry implements Comparable<Jewelry> {
    int weight;
    int price;

    @Override
    public String toString() {
        return "Jewelry{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }


    @Override
    public int compareTo(Jewelry o) {
        if (weight > o.weight) {
            return 1;
        }
        return -1;
    }
}