```

jshell> int[] marks = {12,34,45};
marks ==> int[3] { 12, 34, 45 }

jshell> int[] newMarks = new int[marks.length+1]
newMarks ==> int[4] { 0, 0, 0, 0 }

jshell> int[] newMarksWithOneDeleted = new int[marks.length-1]
newMarksWithOneDeleted ==> int[2] { 0, 0 }


```