```
jshell> boolean isEven = false
isEven ==> false

jshell> int i = 5;
i ==> 5

jshell> if (i%2==0) {
   ...>     isEven = true;
   ...> } else {
   ...>     isEven = false;
   ...> }

jshell> isEven
isEven ==> false

jshell> i = 6;
i ==> 6

jshell> if (i%2==0) {
   ...>     isEven = true;
   ...> } else {
   ...>     isEven = false;
   ...> }

jshell> isEven
isEven ==> true

jshell> isEven = (i%2==0 ? true : false)
isEven ==> true

jshell> i =7;
i ==> 7

jshell> isEven = (i%2==0 ? true : false)
isEven ==> false

jshell> String even = (i % 2==0 ? "YES" : "NO")
even ==> "NO"

jshell> i = 6;
i ==> 6

jshell> String even = (i % 2==0 ? "YES" : "NO")
even ==> "YES"

jshell> String even = (i % 2==0 ? "YES" : 4)
|  Error:
|  incompatible types: bad type in conditional expression
|      int cannot be converted to java.lang.String
|  String even = (i % 2==0 ? "YES" : 4);

```