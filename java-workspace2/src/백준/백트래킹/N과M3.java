package 백준.백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.IntStream;

public class N과M3 {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[] array;
	static boolean[] visited;
	static Vector<Integer> list = new Vector<>();

	public static void main(String[] args) throws IOException {
		N = scanner.nextInt();
		M = scanner.nextInt();
		visited = new boolean[N + 1];
		array = new int[M];
		int[] numbers = IntStream.rangeClosed(1, N)
				.toArray();
		duplicatedPermutation(numbers, M);
		bufferedWriter.flush();
		bufferedWriter.close();

	}

	private static void duplicatedPermutation(int[] numbers, int n) throws IOException {
		visited = new boolean[numbers.length];
		array = new int[n];
		dfs(numbers, n, 0);
	}

	private static void dfs(int[] numbers, int n, int level) throws IOException {
		if (level == n) {
			for (int value : array) {
				bufferedWriter.write(numbers[value] + " ");
			}
			bufferedWriter.write("\n");
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			array[level] = i;
			dfs(numbers, n, level + 1);
		}
	}
}
