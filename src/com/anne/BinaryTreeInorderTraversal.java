package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        while (root != null && !nodeStack.isEmpty()) {
            if (root != null) {
                nodeStack.push(root);
                root = root.left;
            } else {
                root = nodeStack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = CommonUtil.stringToTreeNode(line);

            List<Integer> ret = new BinaryTreeInorderTraversal().solution(root);

            String out = CommonUtil.integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
