```

jshell> LocalDate today = LocalDate.now()
today ==> 2025-10-15

jshell> today.getYear()
$52 ==> 2025

jshell> today.getDayOf()
|  Error:
|  cannot find symbol
|    symbol:   method getDayOf()
|  today.getDayOf()
|  ^------------^

jshell> today.getDayOfWeek()
$53 ==> WEDNESDAY

jshell> today.getDayOfMonth()
$54 ==> 15

jshell> today.getDayOfYear()
$55 ==> 288

jshell> today.getMonthValue()
$56 ==> 10

jshell> today.isLeapYear()
$57 ==> false

jshell> today.lengthOfYear()
$58 ==> 365

jshell> today.plusDays(100)
$59 ==> 2026-01-23

jshell> today.plusMonths(100)
$60 ==> 2034-02-15

jshell> LocalDateTime now = LocalDateTime.now()
now ==> 2025-10-15T19:26:15.948525

jshell> now.plus
plus(          plusDays(      plusHours(     plusMinutes(   
plusMonths(    plusNanos(     plusSeconds(   plusWeeks(     
plusYears(

```