package com.anne;

import java.math.BigDecimal;

public class NFactorial {
    public static BigDecimal solution(BigDecimal n) {
        return nFactorial(n);
    }

    private static BigDecimal nFactorial(BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) == 0){
            return BigDecimal.ONE;
        }
        return n.multiply(nFactorial(n.subtract(BigDecimal.ONE)));
    }

    public static void main(String[] args) {
        System.out.println(solution(new BigDecimal(100)));
    }
}
