package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2477 {
    private static int customerIdx;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine().trim());
        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            int finishedCustomer = 0;
            List<Integer> visitTimes = new ArrayList<>();
            Queue<Customer> watingRecept = new PriorityQueue<>(Customer::compareForRecept);
            Queue<Customer> watingRepair = new PriorityQueue<>(Customer::compareTo);
            List<Customer> customers = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(bf.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] receptionOperateTimes = new int[N];
            int[] repairOperateTimes = new int[M];
            st = new StringTokenizer(bf.readLine().trim());
            for (int j = 0; j < N; j++) {
                receptionOperateTimes[j] = (Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(bf.readLine().trim());
            for (int j = 0; j < M; j++) {
                repairOperateTimes[j] = (Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(bf.readLine().trim());
            for (int j = 0; j < K; j++) {
                visitTimes.add(Integer.parseInt(st.nextToken()));
            }
            visitTimes.forEach(time -> customers.add(new Customer(time)));
            Pair[] recept = new Pair[N];
            Pair[] repair = new Pair[M];

            customerIdx = 1;
            time = 0;
            while (finishedCustomer < K) {
                //도착한 시간이 되면 접수 대기줄로
                if (!customers.isEmpty()) {
                    customers.removeIf(customer -> {
                        if (customer.receptArrivalTime == time) {
                            customer.ID = customerIdx;
                            watingRecept.add(customer);
                            customerIdx++;
                            return true;
                        }
                        return false;
                    });
                }
                //접수 대기줄에서 접수창구로
                for (int j = 0; j < recept.length; j++) {
                    if (recept[j] == null && !watingRecept.isEmpty()) {
                        recept[j] = new Pair(watingRecept.poll(), receptionOperateTimes[j]);
                        recept[j].customer.receiptNum = j + 1;
                    }
                }
                //접수 창구 진행
                for (int j = 0; j < recept.length; j++) {
                    if (recept[j] != null && recept[j].restTime > 0) {
                        recept[j].restTime -= 1;
                    }
                    if (recept[j] != null && recept[j].restTime == 0) {
                        recept[j].customer.repairArrivalTime = time;
                        watingRepair.add(recept[j].customer);
                        recept[j] = null;
                    }
                }
                //정비 대기줄에서 정비창구로
                for (int j = 0; j < repair.length; j++) {
                    if (repair[j] == null && !watingRepair.isEmpty()) {
                        repair[j] = new Pair(watingRepair.poll(), repairOperateTimes[j]);
                        repair[j].customer.repairNum = j + 1;
                    }
                }
                //정비 창구 진행
                for (int j = 0; j < repair.length; j++) {
                    if (repair[j] != null && repair[j].restTime > 0) {
                        repair[j].restTime -= 1;
                    }
                    if (repair[j] != null && repair[j].restTime == 0) {
                        if (repair[j].customer.receiptNum == A && repair[j].customer.repairNum == B) {
                            answer += repair[j].customer.ID;
                        }
                        finishedCustomer++;
                        repair[j] = null;
                    }
                }
                time++;
            }
            if (answer == 0) {
                answer = -1;
            }
            System.out.printf("#" + (i+1) + " " + answer + "\n");
        }
    }
}

class Customer implements Comparable<Customer> {
    int ID;
    int receiptNum;
    int repairNum;
    int receptArrivalTime;
    int repairArrivalTime;

    public Customer(int receptArrivalTime) {
        this.receptArrivalTime = receptArrivalTime;
    }

    @Override
    public int compareTo(Customer o) {
        if (repairArrivalTime > o.repairArrivalTime) {
            return 1;
        } else if (repairArrivalTime == o.repairArrivalTime) {
            if (receiptNum > o.receiptNum) {
                return 1;
            }
        }
        return -1;
    }

    public int compareForRecept(Customer o) {
        if (ID > o.ID) {
            return 1;
        }
        return -1;
    }
}

class Pair {
    int restTime;
    Customer customer;

    public Pair(Customer customer, int restTime) {
        this.restTime = restTime;
        this.customer = customer;
    }
}