```
jshell> Queue<String> queue = new PriorityQueue<>();
queue ==> []

jshell> queue.poll()
$49 ==> null

jshell> queue.offer("Apple")
$50 ==> true

jshell> queue.addAll(List.of("Zebra","Monkey","Cat"));
$51 ==> true

jshell> queue
queue ==> [Apple, Cat, Monkey, Zebra]

jshell> queue.poll()
$53 ==> "Apple"

jshell> queue
queue ==> [Cat, Zebra, Monkey]
```