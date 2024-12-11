package medium;

public class DeadlockExample {

	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
	}

	private static class Thread1 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread1 acquired lock1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

				System.out.println("Thread-1 waiting for lock2");
				synchronized (lock2) {
					System.out.println("Thread1 - acquired lock2");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
				System.out.println("Thread1 releases lock2");
			}
			System.out.println("Thread1 releases lock1");
		}
	}

	private static class Thread2 extends Thread {
		public void run() {
			synchronized (lock2) {
				System.out.println("Thread2 acquired lock 2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
				System.out.println("Thread-2 waiting for lock 2");
				synchronized (lock1) {
					System.out.println("Thread2 acquired lock 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
				System.out.println("Thread2 releases lock1");
            }
			System.out.println("Thread2 released lock2");
		}
	}
}


