package 라이브러리;


public class N개의최소공배수 {
	public static void main(String[] args) {
		solution(new int[]{2, 6, 8, 14});
	}

	public static int solution(int[] arr) {
		int currentLcm = arr[0];
		for (int idx = 1; idx < arr.length; idx++) {
			currentLcm = getLcm(currentLcm, arr[idx]);
		}
		return currentLcm;
	}

	private static int getLcm(int a, int b) {
		return a * b / getGcd(a, b);
	}

	private static int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return getGcd(b, a % b);
		}
	}
}
