package 그리디;


import java.util.Arrays;

public class 숫자게임 {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int answer = 0;
		int nextIdx = 0;
		for (int b : B) {
			for (int aIdx = nextIdx; aIdx < A.length; aIdx++) {
				if (b > A[aIdx]) {
					answer++;
					nextIdx = aIdx + 1;
					break;
				}
			}
		}
		return answer;
	}

}
