package 라이브러리;

public class 조합만들기 {
	static boolean[] visited;
	static int[] array;
	static int[] numbers = new int[]{11, 33, 45, 21, 54, 100, 39, 40};
	static int count = 0;


	// n 개 고르기, n = 5
	public static void main(String[] args) {
		combine(5);
	}

	//3개
	private static void combine(int n) {
		visited = new boolean[numbers.length];
		array = new int[n];
		dfs(0, 0);
		System.out.println(count);
	}

	private static void dfs(int start, int level) {
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
				dfs(i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}
