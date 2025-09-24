```
jshell> Set<Integer> numbers = new HashSet<>();
numbers ==> []

jshell> numbers.add(765432);
$14 ==> true

jshell> numbers.add(76543);
$15 ==> true

jshell> numbers.add(7654);
$16 ==> true

jshell> numbers.add(765);
$17 ==> true

jshell> numbers.add(76);
$18 ==> true

jshell> numbers
numbers ==> [765432, 7654, 76, 765, 76543]

jshell> Set<Integer> numbers = new LinkedHashSet<>();
numbers ==> []

jshell> numbers.add(765432);
$21 ==> true

jshell> numbers.add(76543);
$22 ==> true

jshell> numbers.add(7654);
$23 ==> true

jshell> numbers.add(765);
$24 ==> true

jshell> numbers.add(76);
$25 ==> true

jshell> numbers
numbers ==> [765432, 76543, 7654, 765, 76]

jshell> Set<Integer> numbers = new TreeSet<>();
numbers ==> []

jshell> numbers.add(765432);
$28 ==> true

jshell> numbers.add(76543);
$29 ==> true

jshell> numbers.add(7654);
$30 ==> true

jshell> numbers.add(765);
$31 ==> true

jshell> numbers.add(76);
$32 ==> true

jshell> numbers
numbers ==> [76, 765, 7654, 76543, 765432]

jshell> List<Character> characters = List.of('A','Z','A','B','Z','F');
characters ==> [A, Z, A, B, Z, F]
```