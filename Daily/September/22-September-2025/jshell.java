jshell> List<String> words = List.of("Apple","Bat","Cat");
words ==> [Apple, Bat, Cat]

jshell> words.size();
$2 ==> 3

jshell> words.isEmpty();
$3 ==> false

jshell> words.get(0);
$4 ==> "Apple"

jshell> words.contains("Dog");
$5 ==> false

jshell> words.contains("Cat");
$6 ==> true

jshell> words.indexOf("Cat");
$7 ==> 2

jshell> words.indexOf("Dog");
$8 ==> -1
--------------------------------------------------------------
jshell> List<String> wordsArrayList = new ArrayList<String>(words)
wordsArrayList ==> [Apple, Bat, Cat]

jshell> List<String> wordsLinkedList = new LinkedList<String>(words)
wordsLinkedList ==> [Apple, Bat, Cat]

jshell> List<String> wordsVector = new Vector<String>(words)
wordsVector ==> [Apple, Bat, Cat]

jshell> wordsArrayList.add("Dog");
$12 ==> true

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Cat, Dog]
--------------------------------------------------------------
jshell> List<String> newList = List.of("Yak","Zebra");
newList ==> [Yak, Zebra]

jshell> wordsArrayList.addAll(newList);
$15 ==> true

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Cat, Dog, Yak, Zebra]

jshell> wordsArrayList.add(2, "Ball");

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Ball, Cat, Dog, Yak, Zebra]

jshell> wordsArrayList.set(5, "Elephant");
$19 ==> "Yak"

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Ball, Cat, Dog, Elephant, Zebra]

jshell> wordsArrayList.add(6, "Yak");

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Ball, Cat, Dog, Elephant, Yak, Zebra]

jshell> wordsArrayList.remove(2)
$23 ==> "Ball"

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Cat, Dog, Elephant, Yak, Zebra]

jshell> wordsArrayList.remove("Dog");
$25 ==> true

jshell> wordsArrayList
wordsArrayList ==> [Apple, Bat, Cat, Elephant, Yak, Zebra]
--------------------------------------------------------------
jshell> List<String> words = List.of("Apple","Bat","Cat");
words ==> [Apple, Bat, Cat]

jshell> for(int i=0; i<words.size(); i++) {
   ...>     System.out.println(words.get(i));
   ...> }
Apple
Bat
Cat

jshell> for (String word  : words) {}

jshell> for (String word  : words) {
   ...>     System.out.println(word);
   ...> }
Apple
Bat
Cat

jshell> Iterator wordsIterator = words.iterator();
wordsIterator ==> java.util.ImmutableCollections$ListItr@5b80350b

jshell> while(wordsIterator.hasNext()) {
   ...>     System.out.println(wordsIteratoer.next());
   ...> }
|  Error:
|  cannot find symbol
|    symbol:   variable wordsIteratoer
|      System.out.println(wordsIteratoer.next());
|                         ^------------^

jshell> while(wordsIterator.hasNext()) {
   ...>     System.out.println(wordsIterator.next());
   ...> }
Apple
Bat
Cat

jshell> List<String> wordsAl = new ArrayList<>(words);
wordsAl ==> [Apple, Bat, Cat]

jshell> for (String word:words) {
   ...>     if(word.endsWith("at")) {
   ...>         System.out.println(word);
   ...>     }
   ...> }
Bat
Cat

jshell> for (String word:wordsAl) {
   ...>     if(word.endsWith("at")) {
   ...>         words.remove(word);
   ...>     }
   ...> }
|  Exception java.lang.UnsupportedOperationException
|        at ImmutableCollections.uoe (ImmutableCollections.java:142)
|        at ImmutableCollections$AbstractImmutableCollection.remove (ImmutableCollections.java:150)
|        at (#35:3)

jshell> for (String word:wordsAl) {
   ...>     if(word.endsWith("at")) {
   ...>         wordsAl.remove(word);
   ...>     }
   ...> }

jshell> wordsAl
wordsAl ==> [Apple, Cat]

jshell> List<String> words = List.of("Apple","Bat","Cat");
words ==> [Apple, Bat, Cat]

jshell> List<String> wordsAl = new ArrayList<>(words);
wordsAl ==> [Apple, Bat, Cat]

jshell> Iterator<String> iterator = wordsAl.iterator();
iterator ==> java.util.ArrayList$Itr@64b8f8f4

jshell> while(iterator.hasNext()) {
   ...>     if(iterator.next().endsWith("at") {
   ...>         iterator.remove();
   ...>     }
   ...> }
|  Error:
|  ')' expected
|      if(iterator.next().endsWith("at") {
|                                       ^

jshell> while(iterator.hasNext()) {
   ...>     if(iterator.next().endsWith("at")) {
   ...>         iterator.remove();
   ...>     }
   ...> }

jshell> wordsAl
wordsAl ==> [Apple]
--------------------------------------------------------------
jshell> List value = List.of("A",'A',1,1.0)
value ==> [A, A, 1, 1.0]

jshell> value.get(2)
$2 ==> 1

jshell> value.get(2) instanceof Integer
$3 ==> true

jshell> List<String> textValues = List.of("A",'A',1,1.0);
|  Error:
|  incompatible types: inference variable E has incompatible bounds
|      equality constraints: java.lang.String
|      lower bounds: java.lang.Double,java.lang.Integer,java.lang.Character,java.lang.String
|  List<String> textValues = List.of("A",'A',1,1.0);
|                            ^--------------------^

jshell> List<Integer> numbers = List.of(101,102,103,104,105)
numbers ==> [101, 102, 103, 104, 105]

jshell> numbers.indexOf(103)
$5 ==> 2

jshell> List<Integer> numbersAl = new ArrayList<>(numbers);
numbersAl ==> [101, 102, 103, 104, 105]

jshell> numbersAl.indexOd(105);
|  Error:
|  cannot find symbol
|    symbol:   method indexOd(int)
|  numbersAl.indexOd(105);
|  ^---------------^

jshell> numbersAl.indexOf(105);
$7 ==> 4

jshell> numbersAl.remove(Integer.valueOf(101))
$8 ==> true

jshell> numbersAl
numbersAl ==> [102, 103, 104, 105]