package 백준.이분탐색;

import java.util.Scanner;

public class 그렘린 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int[] countOfEgg = new int[N];
        int[] yearsToBeGrown = new int[N];
        for (int i = 0; i < 3 * N; i++) {
            countOfEgg[i] = scanner.nextInt();
            yearsToBeGrown[i] = scanner.nextInt();
            int kindOfEgg = scanner.nextInt();
            int yearsToBeBirth = scanner.nextInt();
        }
    }
}
