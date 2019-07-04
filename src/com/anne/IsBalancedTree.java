package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsBalancedTree {
    public boolean solution(TreeNode root) {
        int longPath = longPath(root);
        int shortPath = shortPath(root);

        return longPath-shortPath<=1;
    }

    private int longPath(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return Math.max(longPath(root.left), longPath(root.right))+1;
    }

    private int shortPath(TreeNode root) {
        if (root==null || root.left==null || root.right==null) {
            return 0;
        }
        return Math.min(longPath(root.left), longPath(root.right))+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = CommonUtil.stringToTreeNode(line);
            boolean ret = new IsBalancedTree().solution(root);
            String out = CommonUtil.booleanToString(ret);
            System.out.print(out);
        }
    }
}

