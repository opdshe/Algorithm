package 다이나믹프로그래밍;

import java.util.Scanner;

public class 퇴사 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfConsult = scanner.nextInt();
        Consult[] consults = new Consult[countOfConsult + 1];
        for (int i = 1; i <= countOfConsult; i++) {
            int time = scanner.nextInt();
            int profit = scanner.nextInt();
            consults[i] = new Consult(time, profit);
        }

        int[] dp = new int[countOfConsult + 1];
        int answer = getMaxProfit(consults, dp, countOfConsult, 1);
        System.out.println(answer);
    }

    private static int getMaxProfit(Consult[] consults, int[] dp, int countOfConsult, int day) {
        if (day > countOfConsult) {
            return 0;
        }
        if (dp[day] != 0) {
            return dp[day];
        }
        Consult consult = consults[day];
        int include = 0;
        int notInclude;
        if (day + consult.time <= countOfConsult + 1) {
            include = consult.profit + getMaxProfit(consults, dp, countOfConsult, day + consult.time);
        }
        notInclude = getMaxProfit(consults, dp, countOfConsult, day + 1);
        return dp[day] = Math.max(include, notInclude);
    }

    private static class Consult {
        int time;
        int profit;

        public Consult(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }
}
