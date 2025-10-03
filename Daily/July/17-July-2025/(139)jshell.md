```

jshell> int eight = 010;
eight ==> 8

jshell> int sixteen = 0x10;
sixteen ==> 16

jshell> int eight = 099;
|  Error:
|  ';' expected
|  int eight = 099;
|               ^

jshell> int eight = 08;
|  Error:
|  ';' expected
|  int eight = 08;
|               ^

jshell> int big = 0XBBAACC;
big ==> 12298956

jshell> byte b = 128
|  Error:
|  incompatible types: possible lossy conversion from int to byte
|  byte b = 128;
|           ^-^

jshell> short s = 123456
|  Error:
|  incompatible types: possible lossy conversion from int to short
|  short s = 123456;
|            ^----^

jshell> int i = 3456
i ==> 3456

jshell> short s =i
|  Error:
|  incompatible types: possible lossy conversion from int to short
|  short s =i;

jshell> int i = 10;
i ==> 10

jshell> int j = i++;
j ==> 10

jshell> i
i ==> 11

jshell> int i = 10;
i ==> 10

jshell> int j = ++i;
j ==> 11

jshell> i
i ==> 11

jshell> int j = i--;
j ==> 11

jshell> i
i ==> 10

jshell> int j = --i;
j ==> 9

jshell> i
i ==> 9

```