jshell> class Animal {}
|  created class Animal

jshell> class Pet {
   ...> }
|  created class Pet

jshell> class Dog extends Animal,Pet {
   ...> }
|  Error:
|  '{' expected
|  class Dog extends Animal,Pet {
|                          ^

jshell> class Pet extends Animal {
   ...>     public void groom() {
   ...>     System.out.println("Groom");
   ...>     }
   ...> }
|  replaced class Pet

jshell> class Dog extends Pet {
   ...> }
|  created class Dog

jshell> Dog dog = new Dog();
dog ==> Dog@2328c243

jshell> dog.groom();
Groom

jshell> Pet pet = new Dog()
pet ==> Dog@45283ce2

jshell> Dog dog = new Pet()
|  Error:
|  incompatible types: Pet cannot be converted to Dog
|  Dog dog = new Pet();
|            ^-------^

jshell> Animal animal = new Animal();
animal ==> Animal@7591083d

jshell> animal instanceof Pet
$9 ==> false

jshell> animal instanceof Object
$10 ==> true

--------------------------------------------------------------------------------------------------- 
jshell> class AbstractAnimal {
   ...>     public void bark();
   ...> }
|  Error:
|  missing method body, or declare abstract
|      public void bark();
|      ^-----------------^

jshell> class AbstractAnimal {
   ...>     abstract public void bark();
   ...> }
|  Error:
|  AbstractAnimal is not abstract and does not override abstract method bark() in AbstractAnimal
|  class AbstractAnimal {
|  ^---------------------...

jshell> abstract class AbstractAnimal {
   ...>     abstract public void bark();
   ...> }
|  created class AbstractAnimal

jshell> class Dog extends AbstractAnimal {
   ...>     public void bark() {
   ...>         System.out.println("Bow Bow");
   ...>     }
   ...> }
|  replaced class Dog

jshell> Dog dog = new Dog();
dog ==> Dog@6477463f

jshell> dog.bark();
Bow Bow

---------------------------------------------------------------------------------------------------
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

jshell> abstract class AbstractAlgorithm {
   ...>     private int stepCount;
   ...>     public int getStepCount() {
   ...>         return stepCount();
   ...>     }
   ...> }
|  replaced class AbstractAlgorithm, however, it cannot be instantiated or its methods invoked until method stepCount() is declared

---------------------------------------------------------------------------------------------------


