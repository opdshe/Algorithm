package 구현;

import java.util.Scanner;

public class 도로와신호등 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int time = 0;
		int countOfLight = scanner.nextInt();
		int length = scanner.nextInt();
		int currentPosition = 0;
		for (int i = 0; i < countOfLight; i++) {
			int position = scanner.nextInt();
			int red = scanner.nextInt();
			int green = scanner.nextInt();
			time += position - currentPosition;
			time += getStartTime(time, red, green) - time;
			currentPosition = position;
		}
		time += length - currentPosition;
		System.out.println(time);
	}

	private static int getStartTime(int time, int red, int green) {
		int startTime = -1;
		boolean isRed = true;
		int currentTime = 0;
		while (true) {
			int nextTime = isRed ? currentTime + red : currentTime + green;
			if (currentTime <= time && time < nextTime) {
				startTime = isRed ? nextTime : time;
				break;
			}
			currentTime = nextTime;
			isRed = !isRed;
		}
		return startTime;
	}
}
