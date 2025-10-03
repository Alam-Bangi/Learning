```
jshell> Byte.SIZE
$1 ==> 8

jshell> Byte.BYTES
$2 ==> 1

jshell> Byte.MAX_VALUE
$3 ==> 127

jshell> Byte.MIN_VALUE
$4 ==> -128

jshell> Short.BYTES
$5 ==> 2

jshell> Integer.BYTES
$6 ==> 4

jshell> Integer.MAX_VALUE
$7 ==> 2147483647

jshell> int i = 100000;
i ==> 100000

jshell> long l = 500000000l;
l ==> 500000000

jshell> i = l
|  Error:
|  incompatible types: possible lossy conversion from long to int
|  i = l
|      ^

jshell> i = (int) l
i ==> 500000000

```