package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 올바른배열 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int countOfNumbers;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		countOfNumbers = Integer.parseInt(bufferedReader.readLine());
		numbers = new int[countOfNumbers];
		for (int i = 0; i < countOfNumbers; i++) {
			numbers[i] = Integer.parseInt(bufferedReader.readLine());
		}
		Arrays.sort(numbers);
	}

	private static void solution() {
		int left = 0;
		int right = 0;
	}
}
