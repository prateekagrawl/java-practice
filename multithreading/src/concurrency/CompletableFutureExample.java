package concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //submit the task & accept placeholder object for value to be returned from task
        Future<Integer> future = service.submit(new Task1());

        //CF performs all the tasks asynchronously
//        for(int i=0; i<100; i++) {

//            CompletableFuture.supplyAsync(() -> getOrder(), )
//                    .thenApply(order -> enrichOrder(order))
////                    .thenApply()
//
//        );
//        }

        try {
            Integer res = future.get(); //blocking method
            System.out.println("Result from the task is "+ res);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}