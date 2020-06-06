package programmers.dfds_bfs;

import java.util.*;
import java.util.stream.Collectors;

public class 여행경로 {
    private static List<List<String>> answer = new ArrayList<>();
    public static void main(String[] args) {
        solution(new String[][]{{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}});
    }

    public static String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                List<Integer> passed = new ArrayList<>();
                passed.add(i);
                dfs(tickets, passed, i);
            }
        }
        answer.sort(new myComparator());
        String[] ans = answer.get(0).toArray(new String[answer.get(0).size()]);
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static class myComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i).compareTo(o2.get(i)) > 0){
                    return 1;
                } else if(o1.get(i).compareTo(o2.get(i))== 0){
                    continue;
                }
                return -1;
            }
            return 0;
        }

    }

    private static List<String> dfs(String[][] tickets, List<Integer> passed, int currentIdx) {
        if (passed.size() == tickets.length) {
            List<String> strRoute = passed.stream()
                    .map(i -> tickets[i][0])
                    .collect(Collectors.toList());
            strRoute.add(tickets[passed.get(passed.size() - 1)][1]);
            answer.add(strRoute);
            return strRoute;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(tickets[currentIdx][1]) && !passed.contains(i)) {
                List<Integer> newPassed = new ArrayList<>(passed);
                newPassed.add(i);
                dfs(tickets, newPassed, i);
            }
        }
        return null;
    }
}
