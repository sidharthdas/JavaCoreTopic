package JUNE.ProgramToCallAMethodInEvery10Sec;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author sidharthdas on 02/07/21.
 */
public class ProgramToCallAMethodInEvery10SecMainClass {


    public static void main ( String[] args ) {
        int count = 0;
        Runnable helloRunnable = ()-> {
                System.out.println("Hello world");
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);
    }
}
