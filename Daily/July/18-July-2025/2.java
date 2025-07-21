class Main {
    public static void main(String[] args) {
        boolean isRight;
        isRight = true;
        boolean trueValue = true;
        boolean falseValue = false;
        System.out.println("Value of Boolean is " +isRight);
        System.out.println("Boolean value is either" + trueValue +" or " + falseValue);
        
        float f;
        f = 1;
        float minFloat = 1.4e-45f;
        float maxFloat = 3.4e+38f;
        System.out.println("Value of float is " + f);
        System.out.println("Range of float is from " +minFloat +" to " +maxFloat);
        
        double d;
        d=1;
        double minDouble = 4.9e-324;
        double maxDouble = 1.7e+308;
        System.out.println("Value of double is " + d);
        System.out.println("Range of double is from " +minDouble + " to " +maxDouble );
        
        short s;
        s=1;
        short minShort = -32768;
        short maxShort = 32767;
        System.out.println("Value of short is " + s);
        System.out.println("Range of short is from "+minShort + " to " +maxShort);
        
        byte b;
        b=5;
        byte minByte = -128;
        byte maxByte =  127;
        System.out.println("Value of byte is " + b);
        System.out.println("Range of byte is from "+minByte + " to " +maxByte);
        
        int i;
        i = 20;
        int minInteger = -2147483648;
        int maxInteger = 2147483647;
        System.out.println("Value of Integer is " + i);
        System.out.println("Range of Integer is from "+minInteger +" to " +maxInteger);
        
        char ch;
        ch = 'A';
        char minChar = 0;
        char maxChar = 65535;
        System.out.println("Value of Character is " + ch);
        System.out.println("Range of Character is from "+(int)minChar +" to " +(int)maxChar);
        
    }
}