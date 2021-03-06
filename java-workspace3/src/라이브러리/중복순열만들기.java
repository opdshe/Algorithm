package 라이브러리;

public class 중복순열만들기 {
	static boolean[] visited;
	static int[] array;
	static int count = 0;


	// n 개 고르기, n = 5
	public static void main(String[] args) {
		int[] numbers = new int[]{1, 2, 3};
		duplicatedPermutation(numbers, 3);
	}

	private static void duplicatedPermutation(int[] numbers, int n) {
		visited = new boolean[numbers.length];
		array = new int[n];
		dfs(numbers, n, 0);
		System.out.println(count);
	}

	private static void dfs(int[] numbers, int n, int level) {
		if (level == n) {
			count++;
			for (int value : array) {
				System.out.print(numbers[value] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			array[level] = i;
			dfs(numbers, n, level + 1);
		}
	}
}
