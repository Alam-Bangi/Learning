```
List

List is an interface.
List is a part of java collections framework.

What are common implementations of List?
    ArrayList
    LinkedList
    Vector
    Stack

What are important methods of List?
Method	                Description
add(E e)	            Adds element
add(int index, E e)	    Insert at index
get(int index)	        Retrieve element
set(int index, E e)	    Replace element
remove(int index)	    Remove by index
remove(Object o)	    Remove by value
size()	                Number of elements
isEmpty()	            Check empty
contains(Object o)	    Search element
clear()	                Remove all

Difference between ArrayList and LinkedList?
Feature	        ArrayList	    LinkedList
Structure	    Dynamic array	Doubly linked list
Access	Fast    (O(1))	        Slow (O(n))
Insert/Delete	Slow	        Fast
Memory	        Less	        More

Is List synchronized?
    No, by default it is not synchronized.
To make list synchronized:
List list = Collections.synchronizedList(new ArrayList());

What is fail-fast behavior?
    Throws ConcurrentModificationException
    Happens when modifying list during iteration

What is ListIterator?
    Bidirectional iterator
    Allows modification during iteration

What is the difference between Iterator and ListIterator?
Feature	    Iterator	        ListIterator
Direction	Forward only	    Both
Modify	    Limited	            Full
Works on	All collections	    Only List

What is random access?
    Ability to access elements by index quickly.
    ArrayList → supports fast random access
    LinkedList → does not

What is CopyOnWriteArrayList?
    Thread-safe variant of ArrayList
    Used in concurrent environments

