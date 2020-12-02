package 구현;

public class 예상대진표 {
    public static void main(String[] args) {
        solution(8, 4, 7);
    }

    public static int solution(int n, int a, int b) {
        int round = 1;
        while ((b + 1) / 2 != (a + 1) / 2) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        System.out.println(round);
        return round;
    }
}