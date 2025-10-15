```

jshell> LocalDate today = LocalDate.now()
today ==> 2025-10-15

jshell> LocalDate yesterday = LocalDate.of(2025, 10, 14);
yesterday ==> 2025-10-14

jshell> today.withYear(2002);
$4 ==> 2002-10-15

jshell> today.withDayOfMonth(20)
$5 ==> 2025-10-20

jshell> today.withMonth(11)
$6 ==> 2025-11-15

jshell> today.withDayOfYear(120)
$7 ==> 2025-04-30

jshell>
today.isBefore(yesterday);
$8 ==> false

jshell> today.isAfter(yesterday);
$9 ==> true


```