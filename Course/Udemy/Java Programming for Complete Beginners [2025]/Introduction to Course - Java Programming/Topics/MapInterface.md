## TreeMap
```
TreeMap in languages like Java, it does sort objects—but only if it knows how to compare them.

A TreeMap stores its keys in sorted order. To do that, it needs one of these:

The key class implements Comparable.
You provide a Comparator when creating the TreeMap.
Why it sometimes "can't sort objects"

If your objects don't implement Comparable and you don't provide a Comparator, the TreeMap has no way to determine which object should come before another.
```
### Adding & Updating
```
 Method                                                                Description                                              
 `put(K key, V value)`                                                 Adds or replaces a key-value pair.                       
 `putAll(Map<? extends K, ? extends V> m)`                             Copies all mappings from another map.                    
 `putIfAbsent(K key, V value)`                                         Adds the mapping only if the key is not already present. 
 `replace(K key, V value)`                                             Replaces the value if the key exists.                    
 `replace(K key, V oldValue, V newValue)`                              Replaces only if the current value matches `oldValue`.   
 `replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`  Replaces every value using a function.                   
```
### Retrieving
```
 Method                                      Description                               
 `get(Object key)`                           Returns the value for the key.            
 `getOrDefault(Object key, V defaultValue)`  Returns the value or a default if absent. 
```
### Removing
```
 Method                              Description                               
 `remove(Object key)`                Removes the mapping for a key.            
 `remove(Object key, Object value)`  Removes only if both key and value match. 
 `clear()`                           Removes all mappings.                     
```
### Checking
```
 Method                         Description                               
 `containsKey(Object key)`      Checks whether the key exists.            
 `containsValue(Object value)`  Checks whether a value exists.            
 `isEmpty()`                    Returns `true` if the map has no entries. 
 `size()`                       Returns the number of entries.            
```
### Iterating
```
 Method                 Description                        
 `keySet()`             Returns all keys.                  
 `values()`             Returns all values.                
 `entrySet()`           Returns all key-value pairs.       
 `forEach(BiConsumer)`  Performs an action for each entry. 
```
### Computing Values
```
 Method                                 Description                              
 `compute(K key, BiFunction)`           Computes a new value.                    
 `computeIfAbsent(K key, Function)`     Computes only if the key is absent.      
 `computeIfPresent(K key, BiFunction)`  Computes only if the key exists.         
 `merge(K key, V value, BiFunction)`    Merges an existing value with a new one. 
```
### Viewing
```
 Method        Description                
 `keySet()`    Set view of keys.          
 `values()`    Collection view of values. 
 `entrySet()`  Set view of entries.       
```
### Equality & Hashing
```
 Method              Description                       
 `equals(Object o)`  Compares two maps for equality.   
 `hashCode()`        Returns the hash code of the map. 
```
### Common Map Implementations
```
 Implementation       Ordered?                    Sorted?       Thread-safe?    Allows `null`?           
 -------------------  --------------------------  ----------    ------------    ------------------------ 
 `HashMap`            ❌                          ❌            ❌             Yes (1 key, many values) 
 `LinkedHashMap`      ✅(insertion/access order)  ❌            ❌             Yes                      
 `TreeMap`            ❌                          ✅(by key)    ❌             No `null` keys           
 `Hashtable`          ❌                          ❌            ✅             No `null` keys or values 
 `ConcurrentHashMap`  ❌                          ❌            ✅             No `null` keys or values 
```