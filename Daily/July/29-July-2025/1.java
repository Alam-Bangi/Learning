class Main {
    public static void main(String[] args) {
        int number1 = 48;
        int number2 = 7;
        int max = 0;
        int lcm = 0;
        if(number1>number2) {
            lcm = number1;
        } else {
            lcm = number2;
        }
        max = lcm;
        for (; max<=lcm;) {
            if (lcm%number1==0 && lcm%number2==0) {
                System.out.println("Lcm of " +number1 + " & " +number2 + " is " + lcm);
                break;
            }
            lcm = lcm + max;
            
        }
    }
}