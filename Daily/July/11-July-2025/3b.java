// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int number=1;
        int isDivisible=0;
            
            for(int i=2; i<number; i++){
                if(number%i==0){
                    isDivisible=1;
                }
            }
            if(number<=1){
                System.out.println("Is not a valid number.");
            }
            else if(isDivisible!=1){
                System.out.println("Number is Prime.");
            }
            else {
                System.out.println("Number is not Prime");
            }
   }
}