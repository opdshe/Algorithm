package 프로그래머스.DFS_BFS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 여행경로 {
    static String start = "ICN";
    static boolean[] used;
    static List<String[]> answer = new ArrayList<>();

    public static void main(String[] args) {
        solution(new String[][]{{"ICN", "AAA"}, {"ICN", "BBB"}, {"BBB", "ICN"}});
    }

    public static String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start)) {
                used[i] = true;
                List<String> ticketList = new ArrayList<>();
                ticketList.add(start);
                dfs(tickets, tickets[i], ticketList);
                used[i] = false;
            }
        }
        answer.sort(new myComparator());
        String[] ticket = answer.stream()
                .findFirst()
                .get();
        return ticket;
    }

    private static void dfs(String[][] tickets, String[] currentTicket, List<String> ticketList) {
        if (ticketList.size() == tickets.length) {
            ticketList.add(currentTicket[1]);
            String[] ticket = new String[ticketList.size()];
            ticketList.toArray(ticket);
            answer.add(ticket);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            String source = tickets[i][0];
            if (source.equals(currentTicket[1]) && !used[i]) {
                ticketList.add(source);
                used[i] = true;
                dfs(tickets, tickets[i], ticketList);
                used[i] = false;
            }
        }
    }

    private static class myComparator implements Comparator<String[]> {

        @Override
        public int compare(String[] o1, String[] o2) {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i].compareTo(o2[i]) > 0) {
                    return 1;
                } else if (o1[i].compareTo(o2[i]) == 0) {
                    continue;
                }
                return -1;
            }
            return -1;
        }
    }
}