```
jshell> System.out.printf("%d + %d + %d = %d",5,6,5+6+7).println()
5 + 6 + 18 = |  Exception java.util.MissingFormatArgumentException: Format specifier '%d'
|        at Formatter.format (Formatter.java:2688)
|        at PrintStream.format (PrintStream.java:1209)
|        at PrintStream.printf (PrintStream.java:1105)
|        at (#41:1)

jshell> System.out.printf("%d + %d + %d = %d",5,6,7,5+6+7,8).pr  tln()
5 + 6 + 7 = 18

jshell>

jshell> System.out.printf("%s" , "AbCxYz").println()
AbCxYz

jshell> System.out.printf("%f + %f + %f",5.5, 6.5, 7.5).println()
5.500000 + 6.500000 + 7.500000
```