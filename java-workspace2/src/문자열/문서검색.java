package 문자열;

import java.util.Scanner;

public class 문서검색 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String origin = scanner.nextLine();
		String unit = scanner.nextLine();
		int currentIdx = 0;
		int count = 0;
		while (currentIdx <= origin.length() - unit.length()) {
			String sub = origin.substring(currentIdx, currentIdx + unit.length());
			if (sub.equals(unit)) {
				currentIdx += unit.length();
				count++;
			} else {
				currentIdx++;
			}
		}
		System.out.println(count);
	}
}
