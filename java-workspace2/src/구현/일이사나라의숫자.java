package 구현;

public class 일이사나라의숫자 {
    public static String solution(int n) {
        return getConverted(n);
    }

    private static String getConverted(int n) {
        StringBuilder result = new StringBuilder();
        do {
            int remainder = n % 3;
            n = n / 3;
            if (remainder == 0) {
                remainder = 4;
                n--;
            }
            result.insert(0, remainder);
        } while (n / 3 != 0);
        if (n != 0) {
            result.insert(0, n);
        }
        return result.toString();
    }
}
