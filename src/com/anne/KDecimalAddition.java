package com.anne;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Anne Zhang
 * Date: 2019/7/21
 * Description:
 */
public class KDecimalAddition {

    static Character[] nums = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
    static List<Character> list = Arrays.asList(nums);

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String r=f(16, str1, str2);
        System.out.println(r);
    }

    static String f(int k, String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = s1.length - 1;
        int j = s2.length - 1;
        int temp = 0;// 进位
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            char c1 = i>=0 ? s1[i--]:0;
            char c2 = j>=0 ? s2[j--]:0;
            int index1 = list.indexOf(c1);
            int index2 = list.indexOf(c2);
            int sum = (index1 + index2 + temp)%k;
            temp = (index1 + index2 + temp)/k;
            sb.append(list.get(sum));
        }

        if(temp!=0){
            sb.append(list.get(temp));
        }
        return sb.reverse().toString();
    }
}
