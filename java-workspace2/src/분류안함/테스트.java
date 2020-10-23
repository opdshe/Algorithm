package 분류안함;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 테스트 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int idx = 1; idx <= 5; idx++) {
			list.add(idx);
		}
		list.remove(Integer.valueOf(1));
		System.out.println(Arrays.toString(list.toArray()));
	}
}
