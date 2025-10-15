```

class Planet {}
|  created class Planet

jshell> Planet jupiter = new Planet();
jupiter ==> Planet@4459eb14

jshell> int i =5;
i ==> 5

jshell> class Animal {
   ...>     int id;
   ...>     Animal(int id) {
   ...>         this.id = id;
   ...>     }
   ...> }
|  created class Animal

jshell> Animal dog = new Animal(12);
dog ==> Animal@45ff54e6

jshell> Animal cat = new Animal(15);
cat ==> Animal@bebdb06

jshell>

jshell> Animal nothing;
nothing ==> null

jshell> nothing = cat;
nothing ==> Animal@bebdb06

jshell> nothing.id = 10;
$9 ==> 10

jshell> cat.id
$10 ==> 10

```