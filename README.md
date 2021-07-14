# JavaCoreTopic


-> For BST please follow this package JUNE.BSTWithFullImplementation
 
 
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

To sort a map with respect to its value using Stream API.

```
final Map< String, Integer > sortedByCount = map.entrySet()
        .stream()
        .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));



