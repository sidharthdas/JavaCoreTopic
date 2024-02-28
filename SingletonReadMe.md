# Singleton:

This can be broken using 3 different types of methods:
  1. Clonable
  2. Reflection API
  3. Serialization and Deserialization


-> Clonable: We have one class that implements clonable and we need to extend the singleton class as per business need in that case singleton will break.
To avoid that: We can override the clone method and throw an exception
```
public class EmployeeSingletonClass extends MyCloneClass {

    private static EmployeeSingletonClass employeeSingletonClass;

    private EmployeeSingletonClass() {
    }

    public static EmployeeSingletonClass getInstance() {
        if (employeeSingletonClass == null) {
            employeeSingletonClass = new EmployeeSingletonClass();
        }

        return employeeSingletonClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /*protected Object readResolveMethod() {

    }*/
}

```

-> Reflection API: Using reflection API we can call the declared constructors and using them for creating objects.
Reflection API example:
```
        EmployeeSingletonClass E1 = EmployeeSingletonClass.getInstance();

        EmployeeSingletonClass e2 = null;

        Constructor<?>[] constructors =  EmployeeSingletonClass.class.getDeclaredConstructors();

        for(Constructor<?> c : constructors) {
            c.setAccessible(true);
            e2 = (EmployeeSingletonClass) c.newInstance();
        }
        System.out.println( E1);
        System.out.println(e2);
```

To Avoid that we can check if the instance is created or not, and if the instance is there throw an exception in the constructor:
```
public class EmployeeSingletonClass extends MyCloneClass {

    private static EmployeeSingletonClass employeeSingletonClass;

    private EmployeeSingletonClass() {
        if (employeeSingletonClass != null) {
            throw new IllegalStateException("Object already created");
        }
    }

    public static EmployeeSingletonClass getInstance() {
        if (employeeSingletonClass == null) {
            employeeSingletonClass = new EmployeeSingletonClass();
        }

        return employeeSingletonClass;
    }
}
```

-> Using Serialization and De-Serialization:
Using the below code we can create new object.
```
        // Serialization
        EmployeeSingletonClass e1 = EmployeeSingletonClass.getInstance();
        System.out.println(e1.hashCode());

        //serialize :
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        objectOutput.writeObject(e1);

        //Deserialize:
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("singleton.ser"));
        EmployeeSingletonClass e2 = (EmployeeSingletonClass) objectInput.readObject();

        System.out.println(e1);
        System.out.println(e2);
```
To avoid that, we need to understand how de-serialization works.
At the time of de-serialization, it checks if there is readResolve method present or not if it's present it invokes that method.
Instead of deserializing it, we can return the same instance in the readReolve() method.

```
//Need to be added in singleton class
protected Object readResolveMethod() {
    }
```

Example:

```
import java.io.Serializable;

public class EmployeeSingletonClass implements Serializable {

    private static EmployeeSingletonClass employeeSingletonClass;

    private EmployeeSingletonClass() {
    }

    public static EmployeeSingletonClass getInstance() {
        if (employeeSingletonClass == null) {
            employeeSingletonClass = new EmployeeSingletonClass();
        }
        return employeeSingletonClass;
    }
    protected Object readResolveMethod() {
        return employeeSingletonClass
    }
}

```


# Example of Fully secured Singleton Class:

```
import java.io.Serializable;

public class EmployeeSingletonClass extends MyCloneClass implements Serializable {

    private static EmployeeSingletonClass employeeSingletonClass;

    // To fight with Reflection API
    private EmployeeSingletonClass() {
        if (employeeSingletonClass != null) {
            throw new IllegalStateException("Object already created");
        }
    }

    //Thread safe with double checks.
    public static EmployeeSingletonClass getInstance() {
        if (employeeSingletonClass == null) {
            synchronized (EmployeeSingletonClass.class) {
                if (employeeSingletonClass == null) {
                    employeeSingletonClass = new EmployeeSingletonClass();
                }
            }
        }
        return employeeSingletonClass;
    }

    //To fight with Cloneable
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    //To fight with Serializable/ De-Serializable
    protected Object readResolveMethod() {
        return employeeSingletonClass;
    }
}

```
