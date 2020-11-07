package 기출.우테코2020;

public class 삼번 {
	public static void main(String[] args) {
		solution(180, new String[]{"H", "H"}, new String[]{"T", "T"});
	}

	public static int solution(int money, String[] expected, String[] actual) {
		int battingMoney = 100;
		for (int round = 0; round < expected.length; round++) {
			//System.out.println(battingMoney);
			//승
			if (expected[round].equals(actual[round])) {
				money += battingMoney;
				battingMoney = 100;
			} else {
				money -= battingMoney;
				if (battingMoney * 2 <= money) {
					battingMoney *= 2;
				} else {
					battingMoney = money;
				}
			}
			if (money == 0) {
				break;
			}
		}
		System.out.println(money);
		return money;
	}
}
