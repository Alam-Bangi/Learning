```

jshell> someString.length()
$35 ==> 27

jshell> someString.charAt(5)
$36 ==> 'i'

jshell> for(int i = 0; i<someString.length(); i++) {
   ...>     System.out.println(someString.charAt(i));
   ...> }
T
h
i
s

i
s

a

l
o
t

o
f

t
e
x
t

a
g
a
i
n

jshell> someString.indexOf("lot");
$38 ==> 10

jshell> someString.indexOf("i");
$39 ==> 2

jshell> someString.indexOf("i");
$40 ==> 2

jshell> someString.lastIndexOf("i");
$41 ==> 25

jshell> someString.startsWiith("This");
|  Error:
|  cannot find symbol
|    symbol:   method startsWiith(java.lang.String)
|  someString.startsWiith("This");
|  ^--------------------^

jshell> someString.startsWith("This");
$42 ==> true

jshell> someString.endsWith("again");
$43 ==> true

jshell> someString.endsWith("abcdefgh");
$44 ==> false

jshell> someString.isEmpty()
$45 ==> false

jshell> "".isEmpty()
$46 ==> true

jshell> "value".equals("value")
$47 ==> true

jshell> String str = "value"
str ==> "value"

jshell> str.equals("value")
$49 ==> true

jshell> str.equalsIgnoreCase("ValUe")
$50 ==> true


```