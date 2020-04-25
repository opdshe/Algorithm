package programmers.kakaoBlindRecruit_2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        solution("aa1+aa2",	"AAAA12");
    }

    public static int solution(String str1, String str2) {
        List<String> onlyAlpahFirst = makeOnlyAlphabet(str1);
        List<String> onlyAlpahSecond = makeOnlyAlphabet(str2);
        int interNum = getIntersection(onlyAlpahFirst, onlyAlpahSecond);
        int unionNum = getUnion(onlyAlpahFirst, onlyAlpahSecond);
        System.out.println(getJacard(interNum, unionNum));
        return getJacard(interNum, unionNum);
    }

    private static List<String> makeOnlyAlphabet(String dirtyInput) {
        List<String> onlyAlphaSet = new ArrayList<>();
        for (int i =0; i < dirtyInput.length()-1; i++) {
            String sub = dirtyInput.substring(i, i+2);
            int count = 0;
            for (int j = 0; j< sub.length(); j++) {
                if (Character.isAlphabetic(sub.charAt(j))) {
                    count++;
                }
            }
            if (count == 2) {
                onlyAlphaSet.add(sub.toUpperCase());
            }
        }
        return onlyAlphaSet;
    }

    private static int getIntersection (List<String> onlyAlpha, List<String> onlyAlphaAnother) {
        Set<String> set = new HashSet<>();
        set.addAll(onlyAlpha);
        set.addAll(onlyAlphaAnother);
        int count =0;
        for (String s : set) {
            if (onlyAlphaAnother.contains(s)) {
                count += Math.min(onlyAlpha.stream().filter(i->i.equals(s)).count(), onlyAlphaAnother.stream().filter(i -> i.equals(s)).count());
            }
        }
        return count;
    }

    private static int getUnion (List<String> onlyAlpha, List<String> onlyAlphaAnother) {
        int count = 0;
        Set<String> set = new HashSet<>();
        set.addAll(onlyAlpha);
        set.addAll(onlyAlphaAnother);
        for (String s : set) {
            int currentCount =0;
            currentCount = (int) Math.max(currentCount, onlyAlpha.stream().filter(i->i.equals(s)).count());
            currentCount = (int) Math.max(currentCount, onlyAlphaAnother.stream().filter(i->i.equals(s)).count());
            count += currentCount;
        }
        return count;
    }

    private static int getJacard(int num1, int num2) {
        if (num1 == 0 && num2 == 0) {
            return 65536;
        }
        return (int) ((float)num1 / (float) num2*65536);
    }
}
