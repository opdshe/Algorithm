package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 테스트 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = Arrays.asList(1, 2, 5, 6, 7, 8);
        List<Integer> distinct = new ArrayList<>();
        a.forEach(integer -> {
            if (b.contains(integer)) {
                distinct.add(integer);
            }
        });
        a.removeAll(distinct);
        b.removeAll(distinct);
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
    }

}
