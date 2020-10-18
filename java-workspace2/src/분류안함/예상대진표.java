package 분류안함;

public class 예상대진표 {
	public static void main(String[] args) {
		solution(8, 4, 7);
	}

	public static int solution(int n, int a, int b) {
		int A = a - 1;
		int B = b - 1;
		int count = 0;
		while (A != B) {
			A = A / 2;
			B = B / 2;
			count++;
		}
		System.out.println(count);
		return count;
	}
}
