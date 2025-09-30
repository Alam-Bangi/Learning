```
jshell TreeMap<String, Integer> treemap = new TreeMap<>();
treemap ==> {}

jshell> treemap.put("F",25);
$2 ==> null

jshell> treemap.put("Z",5);
$3 ==> null

jshell> treemap.put("L",250);
$4 ==> null

jshell> treemap.put("A",15);
$5 ==> null

jshell> treemap.put("B",25);
$6 ==> null

jshell> treemap.put("G",25);
$7 ==> null

jshell> treemap
treemap ==> {A=15, B=25, F=25, G=25, L=250, Z=5}

jshell> treemap.higherKey("B");
$9 ==> "F"

jshell> treemap.higherKey("L");
$10 ==> "Z"

jshell> treemap.ceilingKey("B")
$11 ==> "B"

jshell> treemap.lowerKey("B")
$12 ==> "A"

jshell> treemap.floorKey("B")
$13 ==> "B"

jshell> treemap.firstEntry()
$14 ==> A=15

jshell> treemap.lastEntry()
$15 ==> Z=5

jshell> treemap.subMap("C","Y");
$16 ==> {F=25, G=25, L=250}

jshell> treemap.subMap("B","Z");
$17 ==> {B=25, F=25, G=25, L=250}
```