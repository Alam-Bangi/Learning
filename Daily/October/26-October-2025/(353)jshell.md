```

jshell> List<Integer> list = List.of(1,4,7,9);
list ==> [1, 4, 7, 9]

jshell> list.stream().forEach(element->System.out.println(element
));
1
4
7
9

```