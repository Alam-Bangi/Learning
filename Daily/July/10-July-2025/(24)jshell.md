```
jshell> System.out.println(24       *       60       *       60);
86400

jshell> System.out.println("Hello      World");
Hello      World

jshell> System.out.println("HelloWorld");
HelloWorld

jshell> system.out.println("HelloWorld");
|  Error:
|  package system does not exist
|  system.out.println("HelloWorld");
|  ^--------^

jshell> System.out.println("Hello\"World");
Hello"World

jshell> System.out.println("Hello\nWorld");
Hello
World

jshell> System.out.println("Hello\tWorld");
Hello   World

jshell> System.out.println("Hello\\\\World");
Hello\\World

jshell> Math.random();
$23 ==> 0.4836919833158887

jshell> Math.min(23,45)
$24 ==> 23

jshell> Math.max(23,45)
$25 ==> 45
```