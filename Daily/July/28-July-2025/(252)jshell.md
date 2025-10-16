```

jshell> ArrayList arrayList = new ArrayList()
arrayList ==> []

jshell> arrayList.add("Apple")
|  Warning:
|  unchecked call to add(E) as a member of the raw type java.util.ArrayList
|  arrayList.add("Apple")
|  ^--------------------^
$24 ==> true

jshell> arrayList.add("Bat")
|  Warning:
|  unchecked call to add(E) as a member of the raw type java.util.ArrayList
|  arrayList.add("Bat")
|  ^------------------^
$25 ==> true

jshell> arrayList.add("Cat")
|  Warning:
|  unchecked call to add(E) as a member of the raw type java.util.ArrayList
|  arrayList.add("Cat")
|  ^------------------^
$26 ==> true

jshell> arrayList
arrayList ==> [Apple, Bat, Cat]

jshell> arrayList.remove("Cat")
$28 ==> true

jshell> arrayList
arrayList ==> [Apple, Bat]

jshell> arrayList.add(1)
|  Warning:
|  unchecked call to add(E) as a member of the raw type java.util.ArrayList
|  arrayList.add(1)
|  ^--------------^
$30 ==> true

jshell> arrayList
arrayList ==> [Apple, Bat, 1]

jshell> ArrayList<String> items = new ArrayList<String>()
items ==> []

jshell> items.add("Apple")
$33 ==> true

jshell> items.add(1)
|  Error:
|  incompatible types: int cannot be converted to java.lang.String
|  items.add(1)
|            ^

jshell> items.add("Bat")
$34 ==> true

jshell> items.add("Cat")
$35 ==> true

jshell> items
items ==> [Apple, Bat, Cat]

jshell> items.remove("Cat")
$37 ==> true

jshell> items
items ==> [Apple, Bat]

jshell> items.remove(0)
$39 ==> "Apple"

jshell> items
items ==> [Bat]

```