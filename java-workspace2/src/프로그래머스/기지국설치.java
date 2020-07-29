package 프로그래머스;

import java.util.Arrays;
import java.util.regex.Pattern;

public class 기지국설치 {
    public static void main(String[] args) {
        solution(16, new int[]{9}, 2);
    }

    public static int solution(int n, int[] stations, int w) {
        int stationIdx = 0;
        int currentPosition = 1;
        int answer = 0;

        while (currentPosition <= n) {
            System.out.println("current : " + currentPosition);
            if (stationIdx > stations.length-1) {
                System.out.println("install at : " + (currentPosition + w));
                currentPosition = currentPosition + 2 * w + 1;
                answer++;
                continue;
            }
            if (currentPosition < stations[stationIdx] - w) {
                System.out.println("install at : " + (currentPosition + w));
                currentPosition = currentPosition + 2 * w + 1;
                answer++;
            } else {
                currentPosition = stations[stationIdx] + w + 1;
                stationIdx++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
