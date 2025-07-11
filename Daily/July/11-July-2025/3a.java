// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int number=11;
        int isPrime=0;
            for(int i=2; i<number; i++){
              // System.out.println(number%i==0 );
                if(number%i==0) {
                   // System.out.println("Number is Prime.");
                    isPrime=1;
                }
            }
           // System.out.println(isPrime!=1 );
           // System.out.println(0==0);
           if(isPrime==1){
               System.out.println("Number is not Prime,");
           }
           else {
               System.out.println("Number is Prime.");
           }
    }
}