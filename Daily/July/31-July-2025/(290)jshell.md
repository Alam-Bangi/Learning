```

jshell> class Animal {
   ...>     public void bark() {
   ...>         System.out.println("Test");
   ...>     }
   ...> }
|  replaced class Animal
|    update replaced variable animal, reset to null
|    update replaced variable pet, reset to null

jshell> Animal animal = new Animal()
animal ==> Animal@22927a81

jshell> animal.bark()
Test

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

jshell> Dog dog = new Dog()
dog ==> Dog@51521cc1

jshell> god.bark()
|  Error:
|  cannot find symbol
|    symbol:   variable god
|  god.bark()
|  ^-^

jshell> dog.bark()
Bow Bow

```