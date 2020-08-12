package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfHouse = scanner.nextInt();
        int countOfModem = scanner.nextInt();
        int[] houses = new int[countOfHouse];
        for (int i = 0; i < countOfHouse; i++) {
            int housePosition = scanner.nextInt();
            houses[i] = housePosition;
        }
        Arrays.sort(houses);
        System.out.println(binarySearch(houses, countOfHouse, countOfModem));

    }

    private static int binarySearch(int[] houses, int countOfHouse, int countOfModem) {
        int answer = 0;
        int left = 1;
        int right = houses[countOfHouse - 1] - houses[0];

        while (left <= right) {
            int count = 1;
            int mid = (right + left) / 2;
            int start = houses[0];
            for (int i = 1; i < countOfHouse; i++) {
                int distance = houses[i] - start;
                if (mid <= distance) {
                    count++;
                    start = houses[i];
                }
            }
            if (count >= countOfModem) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
