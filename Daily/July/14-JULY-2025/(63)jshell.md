```
jshell> void sayHelloWorld(int noOfTimes) {
   ...>     for(int i=1; i<=noOfTimes; i++) {
   ...>         System.out.println("Hello World");
   ...>     }
   ...> }
|  created method sayHelloWorld(int)

jshell> sayHelloWorld(2)
Hello World
Hello World

jshell> for(int i=1; i<=10; i++) {
   ...>     System.out.printf("%d * %d = %d",5,i,5*i).printl
n();
   ...> }
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
5 * 4 = 20
5 * 5 = 25
5 * 6 = 30
5 * 7 = 35
5 * 8 = 40
5 * 9 = 45
5 * 10 = 50

jshell> void printMultiplicationTable() {
   ...>     for(int i=1; i<=10; i++) {
   ...>     System.out.printf("%d * %d = %d",5,i,5*i).printl
n();
   ...> }
   ...> }
|  modified method printMultiplicationTable()

jshell> printMultiplicationTable()
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
5 * 4 = 20
5 * 5 = 25
5 * 6 = 30
5 * 7 = 35
5 * 8 = 40
5 * 9 = 45
5 * 10 = 50
```