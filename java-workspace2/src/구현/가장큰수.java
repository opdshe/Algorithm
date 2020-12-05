package 구현;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {
    public static void main(String[] args) {
        solution(new int[]{0, 0, 0});
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<Integer> numList = new ArrayList<>();
        for (int number : numbers) {
            numList.add(number);
        }
        numList.sort(new myComparator().reversed());
        if (numList.get(0) == 0) {
            return "0";
        }
        numList.forEach(answer::append);
        System.out.println(answer.toString());
        return answer.toString();
    }

    private static class myComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return convertToString(o1).compareTo(convertToString(o2));
        }
    }

    private static String convertToString(int number) {
        int len = String.valueOf(number).length();
        int share = 12 / len;
        return String.valueOf(number).repeat(share);
    }
}
