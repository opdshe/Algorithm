package programmers.etc;


public class 기지국설치 {

    public static void main(String[] args) {
        solution(11, new int[]{4, 11}, 1);
    }

    public static int solution(int n, int[] stations, int w) {
        int currentIdx = 1;
        int stationIdx = 0;
        int answer = 0;
        while (currentIdx <= n) {
            if (stationIdx < stations.length && currentIdx >= stations[stationIdx] - w) {
                currentIdx = stations[stationIdx] + w + 1;
                stationIdx++;
                continue;
            }
            answer++;
            currentIdx += (w * 2) + 1;
        }
        System.out.println(answer);
        return answer;
    }
}
