package com.study.patterns;

import java.time.Instant;

public class HalfPyramid {
    static int number = 51;
    static int maxLength = String.valueOf((number * (number+1)/2)).length();
    public static void main(String[] args) {


//        Half pryamid (*)
//        * * * * *
//        * * * *
//        * * *
//        * *
//        *
//        for (int row = 0; row < number; row++) {
//            for (int col = 0; col < number - row; col++) {
//                System.out.print("* ");
//            }
//            for (int col = 0; col < number; col++) {
//                System.out.print("  ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");

//        Half pyramid(number)
//        1 2 3 4 5
//        1 2 3 4
//        1 2 3
//        1 2
//        1
//        for (int row = 0; row < number; row++) {
//            for (int col = 0; col < number - row; col++) {
//                System.out.print((col+1) + " ");
//            }
//            for (int col = 0; col < number; col++) {
//                System.out.print("  ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");

//        5 4 3 2 1
//        5 4 3 2
//        5 4 3
//        5 4
//        5
//        for (int row = 0; row < number; row++) {
//            for (int col = number; col > row; col--) {
//                System.out.print(col + " ");
//            }
//            for (int col = 0; col < number; col++) {
//                System.out.print("  ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");

//        1   2   3   4   5
//        6   7   8   9
//        10  11  12
//        13  14
//        15
        int n =1;
        System.out.println(Instant.now());
        for (int row = 0; row < number; row++) {
            for (int col = number; col > row; col--) {
                System.out.println(performOperation(n , number));
                n++;
            }
            for (int col = 0; col < number; col++) {
                System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println(Instant.now());
    }

    public static String performOperation(int n, int size) {
        int lastElement = size * (size + 1) / 2;
        if (n > lastElement) {
            return "";
        }
        int spaces =  maxLength - String.valueOf(n).length();
//        int spaces =  String.valueOf((number * (number+1)/2)).length() - String.valueOf(n).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        sb.append(n).append(" ");
        return sb.toString();
    }
}
//2026-07-09T10:10:28.225500Z
//2026-07-09T10:10:28.859447500Z

//2026-07-09T10:13:43.932705700Z
//2026-07-09T10:13:44.353366300Z

//
//2026-07-09T10:22:43.515607500Z



