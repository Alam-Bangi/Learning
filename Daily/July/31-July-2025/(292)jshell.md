```

jshell> abstract class AbstractTest {
   ...> }
|  created class AbstractTest

jshell> abstract class AbstractAlgorithm {
   ...>     abstract void steps();
   ...> }
|  created class AbstractAlgorithm

jshell> class Algorithm1 extends AbstractAlgorithm {
   ...> }
|  Error:
|  Algorithm1 is not abstract and does not override abstract method steps() in AbstractAlgorithm
|  class Algorithm1 extends AbstractAlgorithm {
|  ^-------------------------------------------...

jshell> abstract class Algorithm1 extends AbstractAlgorithm {
   ...> }
|  created class Algorithm1

jshell> abstract class abstractAlgorithm {
   ...>     private int stepCount;
   ...> }
|  created class abstractAlgorithm

jshell> abstract class abstractAlgorithm {
   ...>     private int stepCount;
   ...>     public int getStepCount() {
   ...>         return stepCount();
   ...>     }
   ...> }
|  replaced class abstractAlgorithm, however, it cannot be instantiated or its methods invoked until method stepCount() is declared

```