package medium;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class VExample {
//    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
//        ThreadV obj = new ThreadV();
//        Thread threadV = new Thread(obj);
//        threadV.start();
//        Thread.sleep(2000);
//        obj.stop = false ;



    }
}
class ThreadV implements Runnable {
    public volatile boolean stop = true;
    @Override
    public void run() {
        while(stop) {
            System.out.println("Thread running");
        }
    }
}
