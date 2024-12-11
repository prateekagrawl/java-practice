package medium;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        Runnable runnableTask = () -> {
            System.out.println("Thread name " + Thread.currentThread().getName());
        };

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Total cores" + coreCount);

        //create a thread pool
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        //submit the tasks for execution - the tasks are stored in blocking queue(which is thread safe)
        for (int i = 0; i < 10; i++) {
            service.execute(runnableTask);
        }
        System.out.println("thread name " + Thread.currentThread().getName());

    }
}
