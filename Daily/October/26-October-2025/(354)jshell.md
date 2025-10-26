```

jshell> List<Integer> list = List.of(1,4,7,9);
list ==> [1, 4, 7, 9]

jshell> list.stream().forEach(element->System.out.println(element
));
1
4
7
9

jshell> list.stream().filter(element->element%2==1).forEach(eleme
nt->System.out.println(element));
1
7
9

jshell> list.stream().filter(element->element%2==0).forEach(eleme
nt->System.out.println(element));
4

```