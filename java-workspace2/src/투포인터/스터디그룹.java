package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스터디그룹 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int countOfStudent = input[0];
		int countOfTotalAlgorithm = input[1];
		int maxLevelDiff = input[2];
		List<Student> students = new ArrayList<>();
		for (int s = 0; s < countOfStudent; s++) {
			int[] line = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			Student student = new Student(line[1]);
			for (int idx = 0; idx < line[0]; idx++) {
				int algorithm = Integer.parseInt(bufferedReader.readLine());
				student.add(algorithm);
			}
			students.add(student);
		}
		students.sort(Comparator.comparing(student -> student.level));
		solution(students, countOfStudent, countOfTotalAlgorithm, maxLevelDiff);
	}

	private static void solution(List<Student> students, int countOfStudent, int countOfTotalAlgorithm, int maxLevelDiff) {
		int leftIdx = 0;
		int rightIdx = 0;
		int answer = -1;
		long diff = 0;
		if (countOfStudent == 1) {
			System.out.println(getEfficiency(students, countOfTotalAlgorithm, 0, 1));
			return;
		}
		while (true) {
			System.out.println(diff);
			if (diff >= maxLevelDiff) {
				answer = Math.max(answer, getEfficiency(students, countOfTotalAlgorithm, leftIdx, rightIdx));
				diff -= students.get(leftIdx).level;
				leftIdx++;
			} else if (rightIdx == countOfStudent) {
				break;
			} else {
				diff += students.get(rightIdx).level;
				rightIdx++;
			}
		}
		System.out.println(answer);
	}

	private static int getEfficiency(List<Student> students, int countOfTotalAlgorithm, int left, int right) {
		int countOfStudent = right - left;
		Set<Integer> totalAlgorithms = new HashSet<>();
		int[] algorithms = new int[countOfTotalAlgorithm + 1];
		for (int idx = left; idx < right; idx++) {
			Student student = students.get(idx);
			for (Integer algorithm : student.getAlgorithms()) {
				totalAlgorithms.add(algorithm);
				algorithms[algorithm]++;
			}
		}
		int allKnowAlgorithm = 0;
		for (int idx = 1; idx <= countOfTotalAlgorithm; idx++) {
			if (algorithms[idx] == countOfStudent) {
				allKnowAlgorithm++;
			}
		}
		return (totalAlgorithms.size() - allKnowAlgorithm) * countOfStudent;
	}

	private static class Student {
		private int level;
		private List<Integer> algorithms = new ArrayList<>();

		public Student(int level) {
			this.level = level;
		}

		private void add(Integer algorithm) {
			this.algorithms.add(algorithm);
		}

		public List<Integer> getAlgorithms() {
			return algorithms;
		}
	}
}
