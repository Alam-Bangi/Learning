```

jshell> int sum (int i, int j) {
   ...> return i+j;
   ...> }
|  created method sum(int,int)

jshell> sum(1,2)
$2 ==> 3

jshell> sum(1,2,3)
|  Error:
|  method sum in class  cannot be applied to given types;
|    required: int,int
|    found:    int,int,int
|    reason: actual and formal argument lists differ in length
|  sum(1,2,3)
|  ^-^

jshell> int sum (int i, int j,int k) {
   ...> return i+j+k;
   ...> }
|  created method sum(int,int,int)

jshell> sum(1,2,3)
$4 ==> 6

jshell> void print(int... values) {
   ...>     System.out.println(Arrays.toString(values));
   ...> }
|  created method print(int...)

jshell> print[1]
|  Error:
|  cannot find symbol
|    symbol:   variable print
|  print[1]
|  ^---^

jshell> print(1)
[1]

jshell> print(1,2,3)
[1, 2, 3]

jshell> int sum(int... values) {
   ...>     int sum =0;
   ...>     for(int value:values) {
   ...>         sum+=value;
   ...>     }
   ...>     return sum;
   ...> }
|  created method sum(int...)

jshell> sum(1,2)
$9 ==> 3

jshell> sum(1,2,3,4)
$10 ==> 10

jshell> sum(1,2,3,4,5,6,7,8,9,10)
$11 ==> 55


