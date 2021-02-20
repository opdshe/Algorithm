package 분류안함;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 테스트 {
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 2, 3);
		List<Integer> b = Arrays.asList(2, 3, 4);
		List<Integer> common = new ArrayList<>(a);
		common.retainAll(b);
		System.out.println(Arrays.toString(common.toArray()));
	}
}
