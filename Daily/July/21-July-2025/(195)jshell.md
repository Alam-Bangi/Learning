```

jshell> for (int i =1; i<=10; i++) {
   ...>     if (i==5)
   ...>     break;
   ...>     System.out.println(i + " ");
   ...> }
1
2
3
4

jshell> for (int i =1; i<=10; i++) {
   ...>     if (i%2==0)
   ...>     break;
   ...>     System.out.println(i + " ");
   ...> }
1

jshell> for (int i =1; i<=10; i++) {
   ...>     if (i%2==0)
   ...>     continue;
   ...>     System.out.println(i + " ");
   ...> }
1
3
5
7
9

jshell> for (int i =1; i<=10; i++) {
   ...>     if (i%2!=0)
   ...>     continue;
   ...>     System.out.println(i + " ");
   ...> }
2
4
6
8
10

```