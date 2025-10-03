```
jshell> int table = 9
table ==> 9

jshell> for ( int i = 1; i<=10; i++) {
   ...>     System.out.printf("%d * %d = %d",table, i , table*i).println();
   ...> }
9 * 1 = 9
9 * 2 = 18
9 * 3 = 27
9 * 4 = 36
9 * 5 = 45
9 * 6 = 54
9 * 7 = 63
9 * 8 = 72
9 * 9 = 81
9 * 10 = 90

jshell> for ( int i = 1; i<=10; i++) {
   ...>     System.out.printf("%d",i*i).println();
   ...> }
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

jshell> for ( int i = 9; i>0; i=i-2) {
   ...>     System.out.println(i);
   ...> }
9
7
5
3
1

jshell> for ( int i = 10; i>0; i=i-2) {
   ...>     System.out.println(i);
   ...> }
10
8
6
4
2

jshell> for ( int i =2; i<=10; i=i+2) {
   ...>     System.out.printf("%d",i*i).println();
   ...> }
4
16
36
64
100
```