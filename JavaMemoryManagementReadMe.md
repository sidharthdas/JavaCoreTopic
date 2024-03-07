# Java Memory Management:

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/bd2a29b9-6c6d-4ec6-b71b-9d25e8acad58)

Memory :
   1. Stack: Stack Memory in Java is used for static memory allocation and the execution of a thread. It contains primitive values that are specific to a method and references to objects from the method that are in a heap. Access to this memory is in Last-In-First-Out (LIFO)
   2. Heap: Java objects reside in an area called the heap. The heap is created when the JVM starts up and may increase or decrease in size while the application runs.
             i. Young Generation: The young generation is a region of the Java heap where newly created objects are allocated. It is typically divided into three parts:
              a). Eden Memory:  This is the area where new objects are created. When the Eden space is full, a minor garbage collection (GC) event is triggered.
              b). Survivour Memory: The survivor spaces are used to store objects that have survived one or more minor GC events. Objects that survive a minor GC event are moved to one of the survivor spaces. If an object                                         survives a certain number of minor GC events (typically 15), it is promoted to the old generation.
             ii. Old Generation: The old generation is the other part of the heap. It is where objects that are likely to live for a long time are stored. The old generation is also subject to GC, but GC events in the old                                 generation are much less frequent than minor GC events.

   4. Meta Space:  Metaspace is a memory space in the Java Virtual Machine (JVM) that stores class metadata and method code. It was introduced in Java 8 as a replacement for PermGen, which was a memory space that had                         similar functionality but was prone to OutOfMemoryError exceptions.

```  Metaspace stores a variety of class metadata, including:
                    1. The names of classes, methods, and fields
                    2. The modifiers of classes, methods, and fields
                    3. The signatures of methods
                    4. The bytecode of methods
                    5. The constant pool of classes
```

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

   


