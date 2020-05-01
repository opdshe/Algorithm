package programmers.kakaoBlindRecruit_2019;

import java.util.*;
import java.util.stream.IntStream;

public class 후보키 {
    public static void main(String[] args) {

        solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
    }

    public static int solution(String[][] relation) {
        int answer = 0;
        int col = relation[0].length;
        int row = relation.length;
        List<String> answerIdxSet = new ArrayList<>();
        List<String> answerSet = new ArrayList<>();
        for (int len = 1; len <= col; len++) {
            for (int i = 0; i < col - len + 1; i++) {
                Set<String> set = new HashSet<>();
                for (int j = 0; j < row; j++) {
                    StringBuilder oneRow = new StringBuilder();
                    for (int k = 0; k < len; k++) {
                        oneRow.append(relation[j][i + k]);
                    }
                    set.add(oneRow.toString());
                }
                if (set.size() == row) {
                    answerIdxSet.add(IntStream.range(i, i + len).mapToObj(String::valueOf).reduce((a, b) -> a + b).get());
                }
            }
        }
        for(String pidx : answerIdxSet) {
            answerSet.forEach(cidx -> {
                if (pidx.contains(cidx)) {
                    answerSet.add(pidx);
                }
            });
        }
        return answerSet.size();
    }
}
