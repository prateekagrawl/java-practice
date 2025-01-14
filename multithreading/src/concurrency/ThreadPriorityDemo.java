package concurrency;

public class ThreadPriorityDemo {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread()); //gives reference to main thread
		
		Thread t1 = new Thread(new EmailCampaign());
		Thread t2 = new Thread(new DataAggregator());
		
		t1.setName("EmailCampaign");
		t2.setName("DataAggregator");

		//thread scheduler is asked to give higher priority to t1 - but its all upto scheduler
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		try {
			// main thread is suspended until t2 DIES - so only after t2 completes its execution -
			// fir wapas aayega main thread
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside main ... ");
	}
}

class EmailCampaign implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
			if (i == 5) {
				// Hint to scheduler that thread is willing to 
				// yield its current use of CPU
				Thread.currentThread().yield();
			}
        }		
	}
}

class DataAggregator implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
        }
	}
}
