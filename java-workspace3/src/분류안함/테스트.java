package 분류안함;

public class 테스트 {
	public static void main(String[] args) {
		StringBuilder a = new StringBuilder("hello");
		StringBuilder b = a;
		b.append("aaa");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
}
