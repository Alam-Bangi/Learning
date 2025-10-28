```
jshell> List.of(23,45,67,12).stream().filter(n -> n%2==0).max((n1,n2)
 -> Integer.compare(n1,n2))
$1 ==> Optional[12]

jshell> List.of(23,45,67).stream().filter(n -> n%2==0).max((n1,n2) ->
 Integer.compare(n1,n2))
$2 ==> Optional.empty

jshell> List.of(23,45,67).stream().filter(n -> n%2==0).max((n1,n2) -> Integer.compare(n1,n2)).orElse(0)
$3 ==> 0

jshell> List.of(23,45,67,12).stream().filter(n -> n%2==0).max((n1,n2) -> Integer.compare(n1,n2)).orElse(0)
$4 ==> 12
```