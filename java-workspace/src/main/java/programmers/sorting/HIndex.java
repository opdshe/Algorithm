package programmers.sorting;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        solution(new int[]{44,22});
    }

    public static int solution(int[] citations) {
        int min = 0;
        int maxCount = citations.length;
        int maxH = min;
        for (int h = 0; h <= maxCount; h++) {
            int finalH = h;
            int overThanH = (int) Arrays.stream(citations)
                    .filter(integer->integer >= finalH)
                    .count();
            if (overThanH >= finalH) {
                maxH = finalH;
                continue;
            }
            break;
        }
        System.out.println(maxH);
        return maxH;
    }
}
