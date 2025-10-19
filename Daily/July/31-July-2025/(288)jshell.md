```

jshell> class Animal {
   ...> }
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

jshell> class Animal{
   ...> }
|  modified class Animal

jshell> class Pet extends Animal{
   ...>     public void groom() {
   ...>         System.out.println("Groom");
   ...>     }
   ...> }
|  replaced class Pet

jshell> class Dog extends Pet {
   ...> }
|  created class Dog

jshell> Dog dog = new Dog();
dog ==> Dog@2328c243

jshell> dog.toString()
$7 ==> "Dog@2328c243"

jshell> dog.groom()
Groom

jshell> Pet pet = new Dog()
pet ==> Dog@1ed6993a

jshell> pet.groom
|  Error:
|  cannot find symbol
|    symbol:   variable groom
|  pet.groom
|  ^-------^

jshell> pet.groom()
Groom

jshell> Dog dog = new Pet();
|  Error:
|  incompatible types: Pet cannot be converted to Dog
|  Dog dog = new Pet();
|            ^-------^

jshell> pet instanceof Dog
$11 ==> true

jshell> pet instanceof String
|  Error:
|  incompatible types: Pet cannot be converted to java.lang.String
|  pet instanceof String
|  ^-^

jshell> pet instanceof Animal
$12 ==> true

jshell> pet instanceof Object
$13 ==> true

jshell> Animal animal = new Animal();
animal ==> Animal@6438a396

jshell> animal instanceof Pet
$15 ==> false

```