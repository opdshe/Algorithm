package 구현;

public class 다음큰숫자 {
    public static void main(String[] args) {
        solution(78);
    }

    public static int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int countOfOne = getCountOfOne(binaryN);
        int target = n + 1;
        while (true) {
            String stringTarget = Integer.toBinaryString(target);
            int countOfOneTarget = getCountOfOne(stringTarget);
            if (countOfOneTarget == countOfOne) {
                break;
            }
            target++;
        }
        return target;
    }

    private static int getCountOfOne(String binary) {
        int count = 0;
        for (int idx = 0; idx < binary.length(); idx++) {
            if (binary.charAt(idx) == '1') {
                count++;
            }
        }
        return count;
    }
}
