package programmers.kakaoWinterInternship_2019;

import java.util.*;

public class 호텔방배정 {
    static Map<Long, Long> rooms = new HashMap<>();

    public static void main(String[] args) {
        solution(10, new long[]{1, 3, 4, 1, 3, 1});
    }

    public static long[] solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        for(int i = 0; i < room_number.length; i++) {
            answer.add(reserve(room_number[i]));
        }
        System.out.println(Arrays.toString(answer.toArray()));
        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    private static long reserve(long l) {
        if(!rooms.containsKey(l)){
            rooms.put(l, l+1);
            return l;
        }
        List<Long> changeList = new ArrayList<>();
        while(rooms.containsKey(l)) {
            changeList.add(l);
            l = rooms.get(l);
        }
        long answer = l;
        changeList.add(l);
        for(long i : changeList) {
            rooms.put(i, l+1);
        }

        return answer;
    }
}
