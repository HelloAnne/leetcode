package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindUnsortedSubarray {

    public int solution(int[] nums) {
        if (nums == null && nums.length <2) {
            return 0;
        }
        int i = 0;
        int j = nums.length-1;
        int a = -1;
        int b = -1;
        int[] res = new int[2];
        
        while (j >= i && (a == -1 || b == -1)) {
            if (nums[i+1] <= nums[i]) {
                i++;
            } else {
                a = i;
            }
            if (nums[j-1] <= nums[j]) {
                j--;
            } else {
                b = j;
            }

        }
        return b-a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = CommonUtil.stringToIntegerArray(line);

            int ret = new FindUnsortedSubarray().solution(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
