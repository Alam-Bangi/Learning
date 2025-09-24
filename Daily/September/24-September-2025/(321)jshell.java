jshell> Set<String> set = Set.of("Apple","Bat","Cat");
set ==> [Bat, Cat, Apple]

jshell> Set<String> set = Set.of("Apple","Banana","Cat");
set ==> [Cat, Apple, Banana]

jshell> Set<String> hashset = new HashSet<>(set);
hashset ==> [Apple, Cat, Banana]

jshell> hashset.add("Apple")
$9 ==> false

jshell> hashset
hashset ==> [Apple, Cat, Banana]

jshell> hashset.add(2,"Apple")
|  Error:
|  method add in interface java.util.Set<E> cannot be applied to given types;
|    required: java.lang.String
|    found:    int,java.lang.String
|    reason: actual and formal argument lists differ in length
|  hashset.add(2,"Apple")