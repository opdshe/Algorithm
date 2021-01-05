package 구현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 뉴스클러스터링 {
    public int solution(String a, String b) {
        List<String> aSplitList = getSplitList(a);
        List<String> bSplitList = getSplitList(b);
        int sizeOfIntersection = getSizeOfIntersection(aSplitList, bSplitList);
        int sizeOfUnion = getSizeOfUnion(aSplitList, bSplitList);
        return calculateJacard(sizeOfIntersection, sizeOfUnion);
    }

    private int calculateJacard(int sizeOfIntersection, int sizeOfUnion) {
        if (sizeOfIntersection == 0 && sizeOfUnion == 0) {
            return 65536;
        }
        return (int) ((float) sizeOfIntersection / (float) sizeOfUnion * 65536);
    }

    private static int getSizeOfUnion(List<String> aList, List<String> bList) {
        Set<String> intersection = new HashSet<>();
        intersection.addAll(aList);
        intersection.addAll(bList);
        int count = 0;
        for (String str : intersection) {
            int countOfA = (int) aList.stream()
                    .filter(split -> split.equals(str))
                    .count();
            int countOfB = (int) bList.stream()
                    .filter(split -> split.equals(str))
                    .count();
            count += Math.max(countOfA, countOfB);
        }
        return count;
    }

    private static int getSizeOfIntersection(List<String> aList, List<String> bList) {
        Set<String> intersection = new HashSet<>();
        intersection.addAll(aList);
        intersection.addAll(bList);
        int count = 0;
        for (String str : intersection) {
            int countOfA = (int) aList.stream()
                    .filter(split -> split.equals(str))
                    .count();
            int countOfB = (int) bList.stream()
                    .filter(split -> split.equals(str))
                    .count();
            count += Math.min(countOfA, countOfB);
        }
        return count;
    }

    private static List<String> getSplitList(String str) {
        List<String> splitList = new ArrayList<>();
        for (int startIdx = 0; startIdx < str.length() - 1; startIdx++) {
            String split = str.substring(startIdx, startIdx + 2).toUpperCase();
            if (isAlphabetic(split)) {
                splitList.add(split);
            }
        }
        return splitList;
    }

    private static boolean isAlphabetic(String str) {
        for (int idx = 0; idx < str.length(); idx++) {
            char character = str.charAt(idx);
            if (!Character.isAlphabetic(character)) {
                return false;
            }
        }
        return true;
    }
}
