package Oct4Th2022.leetcode;

public record Student(int studentId, String studentName) {
    //Custom constructor
    public Student(String studentName) {
        this(1, studentName);
    }

    //For validation you can use this
    public Student {
        if (studentName().length() < 1) {
            throw new IllegalArgumentException("Student name cant be of size 0");
        }
    }

    //Add method also
    public String beautify() {
        return "Name is " + studentName + " and id is " + studentId;
    }

    //Add random methods as well
    public void add(int x, int y) {
        System.out.println(x + y);
    }


}
