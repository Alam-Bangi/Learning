```

jshell> while (i<5) {
   ...>     System.out.println(i);
   ...> i++;
   ...> }

jshell> i
i ==> 5

jshell> do {
   ...>     System.out.println(i + " ");
   ...>     i++;
   ...> } while (i<5)
5

jshell> do {
   ...>     System.out.println(i + " ");
   ...>     i++;
   ...> } while (i<5)
6

jshell> i=1;
i ==> 1

jshell> do {
   ...>     System.out.println(i + " ");
   ...>     i++;
   ...> } while (i<5)
1
2
3
4

```