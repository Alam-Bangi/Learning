import java.util.*;
import java.lang.*;
import java.io.*;

class Generics {
	public static void main (String[] args)	{
	    MyCustomList list = new MyCustomList();
	    list.addElement("Element 1");
	    list.addElement("Element 2");
	    
	    MyCustomList list2 = new MyCustomList();
	    list2.addElement(Integer.valueOf(5));
	    list2.addElement(Integer.valueOf(7));
	}
}
class MyCustomList {
    ArrayList<String> list = new ArrayList<>();
    
    public void addElement(String element) {
        list.add(element);
    }
    public void removeElement(String element) {
        list.remove(element);
    }
}