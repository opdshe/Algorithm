package 분류안함;

import java.util.Scanner;

public class 음식평론가 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfFood = scanner.nextInt();
		int countOfPeople = scanner.nextInt();
	}

	private static void solution(int countOfFood, int countOfPeople) {
		if (countOfPeople == 1) {
			System.out.println(0);
			return;
		}
		//배수인 경우
		if (countOfPeople % countOfFood == 0) {
			int cutForOne = (countOfPeople / countOfFood) - 1;
			System.out.println(countOfFood * cutForOne);
		} else {

		}
	}
}
