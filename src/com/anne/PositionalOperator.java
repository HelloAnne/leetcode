package com.anne;

public class PositionalOperator {
    public static void main(String[] arg) {
        int a = 1;
        int b = 3;
        a ^= b;
        System.out.println(a);
        b ^= a;
        System.out.println(b);
        a ^= b;
        System.out.println(a);
    }
}
