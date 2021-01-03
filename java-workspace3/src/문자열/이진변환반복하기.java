package 문자열;

public class 이진변환반복하기 {
    static int countOfRemovedZero = 0;

    public int[] solution(String s) {
        int countOfReformat = 0;
        while (!s.equals("1")) {
            countOfReformat++;
            s = getNoZeroString(s);
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{countOfReformat, countOfRemovedZero};
    }

    private static String getNoZeroString(String origin) {
        String noZeroString = origin.replace("0", "");
        int countOfZero = origin.length() - noZeroString.length();
        countOfRemovedZero += countOfZero;
        return noZeroString;
    }
}
