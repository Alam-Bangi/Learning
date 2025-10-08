```

jshell> if (true) {
   ...>     System.out.println("True");
   ...> }
True

jshell> if (false) {
   ...>     System.out.println("True");
   ...> }

jshell> int i = 3;
i ==> 3

jshell> if (i == 3) {
   ...>     System.out.println("True");
   ...> }
True

jshell> if (i < 2) {
   ...>     System.out.println("True");
   ...> }

jshell> if (i <= 3  &&  i<=35) {
   ...>     System.out.println("True");
   ...> }
True

jshell> if (i == 3) {
   ...>     System.out.println("True");
   ...> } else {
   ...>     System.out.println("i is not 3");
   ...> }
True

jshell> i = 5
i ==> 5

jshell> if (i == 3) {
   ...>     System.out.println("True");
   ...> } else {
   ...>     System.out.println("i is not 3");
   ...> }
i is not 3

```