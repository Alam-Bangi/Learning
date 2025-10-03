```
jshell> int a =1
a ==> 1

jshell> int b=2
b ==> 2

jshell> intc=3
|  Error:
|  cannot find symbol
|    symbol:   variable intc
|  intc=3
|  ^--^

jshell> int d=4
d ==> 4

jshell> int c=3
c ==> 3

jshell> if(a+b > c+d)
   ...> System.out.println("a+b is greater than c+d");

jshell> a =6
a ==> 6

jshell> if(a+b > c+d)
   ...> System.out.println("a+b is greater than c+d");
a+b is greater than c+d

jshell> int angle1 = 20
angle1 ==> 20

jshell> int angle2 = 60
angle2 ==> 60

jshell> int angle3 = 50
angle3 ==> 50

jshell> if(angle1 + angle2 + angle3 == 180)
   ...> System.out.println("Valid Triangle");

jshell> angle3 = 100
angle3 ==> 100

jshell> if(angle1 + angle2 + angle3 == 180)
   ...> System.out.println("Valid Triangle");
Valid Triangle

jshell> int number = 10
number ==> 10

jshell> number%2
$50 ==> 0

jshell> 9%2
$51 ==> 1

jshell> if(number%2 == 0)
   ...> System.out.println("number is even");
number is even

jshell> number = 9
number ==> 9

jshell> if(number%2 == 0)
   ...> System.out.println("number is even");
```