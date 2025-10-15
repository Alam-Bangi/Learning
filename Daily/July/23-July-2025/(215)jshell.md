```

jshell> nothing = dog
nothing ==> Animal@45ff54e6

jshell> int j = i
j ==> 5

jshell> j
j ==> 5

jshell> j = 6
j ==> 6

jshell> i
i ==> 5

jshell> i == j
$16 ==> false

jshell> Animal dog = new Animal(12);
dog ==> Animal@2d38eb89

jshell> Animal cat = new Animal(10);
cat ==> Animal@5fa7e7ff

jshell> Animal ref = cat;
ref ==> Animal@5fa7e7ff

jshell> Animal dog2 = new Animal(12);
dog2 ==> Animal@4d76f3f8

jshell> cat == dog
$21 ==> false

jshell> cat == ref
$22 ==> true

```