class Main {
    // void myName( name) {
    //     String name= name();
    //     name = Alam;
    // }
    
     public static void main(String[] args) {
        int age;
        age = 22;
        String name;
        name = "Alam";
        System.out.println(name);
        myName();
        myName(name);
        //isDivisibleByThree(age);
        System.out.println(isDivisibleByThree(age));
        //isDivisibleByFive(age);
        System.out.println(isDivisibleByFive(age));
        int number=35;
        for(int i=1; i<=number; i++) {
            //System.out.println(i);
            if(isDivisibleByThree(i) || isDivisibleByFive(i) ) {
                System.out.println(i);
            }
        }
        
    }
   static void myName() {
        System.out.println("Alam");
    }
    static void myName(String Abrar) {
        System.out.println(Abrar);
    }
    static boolean isDivisibleByThree(int number) {
        if(number % 3 ==0)
            return true;
         else   {
             return false;
            }
    }
    static boolean isDivisibleByFive(int number) {
        if(number % 5 ==0)
            return true;
        else {
            return false;
        }
    }
}