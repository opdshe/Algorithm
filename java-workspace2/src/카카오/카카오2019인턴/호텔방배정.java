package 카카오.카카오2019인턴;


import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {
	static Map<Long, Long> rooms = new HashMap<>();

	public static void main(String[] args) {
		solution(10, new long[]{1, 3, 4, 1, 3, 1});
	}

	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		for (int idx = 0; idx < room_number.length; idx++) {
			long result = reserve(room_number[idx]);
			answer[idx] = result;
		}
		return answer;
	}

	private static long reserve(long order) {
		if (!rooms.containsKey(order)) {
			rooms.put(order, order + 1);
			return order;
		}
		rooms.put(order, reserve(rooms.get(order)));
		return rooms.get(order);
	}
}
