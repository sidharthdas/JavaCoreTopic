package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author sidharthdas on 19/07/21.
 */

class Student{

    String name;
    int mark;

    public Student(String name, int mark){
        this.name = name;
        this.mark = mark;
    }
}
public class FunctionJava8MainClass {

    public static void main ( String[] args ) {
        //Find square of int
        Function<Integer, Integer> function = (i-> i*i);
        System.out.println(function.apply(4));

        // Take string and find length of String
        Function<String, Integer> fun = (x) -> x.length();
        System.out.println(fun.apply("Sidharth"));

        // Method that take any condition to modify the value
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        squareOfNumbers(list, x->x *x);

        Function<Student, String> function2 = (x) ->{
            if(x.mark >= 80){
                return "A";
            }else if(x.mark>=60 && x.mark< 80){
                return "B";
            }else if(x.mark>=50 && x.mark< 60){
                return "C";
            }else if(x.mark>=35 && x.mark< 50){
                return "D";
            }else{
                return "F";
            }
        };
        System.out.println("_________________");
        List<Student> listOfstudent = Arrays.asList(new Student("Sidharth", 80),new Student("Raj", 50),new Student("Aryan", 77) );
        checkStudent(listOfstudent, function2);

    }

    public static void squareOfNumbers( List<Integer> list, Function<Integer, Integer> function ){
        for(int i : list){
            System.out.println(function.apply(i));
        }
    }


    public static void checkStudent( List<Student> list, Function<Student, String> function ){
        for(Student i : list){
            System.out.println(function.apply(i));
        }
    }





}
