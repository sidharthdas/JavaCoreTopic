package Oct4Th2022.leetcode;

import java.util.List;

record Student2(String studentName, String studentId, String studentAdd) {
    public Student2(String studentId, String studentAdd) {
        this(null, studentId, studentAdd);
    }

    public void show() {
        System.out.println(this.toString());
    }
}

public class StreamAPIMainClass {

    public static void main(String[] args) {
        List<Student2> student2List = List.of(new Student2("test1", "testId", "odisha"),
                new Student2("test2", "testId2", "odisha"),
                new Student2("test3", "testId3", "Kar"));

        if (student2List.stream().anyMatch(x -> x.studentAdd().equals("odisha"))) {
            System.out.println("ATLEAST ONE IS FROM ODISHA");
        }

        if (student2List.stream().noneMatch(x -> x.studentAdd().equals("mumbai"))) {
            System.out.println("NONE FROM MUMBAI");
        }

        if (student2List.stream().allMatch(x -> x.studentAdd().equals("odisha"))) {
            System.out.println("ALL FROM ODISHA");
        } else {
            System.out.println("ALL ARE NOT FROM ODISHA");
        }
    }
}
