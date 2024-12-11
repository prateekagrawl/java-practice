package concurrency;

public class Lec2JJ {
    public static void main(String[] args) throws InterruptedException {

        //JVM will stay alive until any thread is alive even after main thread execution is over
        //to stop this - we can set it as a daemon thread

        //A daemon thread in Java is a thread that does not keep the (JVM) running
        // if the main thread exits the application. A non-daemon thread will keep the
        // JVM running even if the main thread exits the application

        System.out.println("Original thread "+ Thread.currentThread());

//        Runnable runnable =  () -> {
//            while (true) {
//                System.out.println("Created thread "+ Thread.currentThread());
////                    Thread.sleep(1000);
//                System.out.println("Running");
//            }
//        };
        Runnable runnable =  () -> {
            for (int i=0; i<5; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        thread.join(); //Main thread waits for thread to finish
    }
}
