package 다이나믹프로그래밍;

import java.util.*;

public class 보석도둑 {
	static Scanner scanner = new Scanner(System.in);
	static List<Jewelry> jewelries = new ArrayList<>();
	static int[] bags;

	public static void main(String[] args) {
		int countOfBag = scanner.nextInt();
		int countOfJewelry = scanner.nextInt();
		bags = new int[countOfBag];
		for (int idx = 0; idx < countOfBag; idx++) {
			int weight = scanner.nextInt();
			int value = scanner.nextInt();
			jewelries.add(new Jewelry(weight, value));
		}
		for (int idx = 0; idx < countOfJewelry; idx++) {
			bags[idx] = scanner.nextInt();
		}
		jewelries.sort(Comparator.comparing(Jewelry::getValue)
				.thenComparing(Jewelry::getWeight)
				.reversed());
		Arrays.sort(bags);

		solution(countOfBag, countOfJewelry);
	}

	private static int solution(int countOfBag, int countOfJewelry) {
		int sum = 0;
		for (int idx = countOfBag - 1; idx >= 0; idx--) {
			int bag = bags[idx];
			Jewelry target = null;
			for (Jewelry jewelry : jewelries) {
				if (bag >= jewelry.weight) {
					target = jewelry;
					break;
				}
			}
			if (target != null) {
				jewelries.remove(target);
				sum += target.value;
			}
		}
		System.out.println(sum);
		return sum;
	}

	private static class Jewelry {
		private int weight;
		private int value;

		public Jewelry(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		public int getWeight() {
			return weight;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Jewelry{" +
					"weight=" + weight +
					", value=" + value +
					'}';
		}
	}
}
