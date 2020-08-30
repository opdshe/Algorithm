package 백준.시뮬레이션;

import java.util.*;

public class 후보추천하기 {
	static int countOfPictures;
	static List<Integer> addedStudent = new ArrayList<>();
	static List<Picture> pictures = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		countOfPictures = scanner.nextInt();
		int countOfSuggestions = scanner.nextInt();
		int time = 1;
		for (int i = 0; i < countOfSuggestions; i++) {
			int studentNumber = scanner.nextInt();
			if (!addedStudent.contains(studentNumber)) {
				if (addedStudent.size() >= countOfPictures) {
					pictures.sort(new myComparator());
					Picture target = pictures.remove(0);
					addedStudent.remove(new Integer(target.studentNumber));
				}
				addedStudent.add(studentNumber);
				pictures.add(new Picture(studentNumber, 1, time));
			} else {
				for (Picture picture : pictures) {
					if (picture.studentNumber == studentNumber) {
						picture.addScore();
					}
				}
			}
			time++;
		}

		Collections.sort(pictures, Comparator.comparing((Picture a) -> a.studentNumber));
		for (Picture picture : pictures) {
			System.out.print(picture.studentNumber + " ");
		}
	}


	private static class myComparator implements Comparator<Picture> {
		@Override
		public int compare(Picture o1, Picture o2) {
			if (o1.score > o2.score) {
				return 1;
			} else if (o1.score == o2.score) {
				if (o1.time > o2.time) {
					return 1;
				}
			}
			return -1;
		}
	}

	private static class Picture {
		private int studentNumber;
		private int score;
		private int time;

		public Picture(int studentNumber, int score, int time) {
			this.studentNumber = studentNumber;
			this.score = score;
			this.time = time;
		}

		private void addScore() {
			this.score++;
		}
	}
}
