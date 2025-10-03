```
jshell> int i =5
i ==> 5

jshell> i>5
$56 ==> false

jshell> i == 5
$57 ==> true

jshell> i == 6
$58 ==> false

jshell> if ( i==5 )
   ...> System.out.println("i is odd");
i is odd

jshell> if ( i==5 )
   ...> System.out.println("i is odd"); System.out.println("
i is prime");
i is odd
i is prime

jshell> if ( i==5 ) {
   ...> System.out.println("i is odd");
   ...>      System.out.println("i is prime");
   ...> }
i is odd
i is prime

jshell> int number = 5;
number ==> 5

jshell> for ( int i = 1; i<=10; i++) {
   ...>     System.out.printf("%d * %d = %d",number, i , num
ber*i).println();
   ...> }
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
5 * 4 = 20
5 * 5 = 25
5 * 6 = 30
5 * 7 = 35
5 * 8 = 40
5 * 9 = 45
5 * 10 = 50
```