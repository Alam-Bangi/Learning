```
jshell> IntStream.range(1,11).reduce(0,(n1,n2)->n1+n2);
$12 ==> 55

jshell> List.of(23,12,34,53).stream().max((n1,n2)->Integer.compare(n
1 n2))
$13 ==> Optional[53]

jshell> List.of(23,12,34,53).stream().max((n1,n2)->Integer.compare(n1,n2)).get()
$14 ==> 53
```