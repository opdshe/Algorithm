package 토스코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오번 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //"100 300 10 0 40 0 0 70 65"
        //"40 300 20 10 10 20 100 10 0"
        int[] kimToss = Arrays.stream("0 30 40 200".split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] leeToss = Arrays.stream("30 40 50 60".split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        printResult(kimToss, leeToss);
    }

    private static void printResult(int[] kimToss, int[] leeToss) {
        int length = kimToss.length;
        int debt = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            System.out.println("kim : " + kimToss[i]);
            System.out.println("lee : " + leeToss[i]);
            System.out.println("debt: " + debt);
            int original = kimToss[i] - leeToss[i];
            int value = kimToss[i] - leeToss[i] + debt;
            if (value < 0) {
                debt += original;
                System.out.println("add debt: " + original);
                value = 0;
            } else {
                debt = 0;
            }
            System.out.println("current debt: " + debt);
            System.out.println("==========");
            stringBuilder.append(value).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
