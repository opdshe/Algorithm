package 다이나믹프로그래밍;

public class 스티커모으기 {
	public static void main(String[] args) {
		solution(new int[]{14});
	}

	public static int solution(int sticker[]) {
		if (sticker.length == 1) {
			return sticker[0];
		}
		int[] dp1 = new int[sticker.length + 1];
		int[] dp2 = new int[sticker.length + 1];
		dp1[0] = 0;
		dp1[1] = sticker[0];
		dp2[0] = 0;
		dp2[1] = 0;
		for (int idx = 2; idx <= sticker.length; idx++) {
			dp1[idx] = Math.max(dp1[idx - 1], dp1[idx - 2] + sticker[idx - 1]);
			dp2[idx] = Math.max(dp2[idx - 1], dp2[idx - 2] + sticker[idx - 1]);
		}
		return Math.max(dp1[sticker.length - 1], dp2[sticker.length]);
	}
}
