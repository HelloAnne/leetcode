package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: Anne Zhang
 * Date: 2019/1/7
 * Description:
 */
public class MoveZeroes {

    public void solution(int[] nums) {
        int i=0;
        int j=0;
        for (; j<nums.length; j++) {
            if (nums[j] != 0) {
                CommonUtil.swap(nums, i++, j);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = CommonUtil.stringToIntegerArray(line);

            new MoveZeroes().solution(nums);
            String out = CommonUtil.integerArrayToString(nums);

            System.out.print(out);
        }
    }
}
