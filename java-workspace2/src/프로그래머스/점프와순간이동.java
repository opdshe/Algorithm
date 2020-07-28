package 프로그래머스;

public class 점프와순간이동 {
    public static void main(String[] args) {
        solution(5000);
    }

    public static int solution(int n) {
        int ans = 0;
        while (n > 1) {
            //홀수
            if (n % 2 == 1) {
                n--;
                ans++;
            }
            n /= 2;
        }
        ans++;
        System.out.println(ans);
        return ans;
    }
}
