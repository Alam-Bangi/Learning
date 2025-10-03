```

jshell> char ch = a
|  Error:
|  cannot find symbol
|    symbol:   variable a
|  char ch = a;
|            ^

jshell> char ch = 'a'
ch ==> 'a'

jshell> char ch = 'ab'
|  Error:
|  unclosed character literal
|  char ch = 'ab'
|            ^

jshell> char ch = ' " '
|  Error:
|  unclosed character literal
|  char ch = ' " '
|            ^

jshell> char ch1 = '\u0022'
ch1 ==> '"'

jshell> char ch1 = '\u00A2'
ch1 ==> '¢'

jshell> char ch = 65
ch ==> 'A'

jshell> ch
ch ==> 'A'

jshell> ch++
$83 ==> 'A'

jshell> ch
ch ==> 'B'

jshell>

jshell>

jshell>

jshell> ++ch
$85 ==> 'C'

jshell> ++ch
$86 ==> 'D'

jshell> ch + 5
$87 ==> 73

jshell> (int) ch
$88 ==> 68

jshell> char ch = '\n'
ch ==> '\n'

jshell> System.out.println(ch);



jshell> char ch = '\t'
ch ==> '\t'

jshell> System.out.println(ch);


```