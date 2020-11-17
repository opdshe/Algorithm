package 분류안함;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 테스트 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1111");
		list.add("2222");
		list.sort(Comparator.reverseOrder());
		System.out.println(Arrays.toString(list.toArray()));
	}

}
