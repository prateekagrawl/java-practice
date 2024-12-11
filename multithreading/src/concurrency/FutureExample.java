package concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //submit the task & accept placeholder object for value to be returned from task
        Future<Integer> future = service.submit(new Task());

        try {
            Integer res = future.get(); //blocking method
            System.out.println("Result from the task is "+ res);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}