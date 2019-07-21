package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: Anne Zhang
 * Date: 2019/1/7
 * Description:
 */
public class HammingDistance {

    public int solution(int x, int y) {
        int c = x ^y;
        int res = 0;
        while (c>0) {
            if (c%2 == 1) {
                res++;
            }
            c = c >> 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);

            int ret = new HammingDistance().solution(x, y);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
