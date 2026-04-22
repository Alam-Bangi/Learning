```
🧠 1. Can HashSet store duplicates internally?
    Answer:
    Yes… temporarily.
    When two objects have:
    Same hashCode()
    But equals() returns false
    They go into the same bucket (collision), but are still stored separately.
    👉 So:
    No logical duplicates
    But physical collisions exist

⚠️ 2. Can a Set “lose” elements?
    Answer:
    Yes, if you mutate an object after inserting it.
    class Person {
        int id;

        public int hashCode() { return id; }
    }
    Person p = new Person();
    p.id = 1;
    Set<Person> set = new HashSet<>();
    set.add(p);
    p.id = 2; // 🔥 dangerous
    Now:
    set.contains(p) → ❌ false
    Element is “lost”
    👉 Because hash bucket changed after insertion.

🔥 3. Why does removing from Set sometimes fail?
    Answer:
    Same reason: mutated object or bad equals()/hashCode().

🧬 4. Can TreeSet silently drop elements?
    Answer:
    Yes—and this shocks people.
    If compareTo() returns 0, TreeSet assumes:
    👉 “these are duplicates”
    Even if equals() says they are different.

🧪 5. Inconsistent compareTo vs equals = data loss
    compareTo() == 0
    BUT equals() == false
    👉 TreeSet will drop elements silently

🧵 6. Why is HashSet iteration order sometimes predictable?
    Answer:
    It looks predictable due to:
    JVM implementation
    Same hash distribution
    But:
    👉 It is NOT guaranteed
    👉 Can break across versions

⚡ 7. Why does HashSet performance suddenly degrade?
    Answer:
    Too many collisions → turns into:
    👉 Linked list (Java 7)
    👉 Balanced tree (Java 8+)
    Worst case:
    O(n) → Java 7
    O(log n) → Java 8+

🧨 8. Load factor & capacity actually matter
    Default:
    capacity = 16
    loadFactor = 0.75
    Resize happens when:
    size > capacity * loadFactor
    👉 Interview trick:
    Pre-sizing improves performance significantly

🧊 9. Why Set.of() behaves strangely?
    Set.of(1, 2, 2);
    👉 Throws exception (not silently removing duplicates)
    Also:
    Immutable
    No nulls

🧠 10. Why HashSet uses HashMap internally?
    Internally:
    map.put(element, PRESENT);
    👉 Value is dummy object
    👉 Only keys matter

⚠️ 11. Why equals() alone is not enough?
    Because:
    HashSet uses hashCode first
    equals only if collision occurs
    👉 If hashCode differs → equals never checked

🧬 12. Can two unequal objects have same hashCode?
    Yes (collision).
    👉 That’s why equals is still needed

🧨 13. Why TreeSet is dangerous with custom objects?
    If you forget:
    Comparable
    OR
    Comparator
    👉 Runtime crash:
    ClassCastException

🔄 14. Fail-fast behavior (hidden trap)
    for(String s : set) {
        set.remove(s); // ❌
    }
    👉 Throws:
    ConcurrentModificationException

🧵 15. Why CopyOnWriteArraySet is rarely used?
    Because:
    Every write = full copy
    👉 Very expensive
    Good only when:
    Reads >> Writes

⚡ 16. Why HashSet allows only one null?
    Because:
    Only one null key allowed in underlying HashMap

🧊 17. Why TreeSet cannot store null (real reason)?
    Not just comparison—
    👉 It uses methods like:
    compareTo()
    compare()
    Calling them on null → crash

🧠 18. Why Set has no get() method?
    Because:
    👉 It is not position-based
    👉 It is identity-based

🔥 19. Can Set be sorted without TreeSet?
    Yes:
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);

🧨 20. Memory overhead nobody talks about
    HashSet stores:
    HashMap
    Buckets
    Nodes
    👉 Much heavier than ArrayList

🧬 21. Why EnumSet is insanely fast?
    Because:
    👉 Uses bit vector (bitmask) internally
    👉 Not hash/table based

⚠️ 22. Why LinkedHashSet is underrated?
    It gives:
    Order + uniqueness
    Almost same performance as HashSet
    👉 Great default choice in real projects

🧠 23. Why Set equality works differently?
    Set A = {1,2,3}
    Set B = {3,2,1}
    👉 A.equals(B) = true
    Because:
    👉 Order doesn’t matter

🔄 24. Can we clone a Set?
    Yes:
    Set<Integer> newSet = new HashSet<>(oldSet);

🧨 25. Hidden bug with mutable keys (MOST IMPORTANT)
    If object fields used in:
    equals()
    hashCode()

    change after insertion →
    👉 Entire Set becomes unreliable
```
# Java Set Interface – All Q&A
```
🧩 1. Fundamentals
What is Set?
    Set is an interface in the Java Collections Framework that stores unique elements only.

Does Set allow duplicates?
    ❌ No

Does Set maintain insertion order?
    HashSet → ❌ No
    LinkedHashSet → ✅ Yes
    TreeSet → ❌ (sorted instead)
    Is Set index-based?
        ❌ No
    Can we access elements using index?
    ❌ No

🧱 2. Hierarchy
Where does Set belong?
    Iterable → Collection → Set
Subinterfaces of Set?
    SortedSet
    NavigableSet

⚙️ 3. Implementations
Main implementations of Set:
    HashSet
    LinkedHashSet
    TreeSet
    EnumSet
    CopyOnWriteArraySet
    ConcurrentSkipListSet

Which Set is fastest?
    👉 HashSet (average case)

Which Set maintains insertion order?
    👉 LinkedHashSet

Which Set sorts elements?
    👉 TreeSet

🔄 4. Methods
Important methods in Set:
    add()
    remove()
    contains()
    size()
    isEmpty()
    clear()
    iterator()

What does add() return?
    true → element added
    false → duplicate

🚫 5. Duplicate Handling
How Set avoids duplicates?
    Using:
    hashCode()
    equals()

What if equals() is not overridden?
    👉 Duplicate objects may be stored

🧬 6. HashSet Deep Q&A
How does HashSet work?
    Internally uses HashMap:
    map.put(element, PRESENT);

Default capacity of HashSet?
    👉 16

Default load factor?
    👉 0.75

Time complexity:
    Add → O(1)
    Remove → O(1)
    Search → O(1)

Worst case?
    👉 O(n) (many collisions)

Can HashSet store null?
    ✅ Yes (only one)

🔗 7. LinkedHashSet Q&A
What is LinkedHashSet?
    HashSet + Linked List
Why use it?
    👉 Maintain insertion order
Performance compared to HashSet?
    👉 Slightly slower

🌳 8. TreeSet Q&A
What is TreeSet?
    Set that stores elements in sorted order

Internal structure?
    👉 Red-Black Tree

Time complexity?
    👉 O(log n)

Can TreeSet store null?
    ❌ No
    Why?
    Because comparison is required

🔢 9. Sorting Q&A
How TreeSet sorts elements?
    Comparable (default)
    Comparator (custom)

What happens if elements are not comparable?
    👉 Runtime error (ClassCastException)

🧠 10. Comparable vs Comparator
Feature	    Comparable	    Comparator
Method	    compareTo()	    compare()
Package	    java.lang	    java.util

🧵 11. Thread Safety
Is Set thread-safe?
    ❌ No (most implementations)

Thread-safe alternatives:
    Collections.synchronizedSet()
    CopyOnWriteArraySet
    ConcurrentSkipListSet

🔄 12. Iteration
    Ways to iterate:
    for-each loop
    Iterator
    Stream API

What is fail-fast?
    👉 Throws ConcurrentModificationException

⚡ 13. Performance
Which is faster?
    HashSet > LinkedHashSet > TreeSet

Why TreeSet is slow?
    👉 Tree operations (log n)

🧊 14. Immutable Set
How to create immutable Set?
    Set<Integer> set = Set.of(1,2,3);
    Properties:
    No modification
    No null
    No duplicates

🔍 15. Equality
When are two Sets equal?
    If:
    Same elements
    Order doesn’t matter

🔄 16. Conversion
Convert List to Set:
    Set<Integer> set = new HashSet<>(list);
Convert Set to List:
    List<Integer> list = new ArrayList<>(set);

🧰 17. Advanced Sets
EnumSet:
    Only for enums
    Very fast

CopyOnWriteArraySet:
    Thread-safe
    Slow writes
ConcurrentSkipListSet:
    Thread-safe
    Sorted

⚠️ 18. Edge Cases
Can Set contain mutable objects?
    ✅ Yes, but dangerous

What happens if object changes after insertion?
    👉 May not be found or removed

Can TreeSet drop elements silently?
    ✅ Yes if compareTo() returns 0

🧨 19. Common Mistakes
    Not overriding equals() & hashCode()
    Assuming order in HashSet
    Using null in TreeSet
    Modifying Set during iteration

🧠 20. Real-world Use Cases
    Removing Duplicates
    Unique IDs
    Caching
    Tag systems

🎯 21. Interview Tricky Questions
Why no get() method?
    👉 No index

Can Set contain heterogeneous elements?
    HashSet → ✅ Yes
    TreeSet → ❌ (needs comparable types)

Can we sort HashSet?
    👉 No (convert to List or use TreeSet)

Difference: Set vs List?
Feature	    Set	        List
Duplicates	❌	        ✅
Order	    Depends	    Yes

🔬 22. Internal Behavior (Important)
What is collision?
    👉 Same hashCode → same bucket

What is load factor?
    👉 Threshold for resizing

What is rehashing?
    👉 Increasing capacity and redistributing elements

💥 23. Java 8+ Features
Stream with Set:
    set.stream().filter(x -> x > 5).forEach(System.out::println);

🧾 FINAL SUMMARY

If you remember just this:
    Set = no duplicates
    HashSet = fast
    LinkedHashSet = ordered
    TreeSet = sorted
    equals() + hashCode() = critical
    Mutable objects = danger
    TreeSet = comparison-based uniqueness
```