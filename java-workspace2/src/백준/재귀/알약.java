package 백준.재귀;

import java.util.Scanner;

public class 알약 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int countOfPill = scanner.nextInt();
            //System.out.println("countOfPill =" + countOfPill);
            getAvailableCase(countOfPill);
        }
    }

    private static void getAvailableCase(int countOfPill) {
        calculate(countOfPill - 1, 1);
        System.out.println(answer);
        answer = 0;
    }

    private static void calculate(int whole, int half) {
        if (whole > 0 || half > 0) {
            if (half > 0) {
                calculate(whole, half - 1);
                answer++;
            }
            if (whole > 0) {
                calculate(whole - 1, half + 1);
                answer++;
            }
        }
    }
}
