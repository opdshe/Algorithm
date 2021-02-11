package 분류안함;


public class 테스트 {
	static Account account = new Account();

	public static void main(String[] args) throws InterruptedException {
		Runnable task = new Task();
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		thread1.start();
		thread2.start();
		thread3.start();
		Thread.sleep(10);
		System.out.println(account.balance);
	}

	private static class Account {
		int balance = 100000;

		public void deposit(int amount) {
			balance += amount;
			System.out.println(balance + " " + Thread.currentThread());
		}
	}

	public static class Task implements Runnable {

		@Override
		public void run() {
			for (int idx = 0; idx < 10000; idx++) {
				account.deposit(1);
			}
		}
	}
}
