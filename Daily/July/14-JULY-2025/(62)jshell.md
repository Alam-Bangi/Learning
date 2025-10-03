```
jshell> /methods
|    void sayHelloWorldTwice()
|    void sayHelloWorldThrice()
|    void printLearningExperience()
|    void sayHelloWorld(int)
|       which cannot be invoked until variable noOfTimes is declared
|    void printNumbers(int)
|    void printSquareOfNumbers(int)

jshell> sayHelloWorld("Value");
|  Error:
|  incompatible types: java.lang.String cannot be converted to int
|  sayHelloWorld("Value");
|                ^-----^

jshell> sayHelloWorld(4)
|  attempted to call method sayHelloWorld(int) which cannot be invoked until variable noOfTimes is declared
```