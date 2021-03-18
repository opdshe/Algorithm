package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 강의실배정 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCourse = scanner.nextInt();
		Queue<Course> courses = new PriorityQueue<>(Comparator.comparing(Course::getStart)
				.thenComparing(Course::getEnd));
		Queue<Room> rooms = new PriorityQueue<>(Comparator.comparing(Room::getEnd));
		for (int i = 0; i < countOfCourse; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			courses.add(new Course(start, end));
		}

		while (!courses.isEmpty()) {
			Course course = courses.poll();
			if (rooms.isEmpty()) {
				Room room = new Room();
				room.assign(course);
				rooms.add(room);
				continue;
			}

			if (rooms.peek().end <= course.start) {
				Room room = rooms.poll();
				room.assign(course);
				rooms.add(room);
			} else {
				Room newRoom = new Room();
				newRoom.assign(course);
				rooms.add(newRoom);
			}
		}
		System.out.println(rooms.size());
	}

	private static class Room {
		int end;

		public void assign(Course course) {
			end = course.end;
		}

		public int getEnd() {
			return end;
		}
	}

	private static class Course {
		int start;
		int end;

		public Course(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
	}
}
