```

jshell> "123" + "1234" + "12345"
$25 ==> "123123412345"

jshell> StringBuffer sb = new StringBuffer("Test");
sb ==> Test

jshell> sb
sb ==> Test

jshell> sb.append("123")
$28 ==> Test123

jshell> sb.setCharAt(1,'e')

jshell> sb
sb ==> Test123

jshell> sb.setCharAt(2,'e')

jshell> sb
sb ==> Teet123

jshell> StringBuilder sb = new StringBuilder("test");
sb ==> test

```