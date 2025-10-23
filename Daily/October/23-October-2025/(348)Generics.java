import java.util.*;
import java.lang.*;
import java.io.*;

class Generics {
	public static void main (String[] args)	{
	    MyCustomList<String> list = new MyCustomList<>();
	    list.addElement("Element 1");
	    list.addElement("Element 2");
	    String value = list.get(0);
	   // System.out.println(list);
	   System.out.println(value);
	    
	    MyCustomList<Integer> list2 = new MyCustomList<>();
	    list2.addElement(Integer.valueOf(5));
	    list2.addElement(Integer.valueOf(7));
	    Integer value1 = list.get(0);
	   // System.out.println(list2);
	    System.out.println(value1);
	}
}
class MyCustomList<T> {
    ArrayList<T> list = new ArrayList<>();
    
    public void addElement(T element) {
        list.add(element);
    }
    public void removeElement(T element) {
        list.remove(element);
    }
    public String toString() {
        return list.toString();
    }
    public T get(int index) {
        return list.get(index);
    }
}