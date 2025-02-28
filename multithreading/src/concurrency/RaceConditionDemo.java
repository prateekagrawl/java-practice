package concurrency;

public class RaceConditionDemo {
	
	public static void main(String[] args) {
	   BankAccount task = new BankAccount();
	   task.setBalance(100);
	   
	   Thread john = new Thread(task);
	   Thread anita = new Thread(task);	   
	   john.setName("John");
	   anita.setName("Anita");
	   anita.start();
	   john.start();
	}
}

class BankAccount implements Runnable {
	private int balance;
	public void setBalance(int balance) {
		this.balance = balance;		
	}
	
	public void run() {
		makeWithdrawal(75);
		if (balance < 0) {
			System.out.println("Money overdrawn by "+ Thread.currentThread().getName());
		}
	}	

	//lock here is on object on which method is invoked - since
	//invoked on Bank account , hence lock is on bankAccount obj
	private synchronized void makeWithdrawal(int amount) {
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw ...");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
	    } else {
	    	System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
	    }
	}
	
}