package 네이버2020하반기;

public class 일번 {
	public static void main(String[] args) {
		solution(6, new int[]{5, 4, 7, 2, 0, 6}, new int[]{4, 6, 4, 9, 2, 3});
	}

	public static String solution(int n, int[] p, int[] c) {
		//p는 생산량, c 주문량
		int stock = 0;
		int income = 0;
		int unitPrice = 100;
		int fail = 0;
		int days = -1;
		for (int idx = 0; idx < n; idx++) {
			stock += p[idx];
			if (stock >= c[idx]) {
				stock -= c[idx];
				income += (unitPrice * c[idx]);
				fail = 0;
				unitPrice = 100;
			} else {
				fail++;
				if (fail == 1) {
					unitPrice = 50;
				} else if (fail == 2) {
					unitPrice = 25;
				} else if (fail == 3) {
					days = idx + 1;
					break;
				}
			}
		}
		if (days == -1) {
			days = n;
		}
		String answer = String.format("%.2f", (float) (income / days));
		System.out.println(answer);
		return answer;
	}
}
