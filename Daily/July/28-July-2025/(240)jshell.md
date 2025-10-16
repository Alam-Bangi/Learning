```

jshell> int[] marks = {1,2,3};
marks ==> int[3] { 1, 2, 3 }

jshell> int[] marks2 = {1,2,3,4,5};
marks2 ==> int[5] { 1, 2, 3, 4, 5 }

jshell> int[] marks2 = {1};
marks2 ==> int[1] { 1 }

jshell> int[] marks2 = {};
marks2 ==> int[0] {  }

jshell> int[] marks3 = new int[5];
marks3 ==> int[5] { 0, 0, 0, 0, 0 }

jshell> marks[0]
$6 ==> 1

jshell> marks3[0] = 1
$7 ==> 1

jshell> marks3[1] = 2
$8 ==> 2

jshell> marks3[2] = 3
$9 ==> 3

jshell> marks3[3] = 4
$10 ==> 4

jshell> marks3[4] = 5
$11 ==> 5

jshell> marks3
marks3 ==> int[5] { 1, 2, 3, 4, 5 }

jshell> marks2
marks2 ==> int[0] {  }

jshell> int[] marks2 = {1,2,3,4,5}
marks2 ==> int[5] { 1, 2, 3, 4, 5 }

jshell> int[] marks3 = new int[5];
marks3 ==> int[5] { 0, 0, 0, 0, 0 }

jshell> marks2.length
$16 ==> 5

jshell> marks.length
$17 ==> 3

jshell> marks3.length
$18 ==> 5


```