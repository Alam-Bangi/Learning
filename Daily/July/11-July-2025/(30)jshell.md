```
jshell> int a =10;
a ==> 10

jshell> int b = 20;
b ==> 20

jshell> int c = 30;
c ==> 30

jshell> System.out.printf("a+b+c = a+b+c").println
|  Error:
|  cannot find symbol
|    symbol:   variable println
|  System.out.printf("a+b+c = a+b+c").println
|  ^----------------------------------------^

jshell> System.out.printf("a+b+c = a+b+c").println()
a+b+c = a+b+c

jshell> System.out.printf("%d + %d + %d = %d ",a,b,c, a+b+c).println()
10 + 20 + 30 = 60

jshell> a = 50
a ==> 50

jshell> System.out.printf("%d + %d + %d = %d ",a,b,c, a+b+c).println()
50 + 20 + 30 = 100

jshell> b = 60
b ==> 60

jshell> System.out.printf("%d + %d + %d = %d ",a,b,c, a+b+c).println()
50 + 60 + 30 = 140

jshell> int newVariable
newVariable ==> 0

jshell> newVariable
newVariable ==> 0

jshell> int undeclaredVariable
undeclaredVariable ==> 0

jshell> 5 * undeclaredVariable
$71 ==> 0

jshell> int number = 5.5
|  Error:
|  incompatible types: possible lossy conversion from double to int
|  int number = 5.5;
|               ^-^

jshell> int number = "String"
|  Error:
|  incompatible types: java.lang.String cannot be converted to int
|  int number = "String";
|               ^------^

jshell> int number = 5
number ==> 5

jshell> int number2 = number
number2 ==> 5
```