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
```