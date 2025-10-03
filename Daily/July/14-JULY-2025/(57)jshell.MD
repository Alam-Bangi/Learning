```
jshell> void sayHelloWorldThrice() {
   ...>     System.out.println("Hello World");
   ...>     System.out.println("Hello World");
   ...>     System.out.println("Hello World");
   ...> }
|  modified method sayHelloWorldThrice()

jshell> sayHelloWorldThrice()
Hello World
Hello World
Hello World

jshell> void printLearningExperience() {
   ...>     System.out.println("I've created my first variab
l  );
   ...>     System.out.println("I've created my first method
");
   ...>     System.out.println("I've created my first loop")
;
   ...>     System.out.println("I'm excited to learn Java");
   ...> }
|  created method printLearningExperience()

jshell> printLearningExperience()
I've created my first variable
I've created my first method
I've created my first loop
I'm excited to learn Java

jshell> void 2things() {}
|  Error:
|  illegal start of expression
|  void 2things() {}
|  ^--^
|  Error:
|  ';' expected
|  void 2things() {}
|      ^
|  Error:
|  ';' expected
|  void 2things() {}
|                ^
|  Error:
|  cannot find symbol
|    symbol:   method things()
|  void 2things() {}
|        ^----^
```