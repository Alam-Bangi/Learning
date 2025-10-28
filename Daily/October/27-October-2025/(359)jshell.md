```

jshell> IntStream.range(1,10).forEach(p->System.out.println(p));
1
2
3
4
5
6
7
8
9

jshell> IntStream.range(1,11).forEach(p->System.out.println(p));
1
2
3
4
5
6
7
8
9
10

jshell> IntStream.range(1,11).map(e->e*e).forEach(p->System.out.prin
t     );
1
4
9
16
25
36
49
64
81
100

jshell> List.of("Apple","Ant","Bat").stream().map(s->s.toLowerCase()
).  rEach(p->System.out.println(p));
apple
ant
bat

jshell> List.of("Apple","Ant","Bat").stream().map(s->s.length()).for
E      >System.out.println(p));
5
3
3

```