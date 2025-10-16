```

jshell> int[] marks = {100,99,95,96,100}
marks ==> int[5] { 100, 99, 95, 96, 100 }

jshell> for (int mark : marks)
   ...> System.out.println(mark);
100
99
95
96
100

jshell> for (int i = 0; i<marks.length; i++){
   ...> System.out.println(mark[i]);
   ...> }
|  Error:
|  cannot find symbol
|    symbol:   variable mark
|  System.out.println(mark[i]);
|                     ^--^

jshell> for (int i = 0; i<marks.length; i++){
   ...> System.out.println(marks[i]);
   ...> }
100
99
95
96
100

jshell> int[] marks = new int[5];
marks ==> int[5] { 0, 0, 0, 0, 0 }

jshell> Arrays.fill(marks, 100)

jshell> marks
marks ==> int[5] { 100, 100, 100, 100, 100 }

jshell> int[] array1 = {1,2,3}
array1 ==> int[3] { 1, 2, 3 }

jshell> int[] array2 = {1,2,3}
array2 ==> int[3] { 1, 2, 3 }

jshell> Arrays.equals(array1, array2)
$9 ==> true

jshell> Arrays.equals(array1, array3)
|  Error:
|  cannot find symbol
|    symbol:   variable array3
|  Arrays.equals(array1, array3)
|                        ^----^

jshell> int[] array3 = {3,2,1}
array3 ==> int[3] { 3, 2, 1 }

jshell> Arrays.equals(array1, array3)
$11 ==> false


```