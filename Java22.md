# JAVA 22 Features


## Using un-named variables:

```
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cat _ = new Cat();
    }
}

But we can't use any attribute help to send it to other class
```

## String Template:

```
Instead of concatenating, we can use the String template:

public class Main {
    public static void main(String[] args) {
        String name = "Sidharth";
        String s = STR."hi my name is \{name}";
        
    }
    
}

```
