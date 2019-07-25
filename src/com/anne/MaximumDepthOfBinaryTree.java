package com.anne;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Anne Zhang
 * Date: 2019/1/5
 * Description:
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int level = 1;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = stack.pop();
            TreeNode node = nodePair.getKey();
            int curLevel = nodePair.getValue();
            level = Math.max(level, curLevel);
            if (node.left != null) {
                stack.push(new Pair(node.left, curLevel+1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, curLevel+1));
            }
        }
        return level;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);

            int ret = new MaximumDepthOfBinaryTree().maxDepth(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }




}
