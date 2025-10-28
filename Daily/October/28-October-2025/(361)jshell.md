```
jshell> List.of(23,12,34,53).stream().min((n1,n2)->Integer.compare(n1
,  ))
$1 ==> Optional[12]

jshell> List.of(23,12,34,53).stream().min((n1,n2)->Integer.compare(n1,n2)).get()
$2 ==> 12

jshell> List.of(23,12,34,53).stream().filter(e->e%2==1).forEach(e->Sy
s         rintln(e))
23
53

jshell> List.of(23,12,34,53).stream().filter(e->e%2==1).collect(Colle
ctors.toList())
$4 ==> [23, 53]

jshell> List.of(23,12,34,53).stream().filter(e->e%2==0).collect(Colle
c ors.toList())
$5 ==> [12, 34]

jshell> IntStream.range(1,11).map(e -> e*e).boxed().collect(Collector
s toList())
$6 ==> [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
```