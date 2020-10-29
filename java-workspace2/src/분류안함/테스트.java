package 분류안함;

public class 테스트 {
	static int cursor = 3;

	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("abcde");
		test(stringBuilder);
		System.out.println(stringBuilder);
	}

	private static void test(StringBuilder stringBuilder) {
		stringBuilder.delete(0, cursor);
		cursor = 0;
	}
}
