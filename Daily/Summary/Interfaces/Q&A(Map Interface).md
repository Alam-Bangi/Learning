```
1. HashMap Edge Cases Most People Ignore

❓ What happens if all keys have the same hashCode?
    You basically destroy the performance of HashMap.
    All entries go into one bucket
    Time complexity becomes O(n) instead of O(1)
    Java 8+ improves this using treeification (Red-Black Tree) after threshold

👉 Hidden detail:
    Treeification happens only if bucket size > 8 AND capacity ≥ 64
    Otherwise, it resizes instead.

❓ Can resizing break your logic?
    Yes — if you're doing unsafe concurrent operations.
    During resize:
    Internal structure changes
    In older Java (pre-8), could cause infinite loop (dead cycle)

🧠 2. Mutable Key Nightmare

❓ What happens if key is mutable?
    class Key {
        int id;
    }
    Insert with id = 1
    Change id = 2
    Now map.get(key) returns null
    👉 Why?
    Because hashCode changed → bucket mismatch
🔥 This is a real production bug category

🧠 3. Equals vs HashCode Trap

❓ What if equals() is correct but hashCode() is not?
    Map may store duplicates
    Retrieval fails
    👉 Rule:
    If equals() is overridden → hashCode() MUST be overridden

❓ Can two unequal objects have same hashCode?
    Yes — called collision

🧠 4. Treeification Secrets (Java 8+)

❓ When does HashMap become a tree?
    Bucket size ≥ 8 → convert to tree
    Bucket size ≤ 6 → convert back to linked list
    👉 This hysteresis avoids frequent switching

❓ Why Red-Black Tree?
    Because it guarantees O(log n)
    Used internally in:
    TreeMap
    HashMap (after collisions)

🧠 5. Null Handling Deep Truth

❓ Why does HashMap allow only ONE null key?
    Because:
    Null key always goes to bucket 0
    Multiple null keys would violate uniqueness

❓ Why TreeMap doesn’t allow null key?
    Because it uses comparison (compareTo)
    Null cannot be compared → NullPointerException

🧠 6. Iteration Internals

❓ Why does ConcurrentModificationException happen?
    Because iterators are fail-fast
    They track:
    modCount
    If structure changes → boom 💥 exception

❓ Is fail-fast guaranteed?
    No ❗
    It’s best-effort, not guaranteed.

🧠 7. LinkedHashMap Hidden Power

❓ Why LinkedHashMap is secretly powerful?
    LinkedHashMap can act as:
    👉 LRU Cache
    new LinkedHashMap<>(16, 0.75f, true);
    Override:
    removeEldestEntry()

🧠 8. IdentityHashMap Weirdness

❓ What makes IdentityHashMap dangerous?
    Uses == instead of .equals()
    👉 Two equal strings may behave differently:
    map.put(new String("A"), 1);
    map.put(new String("A"), 2);
    ➡️ Stores BOTH entries

🧠 9. Concurrency Reality

❓ Why HashMap is unsafe in multithreading?
    Race conditions
    Lost updates
    Corrupt structure

❓ Why not use Hashtable?
    Hashtable:
    Entire map locked
    Poor scalability

❓ What makes ConcurrentHashMap special?
    Segment-based locking (Java 7)
    CAS + synchronized (Java 8+)
    No full locking

🧠 10. Memory-Level Details

❓ What is a Node in HashMap?
    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
    }

❓ Why capacity is always power of 2?
    Because:
    index = (n - 1) & hash
    👉 Faster than modulo %

🧠 11. Ordering Myths

❓ Is HashMap random?
    No ❗
    It’s deterministic
    Depends on:
    hashCode
    capacity
    insertion order (indirectly)

🧠 12. Hidden Performance Killers

❓ What kills HashMap performance?
    Bad hashCode()
    High collision rate
    Frequent resizing
    Large load factor

🧠 13. Serialization Trap

❓ What happens when HashMap is serialized?
    Structure is NOT saved
    Only key-value pairs
    👉 On deserialization:
    Rebuilt from scratch

🧠 14. Compute() Dangerous Case

❓ Can compute() cause infinite loop?
    Yes — if you modify map inside compute

🧠 15. Interview Trap Questions

❓ Why initial capacity 16?
    Power of 2 optimization

❓ Why load factor 0.75?
    Best balance:
    Memory vs performance

❓ Can HashMap size exceed Integer.MAX_VALUE?
    Technically no (practically impossible)

🧠 16. Real-World Bugs

❓ Most common production bugs?
    Mutable keys
    Wrong equals/hashCode
    Using HashMap in threads
    Memory leaks (large maps not cleared)

🧠 17. Rarely Known Fact

❓ HashMap iteration order changed after Java 8?
    Yes — due to treeification
    👉 Some legacy code broke because it relied on order (bad practice)

🧠 18. Micro Optimization Trick

❓ Faster than containsKey + get?
    map.get(key) != null
    BUT ❗ fails if value can be null

🧠 19. Functional Programming Trap

❓ merge vs compute difference?
    merge → simpler for accumulation
    compute → more control

🧠 20. One Question That Destroys Interviews

❓ Why is HashMap fast?
    Not just hashing — it’s:
    Bitwise operations
    Power-of-two sizing
    Tree fallback
    Cache-friendly structure

🔥 Final Reality Check
    Most developers:
        Know syntax
        Don’t know internals

    Strong developers:
        Understand why things break
```