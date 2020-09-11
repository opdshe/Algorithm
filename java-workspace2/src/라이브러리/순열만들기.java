package 라이브러리;

public class 순열만들기 {
	static boolean[] visited;
	static int[] array;
	static int[] numbers = new int[]{11, 33, 45, 21, 54, 100, 39, 40};
	static int count = 0;


	// n 개 고르기, n = 5
	public static void main(String[] args) {
		permutation(5);
	}

	//3개
	private static void permutation(int n) {
		visited = new boolean[numbers.length];
		array = new int[n];
		dfs(n, 0);
		System.out.println(count);
	}

	private static void dfs(int n, int level) {
		if (level == array.length) {
			count++;
			for (int value : array) {
				System.out.print(numbers[value] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[level] = i;
				dfs(n, level + 1);
				visited[i] = false;
			}
		}
	}
}
