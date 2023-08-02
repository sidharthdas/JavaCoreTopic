package threadingconcepts;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchMainClass {

    public static void main(String[] args) throws InterruptedException {

        //CountDown latch is saying, we will wait for all the threads to be executed, the we will run other codes
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        service.submit(new Service1Runnable(countDownLatch));
        service.submit(new Service2Runnable(countDownLatch));

        countDownLatch.await(); // this method will wait till the countDownLatch is 0, then it will execute rest code

        System.out.println("Hey main thread");

        service.shutdown();
    }
}

class Service1Runnable implements Runnable {

    CountDownLatch countDownLatch;

    public Service1Runnable(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    @Override
    public void run() {

        //once code is run
        System.out.println("Service1Runnable. . . ");
        countDownLatch.countDown();
        System.out.println("Service1Runnable. . . done");

    }
}

class Service2Runnable implements Runnable {

    CountDownLatch countDownLatch;

    public Service2Runnable(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    @Override
    public void run() {

        //once code is run
        System.out.println("Service2Runnable. . . ");
        countDownLatch.countDown();
        System.out.println("Service2Runnable. . . done");

    }
}
