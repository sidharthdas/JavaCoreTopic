# JavaCoreTopic

## -> To check the memory consumption of the application, 
``` java -> jdk17 -> bin -> jconsole.exe```
Or you can download ``` the JDK Mission Control Application ```

## -> ClassNotFoundException and NoClassDefFoundError:


```
ClassNotFoundException:  ClassNotFoundException is thrown when looking up a class that isn't on the classpath or using an invalid name to look up a class that isn't on the runtime classpath.
NoClassDefFoundError: NoClassDefFoundError occurs when a compiled class references another class that isn't on the runtime classpath.
```
## -> String creation using the new keyword:
```
When we create a string object using the new keyword in Java, two objects are created in memory. One object is created in the heap memory, and the other object is created in the string pool.
The heap memory is a region of memory that is used to store objects. When we create a new object, it is allocated a space in the heap memory. The string pool is a region of memory that is used to store string objects.
When we create a new string object, it is added to the string pool.
The string pool is used to store string objects that are used frequently. This is because it is more efficient to store a string object in the string pool than it is to store it in the heap memory. When we create a new string object, the Java Virtual Machine (JVM) checks to see if the string object already exists in the string pool. If the string object already exists in the string pool, the JVM returns a reference to the existing string object. If the string object does not exist in the string pool, the JVM creates a new string object and adds it to the string pool.
```

## Rev String:
```
String str = "Sidharth";
        
        String revStr = str
                .chars()
                .mapToObj(x -> String.valueOf((char)x))
                .reduce((s1, s2) -> s2 + s1)
                .orElse("");
```

## -> Kadane Algorithm:

Maximum sum of sub-array:
Notes:
```
Initially keep sum = 0 and maxi = arr[0] (this is coz the sub-array can be at least one element)
then, for all elements of the array, follow 3 steps:
Step 1. sum = sum + arr[i];
Step 2. maxi = maximumOf(maxi, sum)
Step 3. if(sum < 0) sum = 0
Then, return maxi
```
Kadane Code:
```
public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0, maxi = nums[0];

        for(int i = 0; i < len; i++){
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }
```

## -> Sort 2D array using Arrays.sort()
```
 Arrays.sort(score, (score1, score2) -> score2[k] - score1[k]);
```

## -> Overriding:
 - Cant change the access modifier it should be the same.
   ```
   public interface C {
    void c () throws Exception;}

   public class A implements C {

    @Override
    public  void c() {
        System.out.println("Sid");
    }

    public static void main(String[] args) {
        C c = new A();
        c.c(); // It will throw a compile time exception coz we are doing C c = new A() and we are not throwing the exception

        A a = new A();
        a.c(); // It will not coz we are creating the object of A and the c method doesn't throw an exception
    }


   
   ```
## -> Sealed class in Java 17:

If we want only some classes that can extend the base class, we can use a sealed class. And the classes that are extending sealed class must be final
```
public sealed class A permits B, C {
```


## -> Stream API nested null check:
```
Optional.ofNullable(model1)
        .map(MainModel::getStudentList)
        .map(studentList -> studentList.stream().findFirst())
        .flatMap(student -> student.stream().findFirst())
        .ifPresent(z -> s.setName(z.getName()));
```
## -> PriorityQueue Implementation
```
PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1); 
//Here, in the argument, we need to pass the Comparator (Added lambda exp for sorting)
```
## -> Sort the list of String by the length in reverse order and then if lengths are equal then sort by the natural order
```
			map.entrySet()
                        .stream()
                        .filter(x -> x.getValue() == finalLowDeletion)
                        .map(x -> x.getKey()) // converting map to list
                        .sorted(Comparator
                                .comparingInt(String::length)
                                .reversed()
                                .thenComparing(Comparator.naturalOrder()))
                        .findFirst()
                        .get()
        );
```

## -> For Java core topics, refer to package JavaCoreTopicsImplementation17thJul2021

## -> For BST please follow this package src/binarysearchtree20Feb2023

    Insert a node
    Remove a node
    Check Node is Present
    inOrder
    preOrder
    postOrder
    Print left side of node
    Print right side of node
    Descending order
    Height of BST
    Mirror image of BST

## -> For java8 functional interface, refer JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces. 

-> For logging in Java Stream, use `peek() after stream()`
## -> 2 main methods of stream() i.e.
```
stream().takeWhile(Predicate p) // -> It will loop over the array, and pull the data unless the condition matches, once it gets matched, it will stop
stream().dropWile(Predicate p) // -> It will loop over the array and drop the elements will the condition matches, once it gets matched, it will stop dropping the elements

```

## -> Map, group by address then find the one with max salary for a particular address:
```
public static void main(String[] args) {

        List<EmpSid> list = List.of(
                new EmpSid(1, "Sidharth", "Odisha", 100),
                new EmpSid(2, "Ram", "Mumbai", 200),
                new EmpSid(3, "Shyam", "Odisha", 400),
                new EmpSid(4, "Ramesh", "Mumbai", 300)

        );

        Map<String, List<EmpSid>> map = list.stream()
                .collect(Collectors.groupingBy(EmpSid::empAddress));


        Map<String, EmpSid> map2 = list.stream()
                .collect(Collectors.groupingBy(EmpSid::empAddress))
                .entrySet()
                .stream()
                .map(x -> {
                    EmpSid e = x.getValue().stream().min((emp1, emp2) -> emp2.salary() - emp1.salary()).orElse(null);

                    assert e != null;
                    return Map.entry(x.getKey(), e);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));


        System.out.println(map2);
    }
```
## -> Map to process the key and value if it is present we can use computeIfPresent method

-> Map 
```
map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> newVal, LinkedHashMap::new));

```
```
counter.computeIfPresent(key, (k, v) -> {
            v += 1;
            keys.remove(key);
            keys.add(key);
            return k;
        });

```
## -> Convert Map<Integer, Integer> to Map<Integer, List<Integer>> based on value:

```
Map<Integer, List<Integer>> temp = map.entrySet().stream()
.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
```
## -> Map to process the key if it is not present in the map:
```
// provide value for new key which is absent
        // using computeIfAbsent method
        map.computeIfAbsent("key5", k -> 2000 + 33000);
        map.computeIfAbsent("key6", k -> 2000 * 34);
 ```

## -> We have a Iterable and we need to convert it to List using java 11
```
Iterable<Employee> employeeIterable = Arrays.asList(new Employee(), new Employee());
        List<Employee> empList = StreamSupport.stream(employeeIterable.spliterator(), false) // false is not to have parallel execution
                .toList();
```
## -> Map java8 functionalities, refer spet2022.MapPractice
```
Map<String, Employee> mapEmpl = empList.stream().collect(Collectors.groupingBy(x -> x.dept.deptCode, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(x -> x.empSalary)),
                Optional::get)));
```

## -> Sort map by value and if values are equal then sort by key
```
map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
```
## -> Flatten the List using flatMap method:
```
l.stream().filter(x -> x.size() == 4)
                .flatMap(List::stream).reduce(Integer::sum).get();
```

## -> MultiMap method of Stream: https://www.youtube.com/watch?v=SqmO0NM0J98

```
public static void main(String[] args) {

        List<String> l = Arrays.asList("1", "2", "3", " ", "5");

        //Here using flatMap we can avoid that problem, but we are creating stream of nums
        List<Integer> lInt = l.stream()
                .flatMap(string -> {
                    try {
                        ;
                        return Stream.of(Integer.parseInt(string));

                    } catch (NumberFormatException nfe) {
                        return Stream.empty();
                    }
                }).collect(Collectors.toList());

        //Here using mapMulti we can avoid creating new Streams.
        List<Integer> ll = l.stream()
                //mapMulti take biConsumer, so we are sending string and consumer
                .<Integer>mapMulti((string, consumer) -> {
                    try {
                        consumer.accept(Integer.parseInt(string));
                    } catch (Exception ee) {
                    }
                }).collect(Collectors.toList());
    }
```
 
 
## Indexes:
-> For Callable, Future Object and ExecutorService Implementation, please refer JUNE.callableImplementation

-> For Singleton, please refer JUNE.practice1.singleton

-> For String custom sorting, refer package JavaCoreTopicsImplementation17thJul2021.stringCustomSorting; classNAME: StringCustomSortingMainClass

To sort a map with respect to its value using Stream API.

Sort the map with value and if the value is the same sort by alpha order:

```
map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2 ) -> e1, LinkedHashMap::new));

```

## -> Find the highest occurrence String from the list:

```
Optional<Map.Entry<String, Long>> l  = items.stream().
				collect(Collectors.groupingBy(O -> O, Collectors. counting()))
				.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparing(p-> p.getValue()))).findFirst();
```

## -> Generics:
1. Upper bound generics: Any class extends by an Object, this can access
```
List<? extends Object>
```
2. Lower bound generics: All the super classes of the class can be accessed. i.e. all the superclass of animals can be access
```
List<? super Aminal>
```
Example of upper and lower bound:
```
    public static void main(String[] args) {
        Employee emp = new Employee("", "");

        List<Employee> list = new ArrayList<>();
        list.add(emp);

        test(list);

        MainEmployee mainEmployee = new MainEmployee("", "");
        List<MainEmployee> mainEmployees = new ArrayList<>();
        mainEmployees.add(mainEmployee);
        test1(mainEmployees);

    }
//Upper
    public static void test(List<? extends MainEmployee> list) {
        System.out.println(list);
    }
//lower
    public static void test1(List<? super Employee> list) {
        System.out.println(list);
    }
```

```
final Map< String, Integer > sortedByCount = map.entrySet()
        .stream()
        .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));
```

## Java 1.8 Stream Feature:

```//Flat map impl
		List<List<List<Integer>>>
				list = Arrays.asList (Arrays.asList (Arrays.asList (5,5,6) ),
				Arrays.asList (Arrays.asList (1,2,3) ) );

		System. out .println (list.stream() .flatMap(Collection::stream) .flatMap(Collection::stream) .collect (Collectors.toList ()));
		List<Integer> l= Arrays.asList (1,2,3,34, 5454, 54) ;
		l.add (10);
		int[] arr = {1,2,3,4,5, 6};
		int op = Arrays.stream (arr) . filter (x->x > 3) . reduce (0, (a,b)-> a+b);
		int opl = Arrays.stream (arr).filter (x ->  x > 3).reduce (0, Integer::sum) ;
		Map<Object, Long>  occurrences = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(s ->s , Collectors.counting()));
		System.out.println (occurrences);

//Convert list to Map and filter whose value is one
		List<String> items  = Arrays.asList("apple ", "apple", "banana", "banana", "papaya");
		Map<String, Long> result  = items.stream().
				collect(Collectors.groupingBy(Function.identity(), Collectors. counting()))
				.entrySet().stream().filter(x -> x.getValue() ==1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out .println(result);
```


## BST - Delete Node : 

```
public Node delete ( Node root, int data ) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minVal(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private int minVal ( Node root ) {
        int minV = root.data;
        while (root.left != null) {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }
```
## Reverse a LinkedList:

```
public void reverse() {
        if (root == null) {
            return;
        }

        Node prev = null;
        Node curr = root;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        root = prev;
    }
```

## Delete Middle Element Of LinkedList:

```
public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode n = head;
        ListNode node = head;

        while (node != null) {
            count++;
            node = node.next;
        }

        int middleIndex = count / 2;
        while (middleIndex-- > 1) {
            head = head.next;
        }
        head.next = head.next.next;
        return n;
    }
```


# Java17 Best Feature

## Record:

it is used to transfer the data and access the data, no need to create DTO/POJO classes

```
record Alien(String alienId, String alienName) {

    //This has a capalibity that it automatically implemented equals and hascode
    //It doesnt have setter, as it is just use to send and access the data
    public Alien(String alienId) { //constructor with one argument
        this(alienId, null);
    }
}

public class Test {
    public static void main(String[] args) {

        Alien a1 = new Alien("1", "Sid");
        Alien a2 = new Alien("2");
        System.out.println(a1);
        System.out.println(a2);
	}

}
```

## CompletableFuture Example

Please refer package: JavaCoreTopics/src/completablefuture

```
package completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureMainClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Validator> validatorList = List.of(new Validator(), new Validator(), new Validator());

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        List<CompletableFuture<Boolean>> completableFutureList = new ArrayList<>();
        for (Validator v : validatorList) {
            completableFutureList.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return v.validate();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, executorService));
        }

        CompletableFuture<Void> completableFutureVoid =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        List<Boolean> b = completableFutureVoid.thenApply(x ->
                completableFutureList.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        ).get();

        System.out.println(b);
    }

}

class Validator {

    public boolean validate() throws InterruptedException {
        //For Testing
        Thread.sleep(3000);
        return true;
    }
}

```

## Volatile and AtominInteger
Please refer package: src/volatileandatomicnumber/VolatileAndAtomicNumber.java

```
public class VolatileAndAtomicNumber {

    volatile boolean flag = true; // if the flag is changed by any of the thread, then the shared cache we have for all the thread 
    // there also the flag value will replace coz of volatile keyword

    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger(1);
        //Even if a thread increment the at variable the current incremented value will be display to other thread.
    }
}
```
## Threading CountDownLatch, CyclicBarriar and Semaphore
Please refer package: JavaCoreTopics/src/threadingconcepts/CountDownLatchMainClass.java

## We want to check on which field the particular annotation is present, if yes, then update the value of the field.

```
public static void main(String[] args) throws IllegalAccessException {
        Employee emp = new Employee();
        emp.setName("SidharthDas - ");
        processAnnotation(emp);

        System.out.println(emp);

    }

    public static void processAnnotation(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(NameSizeGreaterThan5AndStartWithS.class)) {
                f.setAccessible(true);
                String originalValue = (String) f.get(obj);
                String newVal = originalValue + "Sid";
                f.set(obj, newVal);
            }
        }
    }

-----------------------------------------------------------------------------------------------------------------------------------------------------
public static Set<String> check(Object obj) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Set<String> s = new HashSet<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if(f.isAnnotationPresent(CheckAddress.class)) {
                f.setAccessible(true);
                String temp = (String) f.get(obj);
                if(temp.length() < 10 || temp.length() > 30) {
                    CheckAddress checkAddress = f.getAnnotation(CheckAddress.class);
                    s.add(f.getName() + ":" + checkAddress.message());
                }
            }
        }

        return s;
    }
```
