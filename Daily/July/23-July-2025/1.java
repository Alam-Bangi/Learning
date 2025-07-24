// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        
        System.out.println("Explicit Type Casting");
        
        byte b = 121;
        short s = (short)b;
        int a = (int)b;
        long l = (long)b;
        float f = (float)b;
        double d = (double)b;
        System.out.println("For Byte");
        System.out.println("Byte:" +b );
        System.out.println("Short:" +s );
        System.out.println("Integer:" +a );
        System.out.println("Long:" +l );
        System.out.println("Float:" +f );
        System.out.println("Double:" +d );
        System.out.println(" ");
        
        short s1 = 120;
        byte b1 = (byte)s1;
        int a1 = (int)s1;
        long l1 = (long)s1;
        float f1 = (float)s1;
        double d1 = (double)s1;
        System.out.println("For Short");
        System.out.println("Short:" +s1 );
        System.out.println("Byte:" +b1 );
        System.out.println("Integer:" +a1 );
        System.out.println("Long:" +l1 );
        System.out.println("Float:" +f1 );
        System.out.println("Double:" +d1 );
        System.out.println(" ");
        
        int a2 = 119;
        byte b2 = (byte)a2;
        short s2 = (short)a2;
        long l2 = (long)a2;
        float f2 = (float)a2;
        double d2 = (double)a2;
        System.out.println("For Integer");
        System.out.println("Integer:" +a2 );
        System.out.println("Short:" +s2 );
        System.out.println("Byte:" +b2 );
        System.out.println("Long:" +l2 );
        System.out.println("Float:" +f2 );
        System.out.println("Double:" +d2 );
        System.out.println(" ");
        
        long l3 = 118;
        byte b3 = (byte)l3;
        short s3 = (short)l3;
        int a3 = (int)l3;
        float f3 = (float)l3;
        double d3 = (double)l3;
        System.out.println("For Long");
        System.out.println("Long:" +l3 );
        System.out.println("Byte:" +b3 );
        System.out.println("Short:" +s3 );
        System.out.println("Integer:" +a3 );
        System.out.println("Float:" +f3 );
        System.out.println("Double:" +d3 );
        System.out.println(" ");
        
        float f4 = 117.05f;
        byte b4 = (byte)f4;
        short s4 = (short)f4;
        int a4 = (int)f4;
        long l4 = (long)f4;
        double d4 = (double)f4;
        System.out.println("For Float");
        System.out.println("Float:" +f4 );
        System.out.println("Byte:" +b4 );
        System.out.println("Short:" +s4 );
        System.out.println("Integer:" +a4 );
        System.out.println("Long:" +l4 );
        System.out.println("Double:" +d4 );
        System.out.println(" ");
        
        double d5 = 116.10;
        byte b5 = (byte)d5;
        short s5 = (short)d5;
        int a5 = (int)d5;
        long l5 = (long)d5;
        float f5 = (float)d5;
        System.out.println("For Double");
        System.out.println("Double:" +d5 );
        System.out.println("Byte:" +b5 );
        System.out.println("Short:" +s5 );
        System.out.println("Integer:" +a5 );
        System.out.println("Long:" +l5 );
        System.out.println("Float:" +f5 );
        System.out.println(" ");
        
        System.out.println("Implicit Type Casting");
        
        byte b6 = 115;
        short s6 = b6;
        int a6 = b6;
        long l6 = b6;
        float f6 = b6;
        double d6 = b6;
        System.out.println("For Byte");
        System.out.println("Byte:" +b6 );
        System.out.println("Short:" +s6 );
        System.out.println("Integer:" +a6 );
        System.out.println("Long:" +l6 );
        System.out.println("Float:" +f6 );
        System.out.println("Double:" +d6 );
        System.out.println(" ");
       
        short s7 = 114;
        int a7 = s7;
        long l7 = s7;
        float f7 = s7;
        double d7 = s7;
        System.out.println("For Short");
        System.out.println("Short:" +s7 );
        System.out.println("Short cannot be converted to Byte.");
        System.out.println("Integer:" +a7 );
        System.out.println("Long:" +l7 );
        System.out.println("Float:" +f7 );
        System.out.println("Double:" +d7 );
        System.out.println(" ");
       
        int a8 = 113;
        long l8 = a8;
        float f8 = a8;
        double d8 = a8;
        System.out.println("For Integer");
        System.out.println("Integer:" +a8 );
        System.out.println("Integer cannot be converted to Short");
        System.out.println("Integer cannot be converted to Byte");
        System.out.println("Long:" +l8 );
        System.out.println("Float:" +f8 );
        System.out.println("Double:" +d8 );
        System.out.println(" ");
       
        long l9 = 112;
        float f9 = l9;
        double d9 = l9;
        System.out.println("For Long");
        System.out.println("Long:" +l9 );
        System.out.println("Long cannot be converted to Byte");
        System.out.println("Long cannot be converted to Short");
        System.out.println("Long cannot be converted to Integer");
        System.out.println("Float:" +f9 );
        System.out.println("Double:" +d9 );
        System.out.println(" ");
        
        float f10 = 111.05f;
        double d10 = f10;
        System.out.println("For Float");
        System.out.println("Float:" +f10 );
        System.out.println("Float cannot be converted to Byte");
        System.out.println("Float cannot be converted to Short");
        System.out.println("Float cannot be converted to Integer");
        System.out.println("Float cannot be converted to Long");
        System.out.println("Double:" +d10 );
        System.out.println(" ");
        
        double d11 = 110.10;
        System.out.println("For Double");
        System.out.println("Double:" +d11 );
        System.out.println("Double cannot be converted to Byte");
        System.out.println("Double cannot be converted to Short");
        System.out.println("Double cannot be converted to Integer");
        System.out.println("Double cannot be converted to Long");
        System.out.println("Double cannot be converted to Float");
        System.out.println(" ");
       
    }
}