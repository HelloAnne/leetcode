package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: Anne Zhang
 * Date: 2019/7/21
 * Description:
 */
public class AddStrings {
    public String solution(String num1, String num2) {
        if(num1==null || num1.length()==0) return num2;
        if(num2==null || num2.length()==0) return num1;
        int i=num1.length()-1;
        int j=num2.length()-1;
        int last = 0;
        String res = "";
        while(i>=0 || j>=0) {
            int temp1 = i>=0 ? num1.charAt(i--)-'0' : 0;
            int temp2 = j>=0 ? num2.charAt(j--)-'0' : 0;
            int temp = (temp1 + temp2 +last)%10;
            last=(temp1 + temp2 +last)/10;
            res = temp + res;
        }
        if (last != 0) {
            res = last + res;
        }
        return res;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String num1 = line;
            line = in.readLine();
            String num2 = line;

            String ret = new AddStrings().solution(num1, num2);

            String out = (ret);

            System.out.print(out);
        }
    }
}
