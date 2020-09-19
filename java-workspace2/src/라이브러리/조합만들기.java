package 라이브러리;

public class 조합만들기 {
	static boolean[] visited;
	static int[] array;
	static int count = 0;


	// n 개 고르기
	public static void main(String[] args) {
		int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
		combine(numbers, 3);
	}

	//3개
	private static void combine(int[] numbers, int n) {
		visited = new boolean[numbers.length];
		array = new int[n];
		dfs(numbers, 0, 0);
		System.out.println(count);
	}

	private static void dfs(int[] numbers, int start, int level) {
		if (level == array.length) {
			count++;
			for (int value : array) {
				System.out.print(numbers[value] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[level] = i;
				dfs(numbers, i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}
