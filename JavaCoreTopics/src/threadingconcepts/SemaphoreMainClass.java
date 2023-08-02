package threadingconcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreMainClass {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(2); // Only 2 threads can call api concurrently


    }
}


class Test2Runnable implements Runnable {

    private Semaphore semaphore;

    public Test2Runnable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            // Make api call
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
