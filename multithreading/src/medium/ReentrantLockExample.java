package medium;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static ReentrantLock lock = new ReentrantLock();

    private static void accessResource() {
//        lock.lock(); can do this as well to acquire the lock

        boolean lockAcquired = lock.tryLock(); //tries to get the lock if its free
        if (lockAcquired) {
            try {
                //access the resource
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        } else {
            //do the alternate thing
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> accessResource());
        t1.start();

        Thread t2 = new Thread(() -> accessResource());
        t2.start();

        Thread t3 = new Thread(() -> accessResource());
        t3.start();

        Thread t4 = new Thread(() -> accessResource());
        t4.start();

    }
}
