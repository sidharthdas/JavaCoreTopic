# Java Memory Management:

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/bd2a29b9-6c6d-4ec6-b71b-9d25e8acad58)

1. Exceptions:
    1. StackOverflowException: StackOverflowException is thrown for execution stack overflow errors, typically in case of a very deep or unbounded recursion.
    2. OutOfMemoryError: OutOfMemoryError is a Java exception that is thrown when the Java Virtual Machine (JVM) is unable to allocate an object because it is out of memory.
    3. PermSpaceException: it is OutOfMemoryError, PermGen space error is a runtime error in Java that occurs when the permanent generation (PermGen) area in memory is exhausted. The PermGen area of the Java heap is used to store metadata such as class declarations, methods, and object arrays.

2. Declaring Spaces:
   1. Heap: Initial Size: -Xms MaximumSize: Xmx
   2. Perm Space: -XX:PermSize and -XX:MaxPermSize
   3. Meta Space: MaxMetaspaceSize

3. Profiling:
   1. Jstat :
   2. Jmap :
   3. ide profiler :

   


