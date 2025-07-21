class Main {
    // void myName( name) {
    //     String name= name();
    //     name = Alam;
    // }
    
     public static void main(String[] args) {
        int age;
        age = 22;
        String name;
        name = "Abrar";
        System.out.println(name);
        myName();
        myName(name);
        isDivisibleByThree(age);
            System.out.println(isDivisibleByThree(age));
    }
   static void myName() {
        System.out.println("Alam");
    }
    static void myName(String s) {
        System.out.println(s);
    }
    static boolean isDivisibleByThree(int number) {
        if(number % 3 ==0)
            return true;
         else   {
             return false;
            }
    }
}