package concurrency;

import java.util.concurrent.TimeUnit;

//need to stop the 2nd thread from the main thread using volatile keyword
public class VolatileExample {
    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
    	 new Thread(new Runnable() {
              public void run() {
                   while(!stop) { System.out.println("In while ..."); }
              }
          }).start();

          TimeUnit.SECONDS.sleep(1);
          stop = true;
        System.out.println("Stopped the variable");
    }
}
