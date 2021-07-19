package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * @author sidharthdas on 19/07/21.
 */
public class SupplierJava8MainClass {

    public static void main ( String[] args ) {

        Supplier< LocalDateTime > supplier = () -> {
            return LocalDateTime.now();
        };

        System.out.println(supplier.get());


        //Supply random otp
        Supplier<Double> supplier1 = ()->{
          return Math.random() *100;
        };

        System.out.println(supplier1.get());
    }
}
