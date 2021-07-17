package JavaCoreTopics17thJul.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sidharthdas on 23/06/21.
 */

class Student {

    private String studentName;

    public Student ( String studentName ) {
        this.studentName = studentName;
    }

    public String getStudentName () {
        return studentName;
    }

    public void setStudentName ( String studentName ) {
        this.studentName = studentName;
    }

    @Override
    public String toString () {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                '}';
    }
}

public class ComparatorMainClass {

    public static void main ( String[] args ) {

        List< Student > list = Arrays.asList(new Student("Sidharth"), new Student("Tripsy"), new Student("Sagar"), new Student("Sagarika"), new Student("Raju"));

        Comparator< Student > comparator = ( Student o1, Student o2)->{
          if(o1.getStudentName().length() > o2.getStudentName().length()){
              return 1;
          }else if(o1.getStudentName().length()< o2.getStudentName().length()){
              return -1;
          }
          else {
              return 0;
          }
        };

        Collections.sort(list, comparator);

        System.out.println(list);

    }
}
