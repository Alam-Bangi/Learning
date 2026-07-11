```
1. Is List really just an interface, or does it have behavior?
    Even though List is an interface, since Java 8 it contains default methods (like replaceAll, sort).
    So it’s not purely abstract anymore.

2. Why does List.of() behave strangely with nulls?
    List<String> list = List.of("A", null);
    💥 Throws NullPointerException
    Why?
    Because List.of() creates an immutable list implementation that disallows nulls for safety and optimization.

3. What’s the real danger of subList()?
    List<Integer> sub = list.subList(1, 3);
    Hidden truth:
    It is a view, not a copy
    Backed by original list
    💣 If you modify the original list structurally →
    You may get ConcurrentModificationException

4. Why can ArrayList suddenly become slow?
    Because of resizing:
    Internally uses an array
    When full → creates a new bigger array (usually 1.5x)
    💡 Hidden cost:
    Copying elements → expensive operation

5. Is LinkedList ever actually faster?
    Almost never in real-world modern systems.
    Even though theory says:
    Insert/delete = O(1)
    Reality:
    Poor CPU cache locality
    More memory overhead
    👉 ArrayList often outperforms LinkedList even for inserts

6. Why does remove() sometimes remove the wrong element?
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.remove(1);
    👉 Removes index 1, not value 1
    💥 Result: removes 2, not 1

7. Can List break equals/hashCode contracts?
    Yes, indirectly.
    If you store mutable objects:
    list.contains(obj);
    If obj changes after insertion →
    👉 You may not find it again

8. Why is List iteration sometimes faster than array?
    Surprising but true in some JVM optimizations:
    JVM can inline and optimize iterators
    Especially with enhanced for-loop

9. What’s the biggest hidden problem with List<Integer>?
    👉 Autoboxing overhead
    List<Integer> list = new ArrayList<>();
    Every int becomes an Integer object:
    More memory
    Slower performance

10. Why does contains() feel slow?
    Because:
    It uses linear search (O(n))
    Even in ArrayList
    👉 Use Set if frequent lookups needed

11. What is “structural modification” really?
    Operations that change:
    Size of list
    Examples:
    add/remove → YES
    set → NO
    Important for fail-fast behavior.

12. Why does ConcurrentModificationException exist?
    It’s not about threads only.
    It happens when:
    for(String s : list) {
        list.remove(s);
    }
    👉 Even in single-threaded code

13. Is fail-fast guaranteed?
    ❌ No
    It’s best-effort, not guaranteed:
    JVM may or may not throw exception

14. Why is Vector almost dead?
    Vector
    Synchronized by default
    Causes unnecessary overhead
    👉 Replaced by:
    Collections.synchronizedList
    CopyOnWriteArrayList

15. What’s weird about CopyOnWriteArrayList?
    CopyOnWriteArrayList
    Every write → creates a new copy
    Very expensive for writes
    But amazing for reads
    👉 Used in:
    Event listeners
    Read-heavy systems

16. Why is List not truly ordered sometimes?
    Because:
    Order depends on implementation
    Example:
    ArrayList → insertion order
    Custom lists → may behave differently

17. Can a List contain itself?
    list.add(list);
    ✅ Yes
    💣 But printing it may cause weird recursive output

18. Why does toArray() behave oddly?
    Object[] arr = list.toArray();
    👉 Returns Object[], not String[]
    Correct way:
    String[] arr = list.toArray(new String[0]);

19. What is the hidden memory cost of ArrayList?
    Capacity > size
    Unused memory remains allocated

20. Why is clear() not always freeing memory?
    list.clear();
    👉 Removes elements but:
    Capacity remains
    💡 To free memory:
    list = new ArrayList<>();

21. Why does equals() on List matter?
    list1.equals(list2);
    👉 Checks:
    Same elements
    Same order

22. What’s a silent bug with subList().clear()?
    list.subList(1, 3).clear();
    👉 Removes elements from original list
    💣 Many developers don’t expect this

23. Why does sorting sometimes crash?
    If elements are not:
    Comparable
    OR
    Comparator not provided
    👉 Throws ClassCastException

24. Can List be immutable but still change?
    Yes (tricky):
    List<List<Integer>> list = List.of(new ArrayList<>());
    list.get(0).add(10);
    👉 Outer list immutable
    👉 Inner list mutable

25. Why is List iteration unsafe in multithreading?
    Because most implementations:
    Are not thread-safe
    👉 Use:
    CopyOnWriteArrayList
    Synchronization

26. Why does indexOf() sometimes lie?
    If equals() is poorly implemented:
    👉 It may not find logically equal objects

27. What’s the real difference between capacity and size?
    Term	    Meaning
    Size	    Elements present
    Capacity	Internal array size

28. Why is removing from middle expensive?
    In ArrayList:
    Elements shift left
    👉 O(n) operation

29. Why do Lists cause memory leaks?
    If:
    Objects are not removed
    References are retained
    👉 GC cannot clean them

30. What’s the biggest misconception about List?
    👉 “It’s simple”
    Reality:
    Performance traps
    Hidden behaviors
    Subtle bugs

🧠 Final Insight
    The List interface looks simple, but:
    Its implementation details matter more than the interface
    Choosing wrong type → performance disaster
    Misusing methods → subtle bugs
```
```
🔹 1. What is the List interface?
    List is part of the Java Collections Framework and represents an ordered collection that:
    Maintains insertion order
    Allows duplicates
    Supports index-based access
    👉 FAANG tip: Always say order + duplicates + index clearly.

🔹 2. Why do we use List instead of arrays?
    Because List provides:
    Dynamic size
    Built-in methods
    Better abstraction
    👉 Strong answer:
    “Array is fixed, List is flexible.”

🔹 3. What is the difference between ArrayList and LinkedList?
    ArrayList
    Fast access (O(1))
    Slower insert/delete

    LinkedList
    Slow access (O(n))
    Faster insert/delete

    👉 FAANG insight:
    “In real systems, ArrayList is usually preferred due to better cache performance.”

🔹 4. When would you use ArrayList?
    When:
    You need fast reading
    You access elements frequently
    👉 Interview upgrade line:
    “Optimized for read-heavy operations.”

🔹 5. When would you use LinkedList?
    When:
    Frequent insertions/deletions
    Queue or deque operations
    👉 Honest FAANG answer:
    “Rarely used in modern applications.”

🔹 6. What is time complexity of ArrayList operations?
    Access → O(1)
    Add → O(1) (amortized)
    Remove → O(n)
    👉 Key word: amortized (interviewers love this)

🔹 7. Why is ArrayList add() not always O(1)?
    Because when capacity is full:
    A new array is created
    Elements are copied
    👉 This resizing makes it occasionally O(n)

🔹 8. What is the biggest mistake with List?
    Confusing remove() behavior.
    Code:
    list.remove(1);
    Why this is asked:
    Tests understanding of method overloading
    👉 Explanation:
    Removes element at index 1, not value 1

🔹 9. What is fail-fast behavior?
    If you modify a list during iteration:
    It throws ConcurrentModificationException
    👉 FAANG tip:
    Say “fail-fast iterator detects structural modification.”

🔹 10. Why does this fail?
    for(String s : list) {
        list.remove(s);
    }
    Why interviewers ask this:
    Tests understanding of iteration
    👉 Explanation:
    You are modifying the list while iterating
    Iterator detects change → throws exception

🔹 11. What is structural modification?
    Any change that affects list size:
    add/remove → YES
    set → NO

🔹 12. What is the difference between size and capacity?
    Size → number of elements
    Capacity → internal storage
    👉 FAANG insight:
    “ArrayList may have extra unused memory.”

🔹 13. Why is contains() slow in List?
    Because it checks elements one by one → O(n)
    👉 Better alternative:
    Use Set for fast lookup

🔹 14. What is Arrays.asList() trap?
    List<String> list = Arrays.asList("A", "B");
    list.add("C");
    Why this is asked:
    Very common interview trap
    👉 Explanation:
    Creates fixed-size list
    Cannot add/remove elements
    👉 Result:
    UnsupportedOperationException

🔹 15. What is List.of()?
    Creates an immutable list
    👉 Important:
    Cannot add/remove
    Does not allow null

🔹 16. What is subList() and why is it dangerous?
    It returns a view of original list
    👉 Why asked:
    Many think it’s a copy
    👉 Risk:
    Changes affect original list
    Can cause unexpected bugs

🔹 17. Is List thread-safe?
    ❌ No
    👉 Follow-up answer:
    Use:
    Synchronized list
    CopyOnWriteArrayList

🔹 18. Why is CopyOnWriteArrayList used?
    Because:
    Safe for concurrent reads
    No fail-fast exception
    👉 Trade-off:
    Slow writes

🔹 19. Can List store primitives?
    ❌ No
    👉 Reason:
    Java generics work with objects only
    👉 Use wrapper classes:
    int → Integer

🔹 20. What is autoboxing problem?
    Primitive values are converted into objects
    👉 Impact:
    More memory
    Slower performance

🔹 21. What is equality in List?
    Two lists are equal if:
    Same elements
    Same order
    👉 Order matters (important!)

🔹 22. Why is removing from middle slow?
    Because elements shift left
    👉 Time complexity:
    O(n)

🔹 23. What is the best implementation for most cases?
👉 ArrayList

🔹 24. What would you return in a method: List or ArrayList?
    👉 Return List
    👉 Why:
    Abstraction
    Flexibility

🔹 25. What is the most important takeaway?
    Choose correct implementation
    Understand performance
    Avoid common traps

🧠 FAANG Interview Strategy (Important)
If interviewer asks about List:
Start with definition
Compare ArrayList vs LinkedList
Mention complexity
Talk about edge cases
Add one real-world use
👉 That’s a perfect answer structure
```