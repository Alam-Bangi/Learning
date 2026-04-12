class MinMax {
    public static void main(String[] args) {
        byte maxByte = (byte) (Math.pow(2, 7) - 1);
        byte minByte = (byte) (-Math.pow(2, 7));
        System.out.println("Byte Max: " + maxByte);
        System.out.println("Byte Min: " + minByte);

        short maxShort = (short) (Math.pow(2, 15) - 1);
        short minShort = (short) (-Math.pow(2, 15));
        System.out.println("Short Max: " + maxShort);
        System.out.println("Short Min: " + minShort);

        int maxInt = (int) (Math.pow(2, 31) - 1);
        int minInt = (int) (-Math.pow(2, 31));
        System.out.println("Int Max: " + maxInt);
        System.out.println("Int Min: " + minInt);

        long maxLong = (long) (Math.pow(2, 63) - 1);
        long minLong = (long) (-Math.pow(2, 63));
        System.out.println("Long Max: " + maxLong);
        System.out.println("Long Min: " + minLong);

        float maxFloat = (float) (Math.pow(10, 38));
        float minFloat = (float) (Math.pow(2, -149));
        System.out.println("Float Max: " + maxFloat);
        System.out.println("Float Min: " + minFloat);

        double maxDouble = (double) (Math.pow(10, 308));
        double minDouble = (double) (Math.pow(2, -1074));
        System.out.println("Double Max: " + maxDouble);
        System.out.println("Double Min: " + minDouble);

        for(int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            System.out.println(i);
        }

    }
}
// Byte Max: 127
// Byte Min: -128
// Short Max: 32767
// Short Min: -32768
// Int Max: 2147483647
// Int Min: -2147483648
// Long Max: 9223372036854775807
// Long Min: -9223372036854775808
// Float Max: 1.0E38
// Float Min: 1.4E-45
// Double Max: 1.0E308
// Double Min: 4.9E-324