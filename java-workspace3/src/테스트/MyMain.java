package 테스트;

public class MyMain {
	public static void main(String[] args) {
		balk(new Dog());
	}

	private static void balk(Animal animal) {
		animal.balk();
	}

	private static class Dog extends Animal {

		@Override
		public void balk() {
			System.out.println("wall!!");
		}
	}
}
