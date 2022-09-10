# JavaCoreTopic

-> For Java core topics, refer package JavaCoreTopicsImplementation17thJul2021

-> For BST please follow this package JUNE.BSTWithFullImplementation

-> For java8 functional interface, refer JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces.
 
 
 1. Insert a node
 2. Remove a node
 3. inOrder
 4. preOrder
 5. postOrder
 6. Print left side of node
 7. Print right side of node
 8. Descending order
 9. Height of BST
10. Mirror image of BST

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
