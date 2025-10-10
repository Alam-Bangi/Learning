```

jshell> for ( int i =0; i<=10 ; i++) {
   ...>     System.out.print(i + " "):
   ...> }
|  Error:
|  ';' expected
|      System.out.print(i + " "):
|                               ^

jshell> for ( int i =0; i<=10 ; i++) {
   ...>     System.out.print(i + " ");
   ...> }
0 1 2 3 4 5 6 7 8 9 10
jshell> for ( int i =0; i<=10 ; i+=2) {
   ...>     System.out.print(i + " ");
   ...> }
0 2 4 6 8 10
jshell> for ( int i =1 ; i<=10 ; i+=2) {
   ...>     System.out.print(i + " ");
   ...> }
1 3 5 7 9

jshell> for ( int i =11 ; i<=20 ; ) {
   ...>     System.out.print(i + " ");
   ...>     i++;
   ...> }
11 12 13 14 15 16 17 18 19 20

```