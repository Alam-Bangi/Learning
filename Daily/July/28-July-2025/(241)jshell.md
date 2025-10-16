```

jshell> int[] marks = {1,2,3,4,5,6,7,8}
marks ==> int[8] { 1, 2, 3, 4, 5, 6, 7, 8 }

jshell> marks.length
$20 ==> 8

jshell> for( int i =0; i< marks.length-1; i++) {
   ...>     System.out.println(marks[i]);
   ...> }
1
2
3
4
5
6
7

jshell> for( int i =0; i< marks.length; i++) {
   ...>     System.out.println(marks[i]);
   ...> }
1
2
3
4
5
6
7
8

jshell> int[] marks = new int[5];
marks ==> int[5] { 0, 0, 0, 0, 0 }

jshell> double[] values = new double[5];
values ==> double[5] { 0.0, 0.0, 0.0, 0.0, 0.0 }

jshell> boolean[] test = new boolean[5];
test ==> boolean[5] { false, false, false, false, false }

jshell> class Person {
   ...> }
|  created class Person

jshell> Person[] person = new Person[5];
person ==> Person[5] { null, null, null, null, null }

jshell> int[5] marks;
|  Error:
|  ']' expected
|  int[5] marks;
|      ^

jshell> int[] marks = new int[];
|  Error:
|  array dimension missing
|  int[] marks = new int[];
|                ^-------^

jshell> int[] marks = new int[5];
marks ==> int[5] { 0, 0, 0, 0, 0 }

jshell> int[6]
|  Error:
|  ']' expected
|  int[6]
|      ^

jshell> marks[6]
|  Exception java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
|        at (#29:1)

jshell> int[] marks = (1,2,3,4.0};
|  Error:
|  ')' expected
|  int[] marks = (1,2,3,4.0};
|                  ^
|  Error:
|  <identifier> expected
|  int[] marks = (1,2,3,4.0};
|                   ^


```