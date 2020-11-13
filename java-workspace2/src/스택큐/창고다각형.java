package 스택큐;

import java.util.Scanner;
import java.util.Stack;

public class 창고다각형 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[] heights = new int[1001];
		int maxHeight = -1;
		int left = -1;
		int right = -1;
		for (int poll = 0; poll < size; poll++) {
			int idx = scanner.nextInt();
			int height = scanner.nextInt();
			heights[idx] = height;
			maxHeight = Math.max(maxHeight, height);
		}
		for (int leftIdx = 1; leftIdx < 1000; leftIdx++) {
			if (heights[leftIdx] == maxHeight) {
				left = leftIdx;
				break;
			}
		}
		for (int rightIdx = 1000; rightIdx >= 1; rightIdx--) {
			if (heights[rightIdx] == maxHeight) {
				right = rightIdx;
				break;
			}
		}
		int leftArea = getLeftSideArea(heights, left);
		int rightArea = getRightSideArea(heights, right);
		int midArea = maxHeight * (right + 1 - left);
		int result = leftArea + rightArea + midArea;
		System.out.println(result);
	}

	private static int getLeftSideArea(int[] heights, int left) {
		int area = 0;
		Stack<Integer> stack = new Stack<>();
		for (int idx = 1; idx <= left; idx++) {
			if (heights[idx] == 0) {
				continue;
			}
			if (stack.isEmpty()) {
				stack.push(idx);
				continue;
			}
			int top = heights[stack.peek()];
			if (top < heights[idx]) {
				int width = idx - stack.pop();
				area += width * top;
				stack.push(idx);
			}
		}
		return area;
	}

	private static int getRightSideArea(int[] heights, int right) {
		Stack<Integer> stack = new Stack<>();
		int area = 0;
		for (int idx = 1000; idx >= right; idx--) {
			if (heights[idx] == 0) {
				continue;
			}
			if (stack.isEmpty()) {
				stack.push(idx);
				continue;
			}
			int top = heights[stack.peek()];
			if (top < heights[idx]) {
				int width = stack.pop() - idx;
				area += width * top;
				stack.push(idx);
			}
		}
		return area;
	}
}
