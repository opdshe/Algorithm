package 라인2020;

import java.util.ArrayList;
import java.util.List;

public class 오번 {
	public static void main(String[] args) {
		solution(new int[]{1, 4, 10, 6, 9, 1, 8, 13});
	}

	public static int solution(int[] cards) {
		int current = 0;
		int cardIdx = 0;
		while (cardIdx < cards.length) {
			List<Integer> player = new ArrayList<>();
			List<Integer> dealer = new ArrayList<>();
			int open;
			int hidden;
			try {
				player.add(getRealCard(cards[cardIdx++], player.stream().reduce(Integer::sum).orElse(0), 0));
				hidden = cards[cardIdx++];
				player.add(getRealCard(cards[cardIdx++], player.stream().reduce(Integer::sum).orElse(0), 0));
				open = cards[cardIdx++];
				//블랙잭
				if (player.stream().reduce(Integer::sum).orElse(0) == 21) {
					int dealerSum = open + hidden;
					if (dealerSum != 21) {
						current += 3;
					}
					continue;
				}
				//5전략
				if (open == 1 || open == 7) {
					while (player.stream().reduce(Integer::sum).orElse(0) < 17) {
						player.add(getRealCard(cards[cardIdx++], player.stream().reduce(Integer::sum).orElse(0)
								, 17));
					}
				} else if (open == 4 || open == 5 || open == 6) {

				} else if (open == 2 || open == 3) {
					while (player.stream().reduce(Integer::sum).orElse(0) < 12) {
						player.add(getRealCard(cards[cardIdx++], player.stream().reduce(Integer::sum).orElse(0)
								, 12));
					}
				}
				if (hidden + open + dealer.stream().reduce(Integer::sum).orElse(0) == 21) {
					current -= 2;
					continue;
				}
				//21넘으면 패배
				if (player.stream().reduce(Integer::sum).orElse(0) > 21) {
					current -= 2;
					continue;
				}
				while (open + hidden + dealer.stream().reduce(Integer::sum).orElse(0) < 17) {
					dealer.add(getRealCard(cards[cardIdx++], open + hidden + dealer.stream().reduce(Integer::sum).orElse(0), 17));
				}
				if (open + hidden + dealer.stream().reduce(Integer::sum).orElse(0) > 21) {
					current += 2;
					continue;
				}

				//결과 확인
				int dealerSum = open + hidden + dealer.stream().reduce(Integer::sum).orElse(0);
				int playerSum = player.stream().reduce(Integer::sum).orElse(0);
				if (Math.abs(21 - playerSum) < Math.abs(21 - dealerSum)) {
					current += 2;
				} else if (Math.abs(21 - playerSum) > Math.abs(21 - dealerSum)) {
					current -= 2;
				}
			} catch (Exception e) {
				System.out.println(current);
				return current;
			}
		}
		return current;
	}

	private static int getRealCard(int card, int current, int want) {
		if (card == 11 || card == 12 || card == 13) {
			return 10;
		} else if (card == 1) {
			if (current + 11 >= want) {
				return 11;
			} else {
				return 1;
			}
		}
		return card;
	}
}