```

jshell> String str = "in28Minutes"
str ==> "in28Minutes"

jshell> str.concat("is awesome");
$2 ==> "in28Minutesis awesome"

jshell> str
str ==> "in28Minutes"

jshell> String anotherString = str.concat(" is awesome");
anotherString ==> "in28Minutes is awesome"

jshell> str
str ==> "in28Minutes"

jshell> anotherString
anotherString ==> "in28Minutes is awesome"

jshell> String str2 = anotherString.concat(".");
str2 ==> "in28Minutes is awesome."

jshell> str
str ==> "in28Minutes"

jshell> anotherString
anotherString ==> "in28Minutes is awesome"

jshell> str2
str2 ==> "in28Minutes is awesome."

jshell> String str = "in28Minutes is awesome.      "
str ==> "in28Minutes is awesome.      "

jshell> str.trim()
$12 ==> "in28Minutes is awesome."

```