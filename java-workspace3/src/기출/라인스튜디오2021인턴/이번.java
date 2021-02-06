package 기출.라인스튜디오2021인턴;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class 이번 {
	static List<Point> points = new ArrayList<>();

	public static void main(String[] args) {
		solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
	}

	public static String[] solution(int[][] line) {
		String[] answer = {};
		for (int pivot = 0; pivot < line.length; pivot++) {
			int[] pivotLine = line[pivot];
			for (int compare = 0; compare < line.length; compare++) {
				if (compare == pivot) {
					continue;
				}
				int[] compareLine = line[compare];
				double px;
				double py;
				if (pivotLine[0] == 0) {
					py = -(double) (pivotLine[2] / pivotLine[1]);
					px = (-(double) compareLine[1] * py - (double) compareLine[2]) / (double) compareLine[0];
				} else if (compareLine[0] == 0) {
					py = -(double) (compareLine[2] / compareLine[1]);
					px = (-(double) pivotLine[1] * py - (double) pivotLine[2]) / (double) pivotLine[0];
				} else if (pivotLine[1] == 0) {
					px = -(double) (pivotLine[2] / pivotLine[0]);
					py = (-(double) compareLine[0] * px - (double) compareLine[2]) / (double) compareLine[1];
				} else if (compareLine[1] == 0) {
					px = -(double) (compareLine[2] / compareLine[0]);
					py = (-(double) pivotLine[0] * px - (double) pivotLine[2]) / (double) pivotLine[1];
				} else {
					px = ((double) pivotLine[1] * (double) compareLine[2] - (double) compareLine[1] * (double) pivotLine[2]) /
							((double) pivotLine[0] * (double) compareLine[1] - (double) compareLine[0] * (double) pivotLine[1]);
					py = (-(double) pivotLine[0] / (double) pivotLine[1] * px) - ((double) pivotLine[2] / (double) pivotLine[1]);
				}
				if (py / 1.00 == (int) py && px / 1.00 == (int) px) {
					Point point = new Point((int) px, (int) py);
					if (!points.contains(point)) {
						points.add(point);
					}
				}
			}
		}

		points.sort(Comparator.comparing(point -> point.x));
		Point left = points.get(0);
		Point right = points.get(points.size() - 1);
		points.sort(Comparator.comparing(point -> point.y));
		Point bottom = points.get(0);
		Point top = points.get(points.size() - 1);

		List<String> answers = new ArrayList<>();
		for (int row = top.y; row >= bottom.y; row--) {
			StringBuilder sb = new StringBuilder();
			for (int column = left.x; column <= right.x; column++) {
				Point point = new Point(column, row);
				if (points.contains(point)) {
					sb.append("*");
				} else {
					sb.append(".");
				}
			}
			answers.add(sb.toString());
		}
		return answers.toArray(String[]::new);
	}

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return x == point.x &&
					y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public String toString() {
			return "Point{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
