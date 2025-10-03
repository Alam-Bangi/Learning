```
jshell> class Planet {
   ...>     void revolve() {
   ...>         System.out.println("Revolve");
   ...>     }
   ...> }
|  replaced class Planet
|    update replaced variable venus, reset to null
|    update replaced variable earth, reset to null

jshell> Planet earth = new Planet()
earth ==> Planet@71bc1ae4

jshell> Planet venus = new Planet()
venus ==> Planet@6ed3ef1

jshell> earth.revolve()
Revolve

jshell> venus.revolve()
Revolve

jshell> class Country {
   ...>     void comingSoon() {
   ...>         System.out.println("Coming Soon");
   ...>     }
   ...> }
|  replaced class Country
|    update replaced variable india, reset to null
|    update replaced variable usa, reset to null

jshell> Country india = new Country()
india ==> Country@7b3300e5

jshell> Country usa = new Country()
usa ==> Country@2e5c649

jshell> india.comingSoon()
Coming Soon

jshell> usa.comingSoon()
Coming Soon

```