package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int c = count(0, root.left);
        if (c>k) {
            kthSmallest(root.left, k);
        } else if (c<k-1) {
            kthSmallest(root.right, k-c-1);
        } else if (c == k-1) {
            return root.val;
        }
        return root.left.val;
    }

    private int count(Integer c, TreeNode root) {
        if (root == null) {
            return 0;
        }
        count(c, root.left);
        count(c, root.right);
        return ++c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = CommonUtil.stringToTreeNode(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new KthSmallest().kthSmallest(root, k);
            String out = String.valueOf(ret);
            System.out.print(out);
        }
    }
}
