```
jshell> HashMap<String, Integer> hashmap = new HashMap<>();
hashmap ==> {}

jshell> hashmap.put("Z",5)
$70 ==> null

jshell> hashmap.put("A",15)
$71 ==> null

jshell> hashmap.put("F",25)
$72 ==> null

jshell> hashmap.put("L",250)
$73 ==> null

jshell> hashmap
hashmap ==> {A=15, F=25, Z=5, L=250}

jshell> LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
linkedHashMap ==> {}

jshell> linkedHashMap.put("F",25)
$76 ==> null

jshell> linkedHashMap.put("A",15)
$77 ==> null

jshell> linkedHashMap.put("Z",5)
$78 ==> null

jshell> linkedHashMap.put("L",250)
$79 ==> null

jshell> linkedHashMap
linkedHashMap ==> {F=25, A=15, Z=5, L=250}

jshell> TreeMap<String, Integer> treemap = new TreeMap<>();
treemap ==> {}

jshell> treemap.put("F",25)
$82 ==> null

jshell> treemap.put("A",15)
$83 ==> null

jshell> treemap.put("Z",5)
$84 ==> null

jshell> treemap.put("L",250)
$85 ==> null

jshell> treemap
treemap ==> {A=15, F=25, L=250, Z=5}
```