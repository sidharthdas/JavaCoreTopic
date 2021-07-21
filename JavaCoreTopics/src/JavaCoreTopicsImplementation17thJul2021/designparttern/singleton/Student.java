package JavaCoreTopicsImplementation17thJul2021.designparttern.singleton;

/**
 * @author sidharthdas on 25/06/21.
 */
public class Student {

    private static Student instance;

    private Student(){

    }

    public static Student getInstance(){
        if(instance == null){

            synchronized (Student.class){
                if(instance == null){
                    instance = new Student();
                }
            }
        }

        return instance;
    }
}
