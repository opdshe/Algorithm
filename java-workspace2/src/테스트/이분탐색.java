package 테스트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이분탐색 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(30);
		list.add(50);
		System.out.println(Collections.binarySearch(list, 15));
	}
}
