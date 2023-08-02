package threadingconcepts;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarriarMainClass {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new TestRunnable(cyclicBarrier));
        executorService.submit(new TestRunnable(cyclicBarrier));

        System.out.println("test");
    }

}

class TestRunnable implements Runnable {

    CyclicBarrier cyclicBarrier;

    public TestRunnable(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println("Running . . . ");
        while (true) {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test");
        }
    }
}
