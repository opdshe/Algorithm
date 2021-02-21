package 그리디;

public class 점프와순간이동2 {
	public int solution(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				ans++;
				n -= 1;
			} else {
				n /= 2;
			}
		}
		return ans;
	}
}
