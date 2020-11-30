package 완전탐색;

import java.util.*;

public class 풍선터트리기 {
    private static Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) {
        solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33});
        System.out.println(Arrays.toString(answer.toArray()));
    }

    public static int solution(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        dfs(list, false);
        System.out.println(answer.size());
        return answer.size();
    }

    private static void dfs(List<Integer> list, boolean destroyed) {
        System.out.println(Arrays.toString(list.toArray()));
        if (list.size() == 1) {
            answer.add(list.get(0));
            return;
        }
        Integer lower = Math.min(list.get(0), list.get(1));
        Integer upper = Math.max(list.get(0), list.get(1));
        int lowerIdx = list.indexOf(lower);
        int upperIdx = list.indexOf(upper);
        list.remove(upper);
        dfs(list, destroyed);
        list.add(upperIdx, upper);

        if (!destroyed) {
            list.remove(lower);
            dfs(list, true);
            list.add(lowerIdx, lower);
        }

    }
}