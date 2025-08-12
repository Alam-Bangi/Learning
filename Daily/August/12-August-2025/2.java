 int sum(int i, int j, int k) {
   ...>     return i+j+k;
   ...> }
|  created method sum(int,int,int)

jshell> sum(2,10,100
   ...> )
$2 ==> 112

jshell>

jshell> void print(int... values) {
   ...>     System.out.println(Arrays.toString(values));
   ...> }
|  created method print(int...)

jshell> print(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

jshell> int sum(int... values) {
   ...>     int sum=0;
   ...>     for(int value:values) {
   ...>         sum+=value;
   ...>     }
   ...>     return sum;
   ...> }
|  created method sum(int...)

jshell> sum(10, 8, 6, 4, 2)
$6 ==> 30