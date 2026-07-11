# How did the Collections Framework Evolve in Java?
```
Collections Framework
    The Collections Framework was introduced in Java 1.2.
    It had two main goals:
    Unify collection handling through standard interfaces and implementations
    Improve performance, flexibility, and ease of use
Evolution
Over time, the framework evolved with new features:
    Java 5: Generics, enhanced for-each loop, concurrent collections (e.g., ConcurrentHashMap)
    Java 8: Stream API, forEach, lambda expressions
    Java 9: Factory methods for immutable collections (List.of(), Set.of(), Map.of())
    Java 21: Sequenced collections for consistent ordering across types
```
# Why are Collections needed in Java?
```
Collections in Java provide a flexible and efficient way to store, retrieve, and manipulate data.
Limitations of Arrays:
    Fixed Size – Cannot grow or shrink dynamically.
    Manual Operations – Searching, adding, or removing elements requires extra logic
    Lack of Built-in Methods – No built-in sorting, searching, or advanced data structures.
How Collections Solve These Problems:
    Dynamic Resizing – Can grow or shrink as needed.
    Predefined Methods – Supports adding, removing, sorting, and searching elements easily.
    Rich Data Structures – Includes Lists, Sets, Maps, and Queues for different needs.
```
# Can you give a 10,000 feet overview of interfaces in collection framework?
```
Collection is at the root of the hierarchy (add element, remove element, ..)
    SequencedCollection provides well-defined order (add first, add last, ..)
    List stores ordered elements, allows duplicates, supports index (add element e at index 3)
    Set holds unique elements; no duplicates allowed
        SortedSet maintains elements in sorted order
        NavigableSet adds search/navigation methods
    Queue is used for FIFO processing of elements
    Deque is a double-ended queue (SequencedCollection)
Map stores key-value pairs; keys must be unique (Does not inherit from Collection interface)
    SortedMap maintains elements in sorted order
    NavigableMap adds search/navigation methods
```
# What are the key methods in the Collection interface?
```
Collection is root interface of the collection framework!
Key Methods
    add(E element): Adds an element to the collection.
    remove(Object element): Removes an element from the collection.
    size(): Returns the number of elements in the collection.
    isEmpty(): Checks if the collection is empty.
    clear(): Removes all elements from the collection.
    contains(Object element): Checks if an element exists in the collection.
    containsAll(Collection<?> c): Checks if all elements in another collection exist.
    addAll(Collection<? extends E> c): Adds all elements from another collection.
    removeAll(Collection<?> c): Removes all matching elements.
    retainAll(Collection<?> c): Keeps only elements present in another collection.
    iterator(): Returns an iterator to traverse elements.
    stream(): Returns a stream using the elements in the collection
    parallelStream(): Returns a parallel stream using the elements in the collection
```
# What are the key methods in the SequencedCollection interface?
```
Introduced in JDK 21, SequencedCollection extends Collection Interface. It represents a collection that has a well-defined encounter order, that supports operations at both ends, and that is reversible.

Key Methods
    addFirst(E e): Adds an element at the beginning of the collection.
    addLast(E e): Adds an element at the end of the collection.
    getFirst(): Retrieves the first element of the collection.
    getLast(): Retrieves the last element of the collection.
    removeFirst(): Removes and returns the first element of the collection.
    removeLast(): Removes and returns the last element of the collection.
    reversed(): Returns a view of the collection with elements in reverse order.
```
# What are the key methods in the List interface?
```
Extension of SequencedCollection
    List extends SequencedCollection, inheriting all its methods.
    Provides additional methods for position-based operations.
    A list may have duplicate elements.
Insertion Order is Maintained
    Maintains the insertion order of elements.
    Elements are stored in the order they are added.
Inserting Elements
    Use add(int position, E element) to insert at a specific position.
    Elements added without position go to the end.
```
# How do you decide which List implementation to use?
```
📌 1. ArrayList – Best for Fast Random Access
Key Characteristics:
    Uses a dynamic array internally
    Maintains insertion order of elements
    Supports indexed access to elements
When to Use:
    Fast element access via get(index)
    Insertions/removals mostly at the end
    You don’t need thread safety
When to Avoid:
    Frequent insertions or deletions in the middle
    Large shifts in elements (reallocation is expensive)
📌 2. LinkedList – Best for Frequent Insertions/Deletions
Key Characteristics:
    Uses a doubly linked list internally
    Each element has references to the next and previous elements
When to Use:
    Frequent insertions or deletions in the middle
When to Avoid:
    Fast random access (get(index)) is needed
    Memory overhead is a concern (extra references per element)
📌 3. Vector – Best for Thread-Safe Lists
Key Characteristics:
    Uses a dynamic array like ArrayList
    All methods are synchronized (thread-safe)
    Slower than ArrayList due to synchronization overhead
When to Use:
    Multiple threads access the list simultaneously
    Working with legacy code that already uses Vector
When to Avoid:
    Thread safety is not required (ArrayList is faster)
    Performance is important (synchronization adds overhead)
📌 4. CopyOnWriteArrayList – Best for Read-Mostly, Thread-Safe Scenarios
Key Characteristics:
    Thread-safe variant of ArrayList
    Creates a new copy of the array on each write (add/remove)
    Safe to iterate even during concurrent modifications
When to Use:
    Concurrent, read-heavy scenarios
When to Avoid:
    Frequent writes or large lists (copying is expensive)
```
# How do you choose the right approach to sort a List?
```
📌 1. Using Collections.sort() – Best for Simple Sorting
    Uses natural ordering (e.g., alphabetical for Strings, ascending for numbers).
    Modifies the original list in place.
When to Use:
    Sorting a list of Strings or primitive types.
    Sorting objects that implement Comparable.
Example:
List<String> numbers = new ArrayList<>();
numbers.add("one");
numbers.add("two");
numbers.add("three");
numbers.add("four");
Collections.sort(numbers);
System.out.println(numbers); // [four, one, three, two]

📌 2. Using Comparable – Best for Natural Ordering
    Implement Comparable<T> in the class.
    Used when objects have a default sorting order (e.g., sorting players by runs).
When to Use:
    When an object has a natural ordering (e.g., sorting Cricketers by runs).
    If the class controls its sorting logic.
Example:
class Cricketer implements Comparable<Cricketer> 
    @Override
    public int compareTo(Cricketer that) {
        return Integer.compare(this.runs, that.runs);
    }
List<Cricketer> players = Arrays.asList(
    new Cricketer("Virat", 12200),
    new Cricketer("Rohit", 11600),
    new Cricketer("Gill", 2400),
    new Cricketer("Dhoni", 10700)
);
Collections.sort(players); // Sort using Comparable (ascending by runs)

📌 3. Using Comparator – Best for Custom Sorting
    Implement Comparator<T> separately from the class.
    Allows sorting by different criteria (e.g., descending order).
When to Use:
    When multiple sorting orders are needed (e.g., sorting by name, then by runs).
    When modifying the original class is not possible.
Example:
import java.util.Comparator;

class DescendingSorter implements Comparator<Cricketer> {
    @Override
    public int compare(Cricketer c1, Cricketer c2) {
        return Integer.compare(c2.runs, c1.runs);
    }
}
Collections.sort(players, new DescendingSorter()); // Sort using Comparator (descending by runs)

📌 4. Comparison of Sorting Approaches
Approach	        When to Use	                                Modifies Original Class?
Collections.sort()	Simple sorting of Strings/numbers	        No
Comparable	        When objects have a default sorting order	Yes (compareTo())
Comparator	        For custom sorting orders	                No
```
# What are the key interfaces associated with Set operations?
```
Set – Extends Collection interface. Does not allow duplicates.
    SequencedSet - A collection that is both a Sequenced Collection and a Set. Represents a collection of unique elements with a well-defined order.
    SortedSet – Extends SequencedSet and maintains sorted order. Provides methods like first(), last(), subSet(), headSet(), tailSet()
    NavigableSet – Extends SortedSet and provides navigation methods like lower(), higher(), floor(), ceiling().

interface Set<E> extends Collection<E> {
    // No duplicate elements allowed
    // No ordering guaranteed
}

interface SequencedSet<E> extends Set<E>, SequencedCollection<E> {
    SequencedSet<E> reversed();
    void addFirst(E e); //From SequencedCollection
    void addLast(E e); //From SequencedCollection
    E getFirst(); //From SequencedCollection
    E getLast(); //From SequencedCollection
    E removeFirst(); //From SequencedCollection
    E removeLast(); //From SequencedCollection
}

interface SortedSet<E> extends SequencedSet<E> {
    SortedSet<E> subSet(E start, E end); // start to end-1
    SortedSet<E> headSet(E end); // < end
    SortedSet<E> tailSet(E start); // >= start
    E first();
    E last();
}

interface NavigableSet<E> extends SortedSet<E> {
    E lower(E e); //largest x such that x < e
    E floor(E e); //largest x such that x <= e
    E ceiling(E e);//smallest x such that x >= e
    E higher(E e); //smallest x such that x > e
    E pollFirst(); //return and remove first element
    E pollLast(); //return and remove last element
}
```
# How do you decide which Set implementation to use?
```
📌 1. HashSet – Best for Fast Lookups
Key Characteristics:
    Unordered collection
    Does not allow duplicate elements
When to Use:
    Fast lookups and uniqueness are priorities
    You don’t care about the order of elements
When to Avoid:
    You need to preserve insertion or sorted order
    You need thread safety
📌 2. LinkedHashSet – Best for Maintaining Insertion Order
Key Characteristics:
    Extends HashSet
    Maintains insertion order
    Slightly slower than HashSet
When to Use:
    You want predictable iteration order
    Need fast operations + ordering
When to Avoid:
    Order doesn’t matter (HashSet is faster)
    You need sorting (TreeSet is more appropriate)
    You need thread safety
📌 3. TreeSet – Best for Sorted Elements
Key Characteristics:
    Implements NavigableSet
    Maintains elements in natural or custom sort order
    Backed by a Red-Black Tree
When to Use:
    You need sorted elements
    You need Range-based queries (subSet, headSet, tailSet)
When to Avoid:
    Sorting is unnecessary (HashSet is faster)
    You need thread safety

📌 4. CopyOnWriteArraySet – Best for Read-Mostly, Thread-Safe Scenarios
Key Characteristics:
    Thread-safe Set implementation
    All write operations (add/remove) create a new copy
When to Use:
    Many reads, few writes
    You need thread-safety
When to Avoid:
    Frequent writes or large data sets (copying is expensive)
📌 5. ConcurrentSkipListSet – Best for Concurrent & Sorted Access
Key Characteristics:
    Thread-safe version of TreeSet
    Backed by a concurrent skip list
    Maintains sorted order
When to Use:
    Multi-threaded applications needing sorted data
When to Avoid:
    Single-threaded scenarios (overhead is unnecessary)
```
# What are the main interfaces related to Queue?
```
Interface	    Description	                                    Key Methods	                        Extends
Queue	        Holds elements for processing in FIFO order	    offer(e), poll(), peek()            Collection
Deque	        Double-ended queue allowing insertion/removal	addFirst(e), removeLast(),          Queue,SequencedCollection
                from both ends                                  peekFirst()
BlockingQueue	Thread-safe queue that blocks when full/empty	put(e), take(), poll(timeout)       Queue

Queue Interface
    Extends the Collection interface.
    Used for holding elements in order for processing.
Key Methods:
    peek(): Retrieves the head without removal.
    poll(): Retrieves and removes the head.
interface Queue<E> extends Collection<E> { 
    boolean add(E e); // inserts element, exception if full
    boolean offer(E e); // inserts element, returns false if full
    E remove(); // removes head, exception if empty
    E poll(); // removes head, null if empty
    E element(); // gets head, exception if empty          
    E peek(); // gets head, null if empty
}

Deque Interface
    Extends Queue & SequencedCollection interfaces
    Supports insertion and removal from both ends.
interface Deque<E> extends Queue<E>, SequencedCollection<E> {
    void addFirst(E e); // add to front, exception if full
    void addLast(E e); // add to end, exception if full
    boolean offerFirst(E e); // add to front, false if full
    boolean offerLast(E e); // add to end, false if full
    E removeFirst(); // remove from front, exception if empty
    E removeLast(); // remove from end, exception if empty
    E pollFirst(); // remove from front, null if empty
    E pollLast(); // remove from end, null if empty
    E getFirst(); // get front, exception if empty
    E getLast(); // get end, exception if empty
    E peekFirst(); // get front, null if empty
    E peekLast(); // get end, null if empty
    boolean removeFirstOccurrence(Object o); // remove first match
    boolean removeLastOccurrence(Object o); // remove last match
}

BlockingQueue Interface
    A thread-safe queue designed for use in producer-consumer scenarios
Blocks:
    On put(e) if the queue is full
    On take() if the queue is empty
interface BlockingQueue<E> extends Queue<E> {
    void put(E e) throws InterruptedException; // inserts, waits if full
    boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException; // inserts with timeout, waits if full
    E take() throws InterruptedException; // removes, waits if empty
    E poll(long timeout, TimeUnit unit) throws InterruptedException; // removes with timeout, waits if empty
    int remainingCapacity(); // remaining capacity in queue
    int drainTo(Collection<? super E> c); // removes all into given collection
    int drainTo(Collection<? super E> c, int maxElements); // removes up to maxElements into given collection
}
```
# What are the important implementations of Queue?
```
Name	                Description	                                    Extends	            Implements
PriorityQueue	        Queue where elements are sorted by priority     AbstractQueue	    Queue
ArrayDeque	            Resizable array-based Deque	                    AbstractCollection	Deque
ArrayBlockingQueue	    Array-backed blocking queue (Fixed Size)	    AbstractQueue	    BlockingQueue
LinkedBlockingQueue	    Linked-list blocking queue	                    AbstractQueue	    BlockingQueue
ConcurrentLinkedQueue	Lock-free thread-safe queue	                    AbstractQueue	    Queue
ConcurrentLinkedDeque	Lock-free thread-safe deque	                    AbstractCollection	Deque
```
# What are the key interfaces related to Map?
```
Here are the Map-related interfaces in Java:

1. Map Interface
    What? A collection that stores key-value pairs.
    Why? Allows quick lookup and modification of values using keys.
Key Characteristics:
    Does not extend Collection.
    Keys are unique, but values can be duplicate.
    Uses Entry objects to store key-value pairs.
Important Methods:
Method	                        Description
put(K key, V value)	            Adds a key-value pair.
get(Object key)	                Retrieves the value for a given key.
remove(Object key)	            Removes a key-value pair.
containsKey(Object key)	        Checks if a key exists.
containsValue(Object value)	    Checks if a value exists.
keySet()	                    Returns all keys.
values()	                    Returns all values.
entrySet()	                    Returns all key-value pairs.

2. SequencedMap Interface
    What? A Map that maintains a well-defined sequence of entries
    Why? Allows consistent iteration order and reverse traversal
Key Characteristics:
    Extends Map
    Maintains the insertion or access order (depending on implementation)
    Adds methods to get/remove first and last entries
    Useful when both ordering and key-based access are important
Important Methods:
Method	                    Description
firstEntry()	            Returns the first entry in sequence
lastEntry()	                Returns the last entry in sequence
pollFirstEntry()	        Removes and returns the first entry
pollLastEntry()	            Removes and returns the last entry
reversed()	                Returns a reversed view of the map
putFirst(K key, V value)	Inserts entry at the beginning of sequence
putLast(K key, V value)	    Inserts entry at the end of sequence

3. SortedMap Interface
    What? A Map that maintains keys in sorted order.
    Why? Useful when sorting keys automatically.
Key Characteristics:
    Extends SequencedMap.
    Keys are sorted in natural order or by a Comparator.
Important Methods:
Method	                Description
firstKey()	            Returns the first (lowest) key.
lastKey()	            Returns the last (highest) key.
subMap(fromKey, toKey)	Returns a portion of the map.
headMap(toKey)	        Returns view of map with keys < toKey
tailMap(fromKey)	    Returns view of map with keys ≥ fromKey

4. NavigableMap Interface
    What? An extension of SortedMap with navigation methods.
    Why? Provides methods to find the closest matches for keys.
Key Characteristics:
    Allows floor, ceiling, higher, and lower key lookups.
    Supports reverse order traversal.
Important Methods:
Method	            Description
floorKey(K key)	    Returns the largest key ≤ given key
ceilingKey(K key)	Returns the smallest key ≥ given key
lowerKey(K key)	    Returns the largest key < given key
higherKey(K key)	Returns the smallest key > given key
floorEntry(K key)	Returns entry with the largest key ≤ given key
ceilingEntry(K key)	Returns entry with the smallest key ≥ given key
lowerEntry(K key)	Returns entry with the largest key < given key
higherEntry(K key)	Returns entry with the smallest key > given key
descendingMap()	    Returns a reverse-order view of the map
```
# What are the key implementations of Map Interface?
```
Name	                Description	                                            Extends	        Implements
HashMap	                Unordered key-value store (NOT thread safe)	            AbstractMap	    Map
LinkedHashMap	        Map with insertion order (NOT thread safe)	            HashMap	        SequencedMap
TreeMap	                Sorted key-value store(Red-Black tree, Not thread safe)	AbstractMap	    NavigableMap
ConcurrentHashMap	    Thread-safe map with high concurrency	                AbstractMap	    ConcurrentMap (Map)
ConcurrentSkipListMap	Thread-safe, sorted map (Keys are sorted)	            AbstractMap	    ConcurrentNavigableMap (NavigableMap)
```
# What is the purpose of the Collections class?
```
The Collections class provides utility methods for working with collections:
Feature	                    Methods	                            Purpose

Sorting	                    sort(List)	                        Sorts a list in natural order.
Searching	                binarySearch(List, key)	            Finds an element in a sorted list.
Thread Safety	            synchronizedList(List)	            Creates a thread-safe list.
Unmodifiable Collections	unmodifiableList(List)	            Makes a list read-only.
Finding Min/Max	            min(Collection), max(Collection)	Gets the smallest or largest element.
Shuffling/Reversing	        shuffle(List), reverse(List)	    Randomizes or reverses order.
```
# How do Synchronized and Concurrent Collections differ?
```
Feature	                Synchronized Collections	            Concurrent Collections
Synchronization Method	Uses synchronized methods & blocks	    Uses modern concurrency mechanisms like locks and non-blocking algorithms
Performance	            Slower due to full synchronization	    Faster as multiple threads can work concurrently
Thread Safety	        Only one thread can access collection 	Multiple threads can safely modify the collection
                        at a time 
Examples	            Vector, Hashtable,                      ConcurrentHashMap, CopyOnWriteArrayList, ConcurrentLinkedQueue
                        Collections.synchronizedList()
Best Use Case	        When multiple threads rarely modify	    When multiple threads frequently modify the collection
                        the collection 
```
# What is the CopyOnWrite approach in Concurrent Collections?
```
    What? A technique where modifications create a new copy of the collection instead of modifying the existing one.
    Why? Ensures thread safety without synchronization during read operations.
How?
    Stores values in an immutable internal array.
    When modified, a new array is created with the updated data.
    Read operations are fast and do not block, only write operations are synchronized.
Best Use Case: When reads outnumber writes
Example Implementations: CopyOnWriteArrayList, CopyOnWriteArraySet.
```
# What is the Compare-And-Swap (CAS) approach?
```
    What? A low-level, non-blocking synchronization technique used for thread-safe updates
    Why? Avoids locking, improving performance in high-concurrency scenarios
How it works:
    Read the current value (expected value)
    Compute the new value
    Compare the current value with the expected value
    If they match, update to the new value
    If not, retries until it succeeds or exits (in very rare cases)
Used In: ConcurrentLinkedQueue, AtomicInteger etc..
```
# In what scenarios does a Java Collection throw UnsupportedOperationException?
```
    What? Thrown when an operation is not supported by a collection.
    Fixed Size Lists
Example: Arrays.asList()
    Operations that change the size of a list, like add()/remove(), throw UnsupportedOperationException
    Operations that do not change the size of the list, like set(), are allowed
    Unmodifiable Collections
Example: List.of(), Set.of(), Collections.unmodifiableList()
    All mutation operations (like add(), remove(), set(), clear()) throw UnsupportedOperationException`
```
# What is the difference between Fail-Fast and Fail-Safe Iterators?
```
1. What is a Fail-Fast Iterator?
    What? Throws ConcurrentModificationException if the collection is modified during iteration.
    Where? Used in non-thread-safe collections like ArrayList, HashMap, etc.
    When? Happens when a structural modification (add/remove) occurs outside the iterator.
Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    Iterator<String> iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
        System.out.println(map.get(iterator.next())); 
        // Throws ConcurrentModificationException
        map.put("key4", "value4"); 
    }

2. What is a Fail-Safe Iterator?
    What? Does not throw exceptions on modification.
    Where? Used in concurrent collections (ConcurrentHashMap, CopyOnWriteArrayList).
    Why? Works on a separate copy of the data, ensuring safe iteration.
ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    Iterator<String> iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
        System.out.println(map.get(iterator.next()));
        map.put("key4", "value4"); // No Exception
    }

3. Fail-Fast vs Fail-Safe
Feature	        Fail-Fast	                                Fail-Safe
Modification	Throws ConcurrentModificationException      No exception
Thread Safety	Not safe	                                Thread-safe
Works On	    Direct collection	                        A copy of the collection
Examples	    ArrayList, HashMap	                        ConcurrentHashMap, CopyOnWriteArrayList
```
# What are some best practices for using Collections in Java?
```
1. Choose the Right Collection Type
    Invest time to decide the right List, Queue, Set or Map to use
2. Set Initial Capacity to Reduce Resizing
    Prevents frequent resizing and improves performance.
    // Avoids unnecessary resizing
    Map<String, Integer> map = new HashMap<>(100); 
3. Use the Right Data Structure for Thread Safety
    Use ConcurrentHashMap instead of HashMap in multi-threaded environments.
    Use CopyOnWriteArrayList for read-heavy operations with rare writes.
4. Use Immutable Collections When Possible
    Prevents accidental modification and improves safety.
    Use Collections.unmodifiableList() or List.of().
    // Immutable List
    List<String> names = List.of("Alice", "Bob", "Charlie"); 
5. Prefer Iterators or Streams Over Manual Loops
    Improves readability and avoids IndexOutOfBoundsException.
    // More readable than a for-loop
    list.forEach(System.out::println);
```
# Why are Sequenced Collections introduced?
```
Problem: Getting/Modifying first/last elements is tricky
Solution: Java 21 added SequencedCollection interface
    Sequenced Collection Interfaces
    interface SequencedCollection<E> extends Collection<E> {
        void addFirst(E element);  
        void addLast(E element);
        E getFirst();  
        E getLast();  
        E removeFirst();  
        E removeLast();  
        SequencedCollection<E> reversed();
    }
    interface SequencedSet<E> 
        extends Set<E>, SequencedCollection<E> {
        SequencedSet<E> reversed();
    }
    interface SequencedMap<K, V> extends Map<K, V> {
        SequencedMap<K, V> reversed();
        SequencedSet<K> sequencedKeySet();
        SequencedCollection<V> sequencedValues();
        SequencedSet<Entry<K, V>> sequencedEntrySet();
        V putFirst(K key, V value);
        V putLast(K key, V value);
        Entry<K, V> firstEntry();
        Entry<K, V> lastEntry();
        Entry<K, V> pollFirstEntry();
        Entry<K, V> pollLastEntry();
    }
Example: ArrayList
    var courses = new ArrayList<>();
    courses.add("Java");
    courses.addFirst("Python");
    courses.addLast("JavaScript");

    System.out.println(courses.getFirst()); // Python
    System.out.println(courses.getLast());  // JavaScript
    System.out.println(courses.reversed()); // [JavaScript, Java, Python]

Example: LinkedHashSet
    var courses = new LinkedHashSet<>(List.of("Spring", "AWS", "Azure"));
    courses.addFirst("Java");
    courses.addLast("Kotlin");
    System.out.println(courses.getFirst()); // Java
    System.out.println(courses.getLast());  // Kotlin
    System.out.println(courses.reversed()); // [Kotlin, Azure, AWS, Spring, Java]

Example: LinkedHashMap
    var courses = new LinkedHashMap<>();
    courses.put(1, "Spring");
    courses.put(2, "Spring Boot");
    courses.put(3, "Spring AI");

    courses.putFirst(0, "Java");
    courses.putLast(4, "Kotlin");

    System.out.println(courses.reversed()); //{4=Kotlin, 3=Spring AI, 2=Spring Boot, 1=Spring, 0=Java}
    System.out.println(courses.sequencedKeySet()); //[0, 1, 2, 3, 4]
    System.out.println(courses.sequencedValues()); //[Java, Spring, Spring Boot, Spring AI, Kotlin]
    System.out.println(courses.firstEntry()); //0=Java
    System.out.println(courses.lastEntry()); //4=Kotlin
    System.out.println(courses.pollFirstEntry()); //0=Java (Removes and returns the first key-value pair)
    System.out.println(courses.pollLastEntry()); //4=Kotlin
```