
class PerfectNumberChecker {
    public static void main(String[] args) {
        int number = 52000000;
        
        System.out.println(isPerfectNumber(6));
        for(int i =1; i<number; i++) {
            if(isPerfectNumber(i)) {
                System.out.println(i + " is perfect number");
            }
        }
    }
    public static boolean isPerfectNumber(int number) {
        int sum =0;
        for (int i =1; i<number; i++) {
            if(number%i==0) {
                sum+= i;
            }
        }
        if(sum == number) {
            return true;
        }
        return false;
    }
}