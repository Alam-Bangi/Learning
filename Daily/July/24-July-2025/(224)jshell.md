```

jshell> /imports
|    import java.io.*
|    import java.math.*
|    import java.net.*
|    import java.nio.file.*
|    import java.util.*
|    import java.util.concurrent.*
|    import java.util.function.*
|    import java.util.prefs.*
|    import java.util.regex.*
|    import java.util.stream.*

jshell> import java.time.LocalDate

jshell> LocalDate now = LocalDate.now()
now ==> 2025-10-15

jshell> LocalDateTime now = LocalDateTime.now()
|  Error:
|  cannot find symbol
|    symbol:   class LocalDateTime
|  LocalDateTime now = LocalDateTime.now();
|  ^-----------^
|  Error:
|  cannot find symbol
|    symbol:   variable LocalDateTime
|  LocalDateTime now = LocalDateTime.now();
|                      ^-----------^

jshell> import java.time.*

jshell> LocalDateTime now = LocalDateTime.now()
now ==> 2025-10-15T19:16:39.071811300

```