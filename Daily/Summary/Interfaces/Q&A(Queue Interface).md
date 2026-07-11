```
🔹 1. What really is Queue in Java?
Queue is part of the Java Collections Framework and represents a collection designed for holding elements prior to processing.
    But here’s the catch:
        It’s not always FIFO (First-In-First-Out)
        Some implementations break that assumption
    👉 Example:
        PriorityQueue → orders by priority, not insertion order
        ArrayDeque → FIFO (if used as queue)

🔹 2. Why does Queue have two versions of every method?
    This is one of the most underrated design decisions.

Operation	    Throws Exception	Returns Special Value
Insert	        add()	            offer() → false
Remove	        remove()	        poll() → null
Peek	        element()	        peek() → null

👉 Hidden insight:
    This exists because some queues are capacity-restricted (like bounded queues)
    Exception-based vs graceful failure gives flexibility
💡 Interview twist:
    “When would offer() fail but add() succeed?”
    Answer:
    In bounded queues → offer() returns false, add() throws exception

🔹 3. Why does Queue allow null in some implementations but not others?
    This confuses even experienced devs.
    👉 Key idea:
        Methods like poll() return null when empty
        If queue allows null, ambiguity happens
        So:
        LinkedList → allows null
        ArrayDeque → does NOT allow null
    💥 Real-world implication:
        Never rely on null as data in queues unless you’re sure of implementation.

🔹 4. Why is PriorityQueue NOT stable?
    👉 Meaning:
        If two elements have equal priority, order is not guaranteed
        Example:
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(10);
    👉 Output order = unpredictable
    💡 Hidden fix:
        Use wrapper:
        class Node {
            int value;
            long timestamp;
        }

🔹 5. Why is ArrayDeque faster than LinkedList as a queue?
    Most people say “because arrays are faster” — that’s incomplete.
    👉 Real reasons:
        Better CPU cache locality
        No object pointer overhead
        No node allocation per insert

    💥 Conclusion:
        Use ArrayDeque instead of LinkedList unless you need:
        frequent middle insertions (rare in queues)

🔹 6. Why is Queue NOT thread-safe?
    Because:
    It’s a basic contract, not an implementation
    Thread-safe variants:
    ConcurrentLinkedQueue
    ArrayBlockingQueue

🔹 7. What is a BlockingQueue and why it matters?
    From java.util.concurrent
    👉 Key behavior:
        take() → waits if empty
        put() → waits if full
    💡 Used in:
        Producer-consumer systems
        Thread pools

🔹 8. Why does Queue extend Collection but NOT List?
    Because:
        Queue has ordering rules, not index-based access
    👉 No:
        queue.get(2); // ❌ not allowed

🔹 9. What happens if you iterate and modify a Queue?
    Depends:
        Most implementations → fail-fast
        Throw ConcurrentModificationException
    Example:
        for (Integer i : queue) {
            queue.remove(i); // ❌ boom
        }

🔹 10. Why is Deque more important than Queue?
    Because:
        It supports both ends (double-ended)
    👉 In real systems:
        Most “queue” use cases → actually better with:
        Deque

🔹 11. Why is LinkedList a bad default queue?
    Even though it implements Queue:
        High memory overhead
        Poor cache performance
        Slower in practice than ArrayDeque

🔹 12. What’s the biggest hidden bug with Queue?
    👉 Mixing up:
        remove() vs poll()

    💥 Scenario:
        queue.remove(); // throws exception if empty
        queue.poll();   // returns null
        This causes:
        production crashes vs silent bugs

🔹 13. Can a Queue be infinite?
    Yes:
        ConcurrentLinkedQueue → unbounded
    But:
        Memory is your real limit

🔹 14. Why is PriorityQueue implemented as a heap?
    Because:
        Insert → O(log n)
        Remove → O(log n)
        Peek → O(1)
    👉 Tradeoff:
        Not sorted fully
        Only top element guaranteed

🔹 15. When should you NEVER use Queue?
    ❌ Bad fits:
        Random access needed
        Frequent sorting
        Indexed operations

🔹 16. Real interview trap question
    “Is Queue always FIFO?”
    Correct answer:
    👉 No
    Explain:
        PriorityQueue → priority-based
        Deque → can be FIFO or LIFO

🔹 17. Advanced trick: Queue as BFS engine
    Used in:
        Graph traversal
        Shortest path (unweighted)
        Queue<Integer> q = new ArrayDeque<>();

🔹 18. Hidden performance killer
    Queue<Integer> q = new LinkedList<>();
    👉 Looks fine, but:
        Causes GC pressure
        Slower under load
    👉 Better:
        Queue<Integer> q = new ArrayDeque<>();

🔹 19. Why offer() is preferred in production
    Because:
        Safer (no exceptions)
        Better for distributed systems / queues

🔹 20. One-liner to remember everything
    👉 “Queue is not about order — it’s about policy.”
```