package 테스트;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestClass {
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple(3), new Apple(2), new Apple(1));
		apples.sort(Comparator.comparing(Apple::getWeight));
		apples.forEach(System.out::println);
	}

	private static class Apple {
		private int weight;

		public Apple(int weight) {
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return "Apple{" +
					"weight=" + weight +
					'}';
		}
	}
}
