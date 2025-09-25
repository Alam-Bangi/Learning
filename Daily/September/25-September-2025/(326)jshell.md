```
jshell> TreeSet<Integer> numbers = new TreeSet<>(Set.of(65,54,43,21,99));
numbers ==> [21, 43, 54, 65, 99]

jshell> numbers
numbers ==> [21, 43, 54, 65, 99]

jshell> numbers.floor(43)
$3 ==> 43

jshell> numbers.floor(40)
$4 ==> 21

jshell> numbers.ceiling(43)
$5 ==> 43

jshell> numbers.ceiling(44)
$6 ==> 54

jshell> numbers.lower(43)
$7 ==> 21

jshell> numbers.lower(40)
$8 ==> 21

jshell> numbers.higher(43)
$9 ==> 54

jshell> numbers.higher(99)
$10 ==> null

jshell> numbers.lower(21)
$11 ==> null

jshell> numbers.ceiling(21)
$12 ==> 21

jshell> numbers.floor(21)
$13 ==> 21

jshell> numbers.floor(20)
$14 ==> null

jshell> numbers.ceiling(101)
$15 ==> null

jshell> numbers.higher(101)
$16 ==> null

jshell> numbers.lower(20)
$17 ==> null

jshell> numbers.subSet(21,101)
$18 ==> [21, 43, 54, 65, 99]

jshell> numbers.subSet(22,101)
$19 ==> [43, 54, 65, 99]

jshell> numbers.subSet(22,99)
$20 ==> [43, 54, 65]

jshell> numbers.subSet(21,false,98,true)
$21 ==> [43, 54, 65]

jshell> numbers.subSet(21,false,99,true)
$22 ==> [43, 54, 65, 99]

jshell> numbers.headSet(21)
$23 ==> []

jshell> numbers.headSet(22)
$24 ==> [21]

jshell> numbers.headSet(99)
$25 ==> [21, 43, 54, 65]

jshell> numbers.headSet(101)
$26 ==> [21, 43, 54, 65, 99]

jshell> numbers.tailSet(21)
$27 ==> [21, 43, 54, 65, 99]

jshell> numbers.tailSet(101)
$28 ==> []

jshell> numbers.tailSet(99)
$29 ==> [99]
```