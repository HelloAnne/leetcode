package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.anne.CommonUtil.int2dListToString;
import static com.anne.CommonUtil.stringToIntegerArray;

public class ThreeSum {
    public List<List<Integer>> solution(int[] nums) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                if (map.containsKey(nums[i]+nums[j])) {
                    map.get(nums[i]+nums[j]).add(list);
                } else {
                    List<List<Integer>> orgList = new ArrayList<>();
                    orgList.add(list);
                    map.put(nums[i]+nums[j], orgList);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]*-1)) {
                List<List<Integer>> orgList = map.get(nums[i]*-1);
                map.remove(nums[i]*-1);
                for (List<Integer> list : orgList) {
                    list.add(nums[i]);
                    res.add(list);
                }

            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new ThreeSum().solution(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
