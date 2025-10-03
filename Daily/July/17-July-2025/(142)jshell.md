```

jshell> 34.56789 + 34.234
$35 ==> 68.80189

jshell> BigDecimal number1 = new BigDecimal("34.56789");
number1 ==> 34.56789

jshell> BigDecimal number2 = new BigDecimal("34.234");
number2 ==> 34.234

jshell> number1.add(number2);
$38 ==> 68.80189

jshell> BigDecimal number3 = number1.add(number2);
number3 ==> 68.80189

jshell> number1
number1 ==> 34.56789

```