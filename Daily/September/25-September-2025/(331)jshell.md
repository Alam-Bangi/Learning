```
jshell> Map<String, Integer> map = Map.of("A",3,"B",5,"Z",10);
map ==> {A=3, B=5, Z=10}

jshell> map.get("Z")
$56 ==> 10

jshell> map.containsKey("A")
$57 ==> true

jshell> map.containsKey(5)
$58 ==> false

jshell> map.keySet()
$59 ==> [A, B, Z]

jshell> map.values()
$60 ==> [3, 5, 10]

jshell> map
map ==> {A=3, B=5, Z=10}

jshell> Map<String, Integer> hashmap = new HashMap<>();
hashmap ==> {}

jshell> hashmap.put("F",5)
$63 ==> null

jshell> hashmap
hashmap ==> {F=5}

jshell> Map<String, Integer> hashmap = new HashMap<>(map);
hashmap ==> {A=3, B=5, Z=10}

jshell> hashmap.put("F",5)
$66 ==> null

jshell> hashmap.put("Z",11)
$67 ==> 10

jshell> hashmap
hashmap ==> {A=3, B=5, Z=11, F=5}
```