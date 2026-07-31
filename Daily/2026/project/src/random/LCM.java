package random;

public class LCM {
    public static void main(String[] args) {
        int num1 = 9;
        int num2 = 27;
        isLCM(num1,  num2);
    }
    public static void isLCM(int num1, int num2) {
        int lcm = 0;
        int max;
        if (num1 < num2) {
            max = num2;
        } else {
            max = num1;
        }
        lcm = lcm + max;
        while (lcm != 0) {
            if (lcm % num1 == 0 && lcm % num2 == 0) {
                System.out.println("LCM of " + num1 + " & " + num2 + " is " + lcm);
                break;
            }
            lcm = lcm + max;
        }
    }
}