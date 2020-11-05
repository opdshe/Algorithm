package 기출.우테코;

public class 사번 {
	public static void main(String[] args) {
		solution(new int[]{99, 102}, new int[]{211, 212});
	}

	private static int solution(int[] pobi, int[] crong) {
		if (!isAvailableInput(pobi, crong)) {
			System.out.println(-1);
			return -1;
		}
		int pobiScore = getMaxScore(pobi);
		int crongScore = getMaxScore(crong);
		if (pobiScore > crongScore) {
			System.out.println(1);
			return 1;
		} else if (pobiScore < crongScore) {
			System.out.println(2);
			return 2;
		} else {
			System.out.println(0);
			return 0;
		}
	}

	private static int getMaxScore(int[] user) {
		int result = 0;
		for (int page : user) {
			int totalAdd = 0;
			int totalMul = 1;
			String convertedPage = String.valueOf(page);
			for (int idx = 0; idx < convertedPage.length(); idx++) {
				int digit = Integer.parseInt(String.valueOf(convertedPage.charAt(idx)));
				totalAdd += digit;
				totalMul *= digit;
			}
			int pageMax = Math.max(totalAdd, totalMul);
			result = Math.max(result, pageMax);
		}
		return result;
	}

	private static boolean isAvailableInput(int[] pobi, int[] crong) {
		return isAvailablePages(pobi) && isAvailablePages(crong);
	}

	private static boolean isAvailablePages(int[] pages) {
		return pages[0] < pages[1] && Math.abs(pages[1] - pages[0]) == 1;
	}
}
