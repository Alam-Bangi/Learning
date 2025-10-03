```
jshell> void sum(int i, int j) {
   ...>     int sum = i + j;
   ...>     System.out.println(sum);
   ...> }
|  created method sum(int,int)

jshell> sum(10,20);
30

jshell> sum(10,20,30);
|  Error:
|  method sum in class  cannot be applied to given types;
|    required: int,int
|    found:    int,int,int
|    reason: actual and formal argument lists differ in length
|  sum(10,20,30);
|  ^-^

jshell> void sum(int i, int j, int k) {
   ...>     int sum = i + j + k;
   ...>     System.out.println(sum);
   ...> }
|  created method sum(int,int,int)

jshell> sum(10,20,30);
60

```