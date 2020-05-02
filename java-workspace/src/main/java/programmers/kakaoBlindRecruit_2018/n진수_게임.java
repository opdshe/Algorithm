package programmers.kakaoBlindRecruit_2018;

public class n진수_게임 {
    public static void main(String[] args) {
        solution(16, 16, 2, 1);
    }

    public static String solution(int n, int t, int m, int p) {
        String totalString = makeTotalString(n, t, m);
        StringBuilder answer = new StringBuilder();
        int idx = p - 1;
        for (int i =0; i < t; i++) {
            answer.append(totalString.charAt(idx));
            idx += m;
        }
        System.out.println(answer);
        return answer.toString();
    }

    private static String makeTotalString(int n, int t, int m) {
        StringBuilder stringBuilder = new StringBuilder();
        int maxLen = t * m;
        int num = 0;
        while (stringBuilder.length() < maxLen) {
            stringBuilder.append(makeNnumber(n, num));
            num++;
        }
        return stringBuilder.toString();
    }

    private static String makeNnumber(int n, int x) {
        Character[] entry = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder answer = new StringBuilder();
        while (x / n != 0) {
            int a = x % n;
            answer.insert(0, entry[a]);
            x = x / n;
        }
        answer.insert(0, entry[x % n]);
        return answer.toString();
    }
}
