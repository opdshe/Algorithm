package 기출.카카오.카카오2020인턴;

public class 키패드누르기 {
	static String[][] keypad = new String[][]{
			{"1", "2", "3"},
			{"4", "5", "6"},
			{"7", "8", "9"},
			{"*", "0", "#"},
	};
	static String mainHand;
	static int[] leftHand = new int[]{3, 0};
	static int[] rightHand = new int[]{3, 2};

	public static void main(String[] args) {
		solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
	}

	public static String solution(int[] numbers, String hand) {
		mainHand = hand;
		StringBuilder answer = new StringBuilder();
		for (int number : numbers) {
			answer.append(push(number));
		}
		System.out.println(answer.toString());
		return answer.toString();
	}

	private static String push(int number) {
		if (number == 1 || number == 4 || number == 7) {
			leftHand = getKeyPosition(number);
			return "L";
		} else if (number == 3 || number == 6 || number == 9) {
			rightHand = getKeyPosition(number);
			return "R";
		} else {
			int[] keyPosition = getKeyPosition(number);
			int result = compareDistance(keyPosition);
			if (result > 0) {
				leftHand = keyPosition;
				return "L";
			} else if (result < 0) {
				rightHand = keyPosition;
				return "R";
			} else {
				if (mainHand.equals("right")) {
					rightHand = keyPosition;
					return "R";
				} else {
					leftHand = keyPosition;
					return "L";
				}
			}
		}
	}

	private static int[] getKeyPosition(int number) {
		for (int height = 0; height < 4; height++) {
			for (int width = 0; width < 3; width++) {
				if (keypad[height][width].equals(String.valueOf(number))) {
					return new int[]{height, width};
				}
			}
		}
		return null;
	}

	private static int compareDistance(int[] keyPosition) {
		int rightHandDistance = Math.abs(rightHand[0] - keyPosition[0]) + Math.abs(rightHand[1] - keyPosition[1]);
		int leftHandDistance = Math.abs(leftHand[0] - keyPosition[0]) + Math.abs(leftHand[1] - keyPosition[1]);
		return rightHandDistance - leftHandDistance;
	}
}