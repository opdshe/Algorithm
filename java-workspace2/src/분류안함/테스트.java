package 분류안함;

import java.util.HashSet;
import java.util.Set;

public class 테스트 {

	public static void main(String[] args) {
		Set<Set<Integer>> set = new HashSet<>();
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		a.add(1);
		a.add(2);
		b.add(1);
		b.add(3);
		set.add(a);
		System.out.println(set.contains(b));

	}
}
