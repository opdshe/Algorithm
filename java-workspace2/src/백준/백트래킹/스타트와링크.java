package 백준.백트래킹;

import java.util.Scanner;

public class 스타트와링크 {
	static int N;
	static int[][] skills;
	static boolean[] teams;
	static int answer;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		skills = new int[N][N];
		teams = new boolean[N];
		answer = 100 * N * N;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				skills[i][j] = scanner.nextInt();
			}
		}
		setTeams(0, 0);
		System.out.println(answer);
	}

	private static void setTeams(int from, int count) {
		if (count == N / 2) {
			int start = 0;
			int link = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (teams[i] && teams[j]) {
						start += skills[i][j];
						continue;
					}
					if (!teams[i] && !teams[j]) {
						link += skills[i][j];
					}
				}
			}
			answer = Math.min(answer, Math.abs(start - link));
			return;
		}
		for (int i = from; i < N; i++) {
			if (!teams[i]) {
				teams[i] = true;
				setTeams(i + 1, count + 1);
				teams[i] = false;
			}
		}
	}
}
