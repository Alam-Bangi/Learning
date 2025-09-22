jshell> interface Interface1 {}
|  created interface Interface1

jshell> interface Interface1 {
   ...>     void method1()
   ...>     ;
   ...> }
|  replaced interface Interface1

jshell> interface Interface2 extends Interface1{
   ...>     void method2();
   ...> }
|  created interface Interface2

jshell> class Implementation implements Intetrface2 {
   ...>     public void method2() { }
   ...>     public void method1() { }
   ...> }
|  created class Implementation, however, it cannot be referenced until class Intetrface2 is declared

jshell> class Implementation implements Interface2 {
   ...>     public void method2() { }
   ...>     public void method1() { }
   ...> }
|  replaced class Implementation

jshell> abstract class ImplementationAbstract implements Interface2 {
   ...>     public void method1() { }
   ...> }
|  created class ImplementationAbstract

jshell> interface Interface3 {
   ...>     int test = 5;
   ...> }
|  created interface Interface3

jshell> interface Interface4 {
   ...>     default void print() {
   ...>         System.out.println("default");
   ...>     }
   ...> }
|  created interface Interface4

jshell> class Test implements Interface4 {
   ...> }
|  created class Test

jshell> Test test = new Test();
test ==> Test@6d21714c

jshell> test.print()
default

jshell> class Test1 implements Interace4 {
   ...>     public void print() {
   ...>         System.out.println("override");
   ...>     }
   ...> }
|  created class Test1, however, it cannot be referenced until class Interace4 is declared

----------------------------------------------------------------------------------------------------

