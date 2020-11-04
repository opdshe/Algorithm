package 구현;

import java.io.*;

public class 수정렬하기3 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(bufferedReader.readLine());
		int[] counts = new int[10001];
		for (int idx = 0; idx < countOfNumber; idx++) {
			int target = Integer.parseInt(bufferedReader.readLine());
			counts[target]++;
		}
		for (int num = 1; num <= 10000; num++) {
			for (int count = 1; count <= counts[num]; count++) {
				bufferedWriter.write(String.valueOf(num));
				bufferedWriter.newLine();
			}
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}
}
