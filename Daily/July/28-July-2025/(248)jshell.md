```

jshell> class Person {
   ...> }
|  created class Person

jshell> Person[] person = new Person[5];
person ==> Person[5] { null, null, null, null, null }

jshell> person[1] = new Person();
$14 ==> Person@77a567e1

jshell> person
person ==> Person[5] { null, Person@77a567e1, null, null, null }

jshell> person[0] = new Person();
$16 ==> Person@108c4c35

jshell> person
person ==> Person[5] { Person@108c4c35, Person@77a567e1, null, null, null }

jshell> Person[] person2 = {new Person(), new Person()};
person2 ==> Person[2] { Person@2d38eb89, Person@5fa7e7ff }

jshell> String[] textValues = {"Apple","Ball","Cat"};
textValues ==> String[3] { "Apple", "Ball", "Cat" }


```