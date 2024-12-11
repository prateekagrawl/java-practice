package medium;

public class DaemonThreadExample {
    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread();
        t1.setName("t1");
        t1.setDaemon(true);

        DaemonThread t2 = new DaemonThread();
        t2.setName("t2");
        DaemonThread t3 = new DaemonThread();
        t3.setName("t3");

        // Setting user thread t1 to Daemon
        // starting first 2 threads
        t1.start();
        t2.start();
        // Setting user thread t3 to Daemon
//        one can only call the setDaemon() method before start() method otherwise
//        it will definitely throw IllegalThreadStateException
        t3.setDaemon(true);
        t3.start();
    }
}

class DaemonThread extends Thread {
    public void run() {
        // Checking whether the thread is Daemon or not
        if (Thread.currentThread().isDaemon()) {
            System.out.println(getName() + " is Daemon thread");
        } else {
            System.out.println(getName() + " is User thread");
        }
    }
}
