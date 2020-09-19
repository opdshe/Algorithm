package 카카오.카카오2019인턴;

import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {
	static Map<Long, Long> order = new HashMap<>();
	static long[] answer;

	public static void main(String[] args) {
		solution(10, new long[]{1, 3, 4, 1, 3, 1});
	}

	public static long[] solution(long k, long[] room_number) {
		answer = new long[room_number.length];
		for (int i = 0; i < room_number.length; i++) {
			long reserveRoomNum;
			if (order.containsKey(room_number[i])) {
				reserveRoomNum = reserve(order.get(room_number[i]));
			} else {
				order.put(room_number[i], room_number[i] + 1);
				reserveRoomNum = room_number[i];
			}
			answer[i] = reserveRoomNum;
		}
		return answer;
	}

	private static long reserve(long room) {
		//배정되지 않은 경우
		if (!order.containsKey(room)) {
			order.put(room, room + 1);
			return room;
		}
		//이미 배정된 경우
		else {
			long roomNumber = reserve(order.get(room));
			order.put(room, roomNumber);
			return roomNumber;
		}
	}
}
