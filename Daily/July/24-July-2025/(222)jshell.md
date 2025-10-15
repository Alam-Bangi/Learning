```

jshell> int i = 5
i ==> 5

jshell> Integer integer = new Integer(5);
|  Warning:
|  Integer(int) in java.lang.Integer has been deprecated and marked for removal
|  Integer integer = new Integer(5);
|                    ^------------^
integer ==> 5

jshell> Integer integer1 = new Integer(5);
|  Warning:
|  Integer(int) in java.lang.Integer has been deprecated and marked for removal
|  Integer integer1 = new Integer(5);
|                     ^------------^
integer1 ==> 5

jshell> Integer integer = Integer.valueOf(5);
integer ==> 5

jshell> Integer integer1 = Integer.valueOf(5);
integer1 ==> 5

jshell> Integer integer = Integer.valueOf("5432");
integer ==> 5432

```