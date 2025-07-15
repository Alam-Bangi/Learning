// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
    int n=35;
    boolean answer;
    for(int i=1;i<=35;i++){
       // System.out.println(i);
    isPrimeNumber(i);
    answer= isPrimeNumber(i);
    if (answer==true){
        System.out.println(i);    }
    }
  
}
public static boolean isPrimeNumber(int number){
      boolean isDivisible=false;
    for(int i=2; i<number; i++){
       // System.out.println(i);
        if (number%i==0){
            isDivisible=true;
        }
    }
    if (number==1) {
       
       return false;//System.out.println("Invalid Number");
    } else if (isDivisible!=true) {
        //System.out.println("True");
        return true;
    } else {
       return false;
       // System.out.println("False");
    }
}
}