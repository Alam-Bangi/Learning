```
In Java, the storage location of variables in memory depends on their type and scope, primarily involving the Stack and Heap memory areas within the Java Virtual Machine (JVM).

1. Stack Memory:
Local Variables and Method Parameters: Primitive data types (like int, double, boolean) declared within a method, as well as method parameters, are stored directly on the stack.

Object References: References to objects (variables that store the memory address of an object) are also stored on the stack when they are local variables within a method.
Method Calls: Each time a method is called, a new "stack frame" is created on the stack to hold its local variables, method parameters, and the return address. This stack frame is removed when the method finishes execution. 

2. Heap Memory:
Objects and Instance Variables: All objects created using the new keyword, along with their instance variables (non-static fields), are stored in the heap. The heap is a shared memory area accessible by all threads in the application.
Arrays: Arrays, regardless of whether they store primitive types or objects, are also allocated on the heap.

3. Method Area (or Permanent Generation/Metaspace):
Class-level Information: This area stores information about loaded classes, including their compiled bytecode, static variables, and static methods

```