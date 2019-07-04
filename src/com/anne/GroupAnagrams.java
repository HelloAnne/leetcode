package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            int[] arr = new int[26];
            String str = strs[i];
            for (int j=0; j<str.length(); j++) {
                arr[str.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int j=0; i<26; i++) {
                sb.append("#");
                sb.append(arr[j]);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] nums = CommonUtil.stringToStringArray(line);
            List<List<String>> ret = new GroupAnagrams().solution(nums);
            String out = CommonUtil.string2dListToString(ret);
            System.out.print(out);
        }
    }
}
