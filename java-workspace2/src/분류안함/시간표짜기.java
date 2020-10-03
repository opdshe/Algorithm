package 분류안함;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 시간표짜기 {
	static Scanner scanner = new Scanner(System.in);
	static List<Subject> subjects = new ArrayList<>();
	static List<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		int countOfSubject = scanner.nextInt();
		for (int subjectIdx = 0; subjectIdx < countOfSubject; subjectIdx++) {
			int countOfTime = scanner.nextInt();
			Subject subject = new Subject();
			for (int timeIdx = 0; timeIdx < countOfTime; timeIdx++) {
				subject.add(scanner.nextInt());
			}
			subjects.add(subject);
		}

		int countOfStudent = scanner.nextInt();
		for (int studentIdx = 0; studentIdx < countOfStudent; studentIdx++) {
			Student student = new Student();
			int countOfEmptyTime = scanner.nextInt();
			for (int emptyTimeIdx = 0; emptyTimeIdx < countOfEmptyTime; emptyTimeIdx++) {
				student.add(scanner.nextInt());
			}
			students.add(student);
		}

		for (Student student : students) {
			int availableSubject = 0;
			for (Subject subject : subjects) {
				boolean isOkay = true;
				for (int idx = 1; idx <= 50; idx++) {
					if (!student.emptyTimes[idx] && subject.times[idx]) {
						isOkay = false;
						break;
					}
				}
				if (isOkay) {
					availableSubject++;
				}
			}
			System.out.println(availableSubject);
		}
	}

	private static class Subject {
		private boolean[] times = new boolean[51];

		private void add(Integer time) {
			times[time] = true;
		}
	}

	private static class Student {
		private boolean[] emptyTimes = new boolean[51];

		private void add(Integer time) {
			emptyTimes[time] = true;
		}
	}
}
