package JavaCoreTopics17thJul.methodreference;

/**
 * @author sidharthdas on 23/06/21.
 */
@FunctionalInterface
interface Messagable{
    void message();
}


@FunctionalInterface
interface Emp{
    Employee message();
}

class Employee{

    public Employee(){
        System.out.println("In Employee Constructor");
    }

    public static void test(){
        System.out.println("In static test method of Employee class");
    }

    public  void test1(){
        System.out.println("In  test1 method of Employee class");
    }
}

public class MethodReferenceMainClass {

    public static void main ( String[] args ) {

        Messagable messagable =    Employee::test;
        messagable.message();

        Messagable messagable1 = new Employee()::test1;
        messagable1.message();

        Emp emp = Employee::new;
        emp.message();



    }
}
