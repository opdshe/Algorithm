package 기출.쿠팡;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이번 {
	public static void main(String[] args) {
		solution(3, new String[]{"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"});
	}

	public static int solution(int n, String[] customers) {
		List<Customer> customerList = new ArrayList<>();
		for (String customer : customers) {
			customerList.add(new Customer(customer.split(" ")));
		}
		List<Kiosk> kiosks = new ArrayList<>();
		for (int idx = 1; idx <= n; idx++) {
			kiosks.add(new Kiosk(idx, 0, 0));
		}
		search(customerList, kiosks);
		return 0;
	}

	private static void search(List<Customer> customerList, List<Kiosk> kiosks) {
		for (Customer customer : customerList) {
			//정렬
			kiosks.sort((Kiosk a, Kiosk b) -> {
				if (a.lastTime > b.lastTime) {
					return 1;
				} else if (a.lastTime == b.lastTime) {
					if (a.idx > b.idx) {
						return 1;
					}
				}
				return -1;
			});
			//가능한 키오스크 확인
			Kiosk findKiosk = null;
			for (Kiosk kiosk : kiosks) {
				if (kiosk.lastTime <= customer.arriveTime) {
					findKiosk = kiosk;
					break;
				}
			}

			if (findKiosk != null) {
				System.out.println(findKiosk.idx);
				findKiosk.lastTime = customer.arriveTime + customer.needTime;
				findKiosk.pass++;
			} else {
				System.out.println(kiosks.get(0).idx);
				Kiosk kiosk = kiosks.get(0);
				kiosk.lastTime += customer.needTime;
				kiosk.pass++;
			}
		}
		int answer = 0;
		for (Kiosk kiosk : kiosks) {
			answer = Math.max(answer, kiosk.pass);
		}
		System.out.println(answer);
	}

	private static int convertTime(String arriveTime) {
		String[] split = Arrays.stream(arriveTime.split(":"))
				.toArray(String[]::new);
		int time = 0;
		int[] times = new int[]{3600, 60, 1};
		for (int idx = 0; idx < 3; idx++) {
			time += (times[idx] * Integer.parseInt(split[idx]));
		}
		return time;
	}

	private static class Kiosk {
		private int idx;
		private int lastTime;
		private int pass;

		public Kiosk(int idx, int lastTime, int pass) {
			this.idx = idx;
			this.lastTime = lastTime;
			this.pass = pass;
		}
	}

	private static class Customer {
		private int date;
		private int arriveTime;
		private int needTime;

		public Customer(String[] info) {
			this.date = Integer.parseInt(info[0].replace("/", ""));
			this.arriveTime = convertTime(info[1]);
			this.needTime = Integer.parseInt(info[2]) * 60;
		}
	}
}
