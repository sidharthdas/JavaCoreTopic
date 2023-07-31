package volatileandatomicnumber;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAndAtomicNumber {

    volatile boolean flag = true; // if the flag is changed by any of the thread, then the shared cache we have for all the thread
    // there also the flag value will replace coz of volatile keyword

    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger(1);
        //Even if a thread increment the at variable the current incremented value will be display to other thread.
    }
}
