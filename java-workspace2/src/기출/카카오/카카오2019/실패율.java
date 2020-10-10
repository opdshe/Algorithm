package 기출.카카오.카카오2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 실패율 {
	static int[] arrivedMembers;
	static int[] onstageMembers;
	static List<Stage> stageList = new ArrayList<>();

	public static void main(String[] args) {
		solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
	}

	public static int[] solution(int N, int[] stages) {
		arrivedMembers = new int[N + 2];
		onstageMembers = new int[N + 2];
		Arrays.sort(stages);

		int countOfPeople = stages.length;
		for (int i = 0; i < countOfPeople; i++) {
			int stage = stages[i];
			onstageMembers[stage]++;
		}

		int arrivedMember = countOfPeople;
		for (int stage = 1; stage <= N; stage++) {
			arrivedMembers[stage] = arrivedMember;
			arrivedMember -= onstageMembers[stage];

			Stage currentStage = new Stage(stage, arrivedMembers[stage], onstageMembers[stage]);
			stageList.add(currentStage);
		}
		stageList.sort(new MyComparator());
		int[] answer = new int[N];
		for (int i = 0; i < stageList.size(); i++) {
			answer[i] = stageList.get(i).stage;
		}
		return answer;
	}

	private static class MyComparator implements Comparator<Stage> {


		@Override
		public int compare(Stage o1, Stage o2) {
			if (o1.getRateOfFailure() < o2.getRateOfFailure()) {
				return 1;
			} else if (o1.getRateOfFailure() == o2.getRateOfFailure()) {
				if (o1.stage > o2.stage) {
					return 1;
				}
			}
			return -1;
		}
	}

	private static class Stage {
		private int stage;
		private int arrivedMember;
		private int onStageMember;

		public Stage(int stage, int arrivedMember, int onStageMember) {
			this.stage = stage;
			this.arrivedMember = arrivedMember;
			this.onStageMember = onStageMember;
		}

		public double getRateOfFailure() {
			if (arrivedMember == 0) {
				return 0;
			}
			return (double) onStageMember / (double) arrivedMember;
		}
	}
}
