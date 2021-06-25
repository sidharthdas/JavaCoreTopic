package JUNE.practice1.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 25/06/21.
 */

interface Sayable{
    void say();
}

interface MessageI{
    Employee m1();
}

class Employee{
    public Employee(){
        System.out.println("in employee const");
    }
}
public class MethodReferenceImplementation {
    public static void main ( String[] args ) {

        Sayable sayable = MethodReferenceImplementation::hey;
        sayable.say();
        Sayable sayable1 =new MethodReferenceImplementation()::hey1;
        sayable1.say();
        MessageI messageI = Employee::new;
        messageI.m1();


        List<Integer> nums = Arrays.asList(1,4,2,3,0,6,9,7,8);

        List<Integer> nums1 = nums.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
        List<Integer> nums2 = nums.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println("nums1: "+nums1);
        System.out.println("nums2: "+nums2);

    }

    public static void hey(){
        System.out.println("static hey method");
    }

    public void hey1(){
        System.out.println(" hey1 method");
    }
}
