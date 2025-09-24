```
jshell> List value = List.of("A",'A',1,1.0)
value ==> [A, A, 1, 1.0]

jshell> value.get(2)
$2 ==> 1

jshell> value.get(2) instanceof Integer
$3 ==> true

jshell> List<String> textValues = List.of("A",'A',1,1.0);
|  Error:
|  incompatible types: inference variable E has incompatible bounds
|      equality constraints: java.lang.String
|      lower bounds: java.lang.Double,java.lang.Integer,java.lang.Character,java.lang.String
|  List<String> textValues = List.of("A",'A',1,1.0);
|                            ^--------------------^

jshell> List<Integer> numbers = List.of(101,102,103,104,105)
numbers ==> [101, 102, 103, 104, 105]

jshell> numbers.indexOf(103)
$5 ==> 2

jshell> List<Integer> numbersAl = new ArrayList<>(numbers);
numbersAl ==> [101, 102, 103, 104, 105]

jshell> numbersAl.indexOd(105);
|  Error:
|  cannot find symbol
|    symbol:   method indexOd(int)
|  numbersAl.indexOd(105);
|  ^---------------^

jshell> numbersAl.indexOf(105);
$7 ==> 4

jshell> numbersAl.remove(Integer.valueOf(101))
$8 ==> true

jshell> numbersAl
numbersAl ==> [102, 103, 104, 105]
```