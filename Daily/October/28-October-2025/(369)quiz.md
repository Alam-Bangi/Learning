```
Question 1:
What is the purpose of the filter() method?
- To filter the elements of a stream based on a predicate.

Question 2:
What is a functional interface in Java?
- An interface that contains only one abstract method.
- An interface that can be implemented using a lambda expresiion.
- An interface that can be used to represent a function.

Question 3:
What is the output of the following code?
List<Integer> list = List.of(1, 4, 7, 9);
list.stream().filter(num -> num%2 == 1).forEach(elem -> System.out.println(elem));
- 1,7,9

Question 4:
How would you filter the list of numbers to contain only even numbers?
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
- numbers.stream().filter(num -> num%2 == 0)

Question 5:
How is a lambda expression different from a regular method?
- Lambda expressions are anonymous, while regular have names
- They are concise, while regular methods can have multiple lines of code
- They are type-inferred, while regular methods must explicitly specify their types

Question 6:
What is the purpose of the reduce() method in functional programming?
- To reduce elements of stream to single value

Question 7:
What is the output of the following code?
List<Integer> numbers = List.of(4, 6, 8, 13, 3, 15);
int sum = numbers.stream()
                 .reduce(0, (num1, num2) -> num1 + num2);
System.out.println(sum);
- 49

Question 8:
What is the purpose of the distinct() method in stream operations?
- To remove duplicates from a stream

Question 9:
What does the Optional<T> class represent in stream operations?
- A container object that may or may not contain a value
- A way to represent null values in a stream
- A way to avoid NullPointerExceptions in stream operations

Question 10:
What is the purpose of the map() operation in stream operations?
- To apply a function to each elements in stream and produce a new stream with results

Question 11:
What are intermediate operations and terminal operations in streams?
- Intermediate operations return new stream while terminal operations produce a result or side-effect
- Intermediate operations can be chained together while terminal operations cannot be chained together
```