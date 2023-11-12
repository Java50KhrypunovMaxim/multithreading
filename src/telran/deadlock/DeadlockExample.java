package telran.deadlock;

public class DeadlockExample {
	public static void main(String[] args) {
		final Object resourceOne = new Object();
		final Object resourceTwo = new Object();
		final int numThreads = 5;

		for (int i = 0; i < numThreads; i++) {
			Thread thread = new Thread(() -> {
				if (Math.random() < 0.5) {
					synchronized (resourceOne) {
						System.out.println(Thread.currentThread().getName() + ": locked resourceOne");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						synchronized (resourceTwo) {
							System.out.println(Thread.currentThread().getName() + ": locked resourceTwo");
						}
					}
				} else {
					synchronized (resourceTwo) {
						System.out.println(Thread.currentThread().getName() + ": locked resourceTwo");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						synchronized (resourceOne) {
							System.out.println(Thread.currentThread().getName() + ": locked resourceOne");
						}
					}
				}
			});
			thread.start();
		}
	}
}