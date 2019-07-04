package com.anne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = "a->";

        double d = 0.1;
        String a = "1+1i";
        String b = "1+1i";

        String a1 = a.split("\\+")[0];
//        String a2 = a.split("+")[1].split("i")[0];
//        String b1 = b.split("+")[0];
//        String b2 = b.split("+")[1].split("i")[0];
        System.out.println(a1);
    }
}
