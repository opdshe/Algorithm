package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfHouse = scanner.nextInt();
        int countOfMachine = scanner.nextInt();
        int[] house = new int[countOfHouse];
        for (int idx = 0; idx < countOfHouse; idx++) {
            house[idx] = scanner.nextInt();
        }
        int maxDistance = getMaxDistance(house, countOfHouse, countOfMachine);
        System.out.println(maxDistance);
    }

    private static int getMaxDistance(int[] house, int countOfHouse, int countOfMachine) {
        Arrays.sort(house);
        int left = 1;
        int right = house[house.length - 1];
        int max = 0;
        while (left <= right) {
            int count = 1;
            int maxDistance = (left + right) / 2;
            int currentPosition = house[0];
            for (int idx = 1; idx < countOfHouse; idx++) {
                if (house[idx] - currentPosition >= maxDistance) {
                    currentPosition = house[idx];
                    count++;
                }
            }
            if (count < countOfMachine) {
                right = maxDistance - 1;
            } else {
                max = Math.max(max, maxDistance);
                left = maxDistance + 1;
            }
        }
        return max;
    }
}
