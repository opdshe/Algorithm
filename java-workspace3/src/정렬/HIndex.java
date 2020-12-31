package 정렬;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int count = 1; count <= citations.length; count++) {
            int c = 0;
            for (int idx = 0; idx < citations.length; idx++) {
                if (citations[idx] >= count) {
                    c = citations.length - idx;
                    break;
                }
            }
            if (c >= count) {
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}
