```

jshell> List<Integer> numbers = List.of(3,5,8,213,45,4,7);
numbers ==> [3, 5, 8, 213, 45, 4, 7]

jshell> numbers.stream().sorted().forEach(e -> System.out.println(e));
3
4
5
7
8
45
213

jshell> List<Integer> numbers = List.of(3,5,8,213,45,4,7,4,5);
numbers ==> [3, 5, 8, 213, 45, 4, 7, 4, 5]

jshell> numbers.stream().distinct().forEach(e -> System.out.println(e));
3
5
8
213
45
4
7

jshell> numbers.stream().distinct().sorted().forEach(e -> System.out.println(e));
3
4
5
7
8
45
213

jshell> numbers.stream().distinct().map(e -> e*e).forEach(e -> Syste
m           n(e));
9
25
64
45369
2025
16
49

```