package 구현;

public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int answer = 1;
        a++;
        b++;
        while (a / 2 != b / 2) {
            answer++;
            a /= 2;
            b /= 2;
            a++;
            b++;
        }
        return answer;
    }
}
