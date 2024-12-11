package medium;

public class MyFirstThread {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task(); //create a task
        Thread thread = new Thread(task); //create a thread
        thread.setDaemon(true);
        thread.start(); //RUNNABLE state of thread

//        Thread.sleep(3000); //current thread - main thread has to sleep for 3sec.



//        Thread thread1 = new Thread("new thread") {
//          public void run() {
//              System.out.println(" run by" + thread.getName());
//          }
//        };
//        thread1.start();
//        System.out.printf(thread1.getName());

//        TimeUnit.SECONDS.sleep(1);
        System.out.println("Inside main..");
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Inside run()...");
        go();
    }

    private void go() {
        System.out.println("Inside go...");
        more();
    }

    private void more() {
        System.out.println("Inside more..");
    }
}