/*
JAVA reflection is a very powerful tool to inspect the attributes of a class in runtime. For example, we can retrieve the list of public fields of a class using getDeclaredMethods().

In this problem, you will be given a class Solution in the editor. You have to fill in the incompleted lines so that it prints all the methods of another class called Student in alphabetical order. We will append your code with the Student class before running it. The Student class looks like this:

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }
    ......
    ......
    some more methods
    ......
}
You have to print all the methods of the student class in alphabetical order like this:

anothermethod
getName
setEmail
setId
......
......
some more methods
......
There is no sample input/output for this problem. If you press "Run Code", it will compile it, but it won't show any outputs.

Hint: See the oracle docs for more details about JAVA Reflection Methods and Fields
 */
package hackerrank;

import java.util.*;
import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args){
        Class student = new Studentt().getClass();
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m : methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}

class Studentt {
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anotherfunction(){  }

    public void dnqvo(){  }
    public void bwkbd(){  }
    public void rmjig(){  }
    public void amftc(){  }
    public void kgwku(){  }
    public void ogvdl(){  }
    public void viyog(){  }
    public void pqfct(){  }
    public void iwhtf(){  }
    public void ptrup(){  }
    public void viwuu(){  }
    public void tkbpp(){  }
    public void plaob(){  }
    public void ghtlj(){  }
    public void pvgyp(){  }
    public void ormim(){  }
    public void cfwyc(){  }
    public void sumvl(){  }
    public void elyed(){  }
    public void cmkxa(){  }
    public void toxdp(){  }
    public void qthde(){  }
    public void whjtj(){  }
    public void moebl(){  }
    public void piwro(){  }
    public void atcks(){  }
    public void ehjdm(){  }
    public void ytijy(){  }
    public void migyc(){  }
    public void pnruo(){  }
    public void fmyce(){  }
    public void odyqp(){  }
    public void twyfa(){  }
    public void levtp(){  }
    public void ujxei(){  }
    public void dvvwq(){  }
    public void mcgme(){  }
    public void kbjlt(){  }
    public void ahqym(){  }
    public void tntpj(){  }
    public void jnskt(){  }
    public void dnpym(){  }
    public void jmopy(){  }
    public void uccfq(){  }
    public void vhxoi(){  }
    public void nixhb(){  }
    public void isqdf(){  }
    public void khuag(){  }
    public void hluvb(){  }
}