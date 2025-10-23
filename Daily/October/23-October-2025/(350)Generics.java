import java.util.*;
import java.lang.*;
import java.io.*;

class Generics {
    
    static<X> X doubleValue(X value) {
        return value;
    }
    static<X extends List> void duplicate(X list) {
        list.addAll(list);
    }
    static double sumOfNumberList(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum+= number.doubleValue();
        }
        return sum;
    }
    static void addValues(List<? super Number> number) {
        number.add(1);
        number.add(1.0);
        number.add(1.0f);
        number.add(1l);
    }
    
	public static void main (String[] args)	{
	    
	    List emptyList = new ArrayList<Number>();
	    addValues(emptyList);
	    System.out.println(emptyList);
	    
	    System.out.println(sumOfNumberList(List.of(1,2,3,4,5)));
	    System.out.println(sumOfNumberList(List.of(1.1,2.1,3.1,4.1,5.1)));
	    System.out.println(sumOfNumberList(List.of(1l,2l,3l,4l,5l)));
	    
	   // String value1 = doubleValue(new String());
	   // Integer number1 = doubleValue(Integer.valueOf(5));
	   // ArrayList list1 = doubleValue(new ArrayList());
	    
	   // ArrayList<Integer> numbers = new ArrayList<>(List.of(1,2,3));
	   // duplicate(numbers);
	   // System.out.println(numbers);
	    
	   // MyCustomList<Long> list = new MyCustomList<>();
	   // list.addElement(5l);
	   // list.addElement(7l);
	   // Long value = list.get(0);
	   //// System.out.println(list);
	   //System.out.println(value);
	    
	   // MyCustomList<Integer> list2 = new MyCustomList<>();
	   // list2.addElement(Integer.valueOf(5));
	   // list2.addElement(Integer.valueOf(7));
	   // Integer values = list2.get(0);
	   //// System.out.println(list2);
	   // System.out.println(values);
	}
}
class MyCustomList<T extends Number> {
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