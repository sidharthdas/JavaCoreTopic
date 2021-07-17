package JavaCoreTopics17thJul.immutable;

import java.util.ArrayList;

/**
 * @author sidharthdas on 25/06/21.
 */
public class ImmutableImplementationMainClass {

    public static void main ( String[] args ) {
        Student student = new Student("Sidharth", new ArrayList<>());
        System.out.println(student.getStudName());
    }
}
