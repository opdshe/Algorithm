package programmers.kakaoBlindRecruit_2019;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 후보키 {
    static String[][] board;
    static int count = 0;
    static List<List<Integer>> meetUniqueness = new ArrayList<>();

    public static void main(String[] args) {
        int subSet = 3;
        System.out.println(subSet & 1<<1);
        //solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
    }

    public static int solution(String[][] relation) {
        board = relation;
        findMeetUniqueness(relation);
        /*for (List<Integer> idxList : meetUniqueness) {
            System.out.println(Arrays.toString(idxList.toArray()));
        }*/
        findMeetMinimality();
        System.out.println(count);
        return count;
    }

    private static void findMeetMinimality() {
        while (!meetUniqueness.isEmpty()) {
            List<Integer> list = meetUniqueness.remove(0);
            System.out.println(Arrays.toString(list.toArray()));
            count ++;
            meetUniqueness = meetUniqueness.stream()
                    .filter(idxList->!idxList.containsAll(list))
                    .collect(Collectors.toList());
        }
    }

    public static void findMeetUniqueness(String[][] relation) {
        int maxRow = relation.length;
        int maxCol = relation[0].length;
        for (int len = 1; len < maxCol + 1; len++) {
            for (int col = 0; col <= maxCol - len; col++) {
                Set<String> set = new HashSet<>();
                for (int row = 0; row < maxRow; row++) {
                    String sub = makeString(row, col, len);
                    set.add(sub);
                }
                if (set.size() == maxRow) {
                    List<Integer> idxList = IntStream.range(col, col + len).boxed().collect(Collectors.toList());
                    meetUniqueness.add(idxList);
                }
            }
        }
    }

    public static String makeString(int row, int column, int len) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(column, column + len).forEach(integer -> stringBuilder.append(board[row][integer]));
        return stringBuilder.toString();
    }
}
