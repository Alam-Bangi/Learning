```
JAVA ARRAYS & ARRAYLIST INTERVIEW Q&A SHEET
SECTION 1: Basics of Arrays

- What is an array in Java?
    Fixed-size data structure that stores elements of the same type in contiguous memory.

- Why does array index start from 0?
    For efficient memory access: Address = base + (index × size).

- Default values of array elements:
    int → 0, double → 0.0, boolean → false, Object → null

- Exception on invalid index:
    ArrayIndexOutOfBoundsException

- Time complexity of accessing element:
    O(1)

- Are arrays objects?
    Yes, stored in heap memory, inherit from Object.

- Multidimensional array:
    Array of arrays.

- Jagged array:
    Array of arrays with different row lengths.

- Difference between == and Arrays.equals():
    == → reference comparison
    Arrays.equals() → compares actual values
- Can array size be changed after creation?
    No, arrays are fixed-size.

SECTION 2: Advanced Array Concepts

- Shallow copy vs deep copy:
    Shallow → copies reference
    Deep → creates new array

- System.arraycopy()
    Native method for fast array copy (faster than loop).

- Passing arrays to methods:
    Passed by reference value → changes affect original array.

- length vs length() vs size():
    array.length → array size
    String.length() → number of characters
    ArrayList.size() → number of elements

- Time complexity of inserting/deleting in middle of array:
    O(n) (due to shifting elements)

- Covariance in arrays:
    Parent reference can point to child array (e.g., Object[] arr = new String[3];)
    Dangerous → runtime ArrayStoreException.

- clone() vs assignment (=):
    Assignment → copies reference
    clone() → creates new independent array

SECTION 3: ArrayList Basics

- What is ArrayList?
    Resizable array, dynamic size, implements List interface.

- ArrayList vs LinkedList:
    Feature	        ArrayList	    LinkedList
    Structure	    Dynamic array	Doubly linked list
    Access	        O(1)	        O(n)
    Insert/Delete	O(n)	        O(1) at known pos
    Memory	        Less	        More (pointers)

- ArrayList size vs capacity:
    size() → number of elements
    Capacity → size of underlying array

- ArrayList resizing:
    When capacity exceeded → new array ≈ 1.5× old size, copy elements

- ArrayList cannot store primitives:
    Uses wrapper classes (Integer, Double)

- Thread-safety:
    Not thread-safe → can use Collections.synchronizedList()

- Iterating:
    Use for-loop, enhanced for-loop, or Iterator

- subList():
    Returns a view backed by original list; changes reflect in both

SECTION 4: Common Tricky Interview Questions

- What does System.out.println(array) print?
    Array reference ([I@6d06d69c), not elements

- Arrays.toString() vs Arrays.deepToString():
    toString() → 1D array
    deepToString() → multidimensional array

- Array covariance problem:
    Object[] arr = new String[3]; arr[0] = 10; → runtime ArrayStoreException

- ArrayList fail-fast iterator:
    Modifying ArrayList while iterating → ConcurrentModificationException

- Cloning arrays:
    clone() → deep copy for primitive array
    Assignment → shallow copy
```