# JavaCoreTopic

-> Kadane Algorithm:

Maximum sum of sub-array:
Notes:
```
Initially keep sum = 0 and maxi = arr[0] (this is coz sub-array can be atleast one element)
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
-> Sort 2D array using Arrays.sort
```
 Arrays.sort(score, (score1, score2) -> score2[k] - score1[k]);
```
Stream API nested null check:
```
Optional.ofNullable(model1)
        .map(MainModel::getStudentList)
        .map(studentList -> studentList.stream().findFirst())
        .flatMap(student -> student.stream().findFirst())
        .ifPresent(z -> s.setName(z.getName()));
```
-> PriorityQueue Implementation
```
PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1); 
//Here, in the argument, we need to pass the Comparator (Added lamda exp for sorting)
```
-> Sort the list of String by length in reverse order and then if length are equal then sort by natural order
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

-> For Java core topics, refer package JavaCoreTopicsImplementation17thJul2021

-> For BST please follow this package src/binarysearchtree20Feb2023

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

-> For java8 functional interface, refer JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces.

-> Map java8 functionalities, refer spet2022.MapPractice
```
Map<String, Employee> mapEmpl = empList.stream().collect(Collectors.groupingBy(x -> x.dept.deptCode, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(x -> x.empSalary)),
                Optional::get)));
```

-> Sort map by value and if values are equal then sort by key
```
map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
```
-> Flatten the List using flatMap method:
```
l.stream().filter(x -> x.size() == 4)
                .flatMap(List::stream).reduce(Integer::sum).get();
```
 
 

-> For Callable, Future Object and ExecutorService Implementation, please refer JUNE.callableImplementation

-> For Singleton, please refer JUNE.practice1.singleton

-> For String custom sorting, refer package JavaCoreTopicsImplementation17thJul2021.stringCustomSorting; classNAME: StringCustomSortingMainClass

To sort a map with respect to its value using Stream API.

Sort map with value and if value is same sort by alpha order:

```
map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2 ) -> e1, LinkedHashMap::new));

```

Find highest occurance String from list:

```
Optional<Map.Entry<String, Long>> l  = items.stream().
				collect(Collectors.groupingBy(O -> O, Collectors. counting()))
				.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparing(p-> p.getValue()))).findFirst();
```

Generics:
1. Upper bound generics: Any class extends by Object, this can access
```
List<? extends Object>
```
2. Lower bound generics: All the super class of the class can be access. i.e. all the super class of animal can be access
```
List<? super Aminal>
```

```
final Map< String, Integer > sortedByCount = map.entrySet()
        .stream()
        .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));
```

Java 1.8 Stream Feature:

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


BST - Delete Node : 

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

Delete Middle Element Of LinkedList:

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

Record:

it is use to transfer the data and access the data, no need of creating DTO/POJO classes

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
