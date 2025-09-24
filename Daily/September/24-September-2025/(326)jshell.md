```
jshell> TreeSet<Integer> numbers = new TreeSet<>(Set.of(65,54,43,21,99));
numbers ==> [21, 43, 54, 65, 99]

jshell> numbers.floor(40)
$36 ==> 21

jshell> numbers.lower(43)
$37 ==> 21

jshell> numbers.ceiling(65)
$38 ==> 65

jshell> numbers.ceiling(66)
$39 ==> 99

jshell> numbers.higher(43)
$40 ==> 54

jshell> numbers
numbers ==> [21, 43, 54, 65, 99]

jshell> numbers.subSet(20,80)
$42 ==> [21, 43, 54, 65]

jshell>  numbers.subSet(20, true, 99,true)
$43 ==> [21, 43, 54, 65, 99]

jshell> numbers.headSet(50)
$44 ==> [21, 43]

jshell> numbers.tailSet(50)
$45 ==> [54, 65, 99]

jshell> numbers.tailSet(54)
$46 ==> [54, 65, 99]

jshell> numbers.headSet(43)
$47 ==> [21]
```