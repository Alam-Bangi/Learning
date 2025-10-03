```
jshell> Math.max(10,5)
$13 ==> 10

jshell> /list sum

   9 : void sum(int i, int j) {
           int sum = i + j;
           System.out.println(sum);
       }
  11 : void sum(int i, int j, int k) {
           int sum = i + j + k;
           System.out.println(sum);
       }

jshell> int sumOfTwoNumbers(int number1, int number2) {
   ...>     int sum = number1 + number2;
   ...>     return sum;
   ...> }
|  created method sumOfTwoNumbers(int,int)

jshell> sumOfTwoNumbers(5,7)
$15 ==> 12

jshell> int sum = sumOfTwoNumbers(10,20);
sum ==> 30
```