package test;

import java.util.*;
import java.util.stream.Collectors;

class Student{
    private String city;

    public String getCity () {
        return city;
    }

    public void setCity ( String city ) {
        this.city = city;
    }
}

public class MainClass1 {

    public static void main ( String[] args ) {

        List<String> l1 = Arrays.asList("Om", "Sid", "Adi", "Om", "Ramesh", "Sid");
        MainClass1 mainClass1 = new MainClass1();
        System.out.println(mainClass1.removeDuplicate(l1));

    }

    //1. Write a method to remove a given value from array list having string values.
    public List<String> removeGivenValue ( List<String> list, String value ) {
        if(Objects.isNull(list)){
            throw new RuntimeException("List is Null");
        }

        if(list.contains(value)){
            list.remove(value);
        }
        return list;
    }

    //2. Write a method to return the maximum value from an integer array passed as an input parameter.

    public int largestInteger ( List< Integer > list ) {
        if(Objects.isNull(list)){
            throw new RuntimeException("list is null");
        }

        Collections.sort(list);

        return list.get(list.size()-1);

    }

    //3. Write a method to update the city attribute of Student object array list passed as an input parameter. If the city is "Mumbai" then change it to "Delhi". The method should return how many student records were updated.

    public int updatedStudentCity(List<Student> list){
        if(Objects.isNull(list)){
            throw new RuntimeException("list is null");
        }
        String oldCityName = "Mumbai";
        String newCityName = "Delhi";
        int size = list.size();
        int count = 0;
        for(int i = 0; i< size; i++){
            if (Objects.nonNull(list.get(i))) {

                if(Objects.nonNull(list.get(i).getCity())){
                    if(list.get(i).getCity().equals(oldCityName)){
                        list.get(i).setCity(newCityName);
                        count++;
                    }
                }
            }

        }

        return count;
    }

    //5. Write a method to remove duplicate values from an array list passed as an input parameter.

    public List<String> removeDuplicate(List<String> list){
        if(Objects.isNull(list)){
            throw new RuntimeException("list is null");
        }

        List<String> newList = list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        return newList;
    }
}
