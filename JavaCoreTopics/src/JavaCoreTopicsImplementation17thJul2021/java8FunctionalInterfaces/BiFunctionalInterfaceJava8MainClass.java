package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
class Employee1 {
    int eno;
    String ename;

    public Employee1 ( int eno, String ename ) {
        this.eno = eno;
        this.ename = ename;
    }

    @Override
    public String toString () {
        return "Employee1{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                '}';
    }
}

public class BiFunctionalInterfaceJava8MainClass {

    public static void main ( String[] args ) {

        //BiPredicate takes 2 arguments
        BiPredicate< Integer, Integer > biPredicate = ( a, b ) -> {
            return (a + b) % 2 == 0;
        };

        //BiFunction take 2 arguments
        System.out.println(biPredicate.test(10, 20));
        BiFunction< Integer, String, Employee1 > biFunction = ( a, s ) -> {
            Employee1 employee1 = new Employee1(a, s);
            return employee1;

        };

        Employee1 emp = biFunction.apply(10, "Sidharth");

        System.out.println(emp);
    }
}
