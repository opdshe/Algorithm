package 구현;

public class N진수게임 {
    static char[] characters = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

    public static String solution(int n, int t, int m, int p) {
        StringBuilder totalString = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int number = 0;
        while (totalString.length() < t * m) {
            totalString.append(getNNumber(n, number++));
        }

        int idx = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(totalString.charAt(idx));
            idx += m;
        }
        return answer.toString();
    }

    private static String getNNumber(int n, int target) {
        StringBuilder answer = new StringBuilder();
        while (target / n != 0) {
            int remainder = target % n;
            answer.insert(0, characters[remainder]);
            target = target / n;
        }
        answer.insert(0, characters[target % n]);
        return answer.toString();
    }
}
