package tryouts.generics;

import java.util.*;
// 1. <T> - Generic class
class Storage<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }
}