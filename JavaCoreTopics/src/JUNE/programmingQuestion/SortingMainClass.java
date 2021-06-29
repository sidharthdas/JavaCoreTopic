package JUNE.programmingQuestion;

import java.util.*;

/**
 * @author sidharthdas on 29/06/21.
 */

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student ( int id, String fname, double cgpa ) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId () {
        return id;
    }

    public String getFname () {
        return fname;
    }

    public double getCgpa () {
        return cgpa;
    }

    @Override
    public String toString () {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}

public class SortingMainClass {

    public static void main ( String[] args ) {

       /* 33 Rumpa 3.68
        85 Ashis 3.85
        56 Samiha 3.75
        19 Samara 3.75
        22 Fahim 3.76*/
        List< Student > list = Arrays.asList(new Student(33, "Rumpa", 3.68), new Student(85, "Ashis", 3.85), new Student(56, "Samiha", 3.75), new Student(19, "Samara", 3.75), new Student(22, "Fahim", 3.76));


        Comparator<Student> comparator = (Student o1, Student o2)->{

            if(o1.getCgpa() > o2.getCgpa()){
                return -1;
            }else if(o1.getCgpa() < o2.getCgpa()){
                return 1;
            }else{
                if(o1.getFname().compareTo(o2.getFname())> 0){
                    return 1;
                }else if(o1.getFname().compareTo(o2.getFname()) < 0){return -1;

                }else{

                    if(o1.getId() >o2.getId()){
                        return 1;
                    }else if(o1.getId() < o2.getId()){
                        return -1;
                    }else{
                        return 0;
                    }


                }

            }
        };



        Collections.sort(list, comparator);

        list.forEach(x->{

            System.out.println(x.getFname());
        });





    }
}
