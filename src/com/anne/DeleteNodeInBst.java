package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Anne Zhang
 * Date: 2019/1/5
 * Description:
 */
public class DeleteNodeInBst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else {
                TreeNode rightMin = findMin (root.right);
                root.right = deleteNode(root.right, rightMin.val);
                rightMin.left = root.left;
                rightMin.right = root.right;
                return rightMin;
            }
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);

        return root;
    }


    private TreeNode findMin (TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }




    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            line = in.readLine();
            int key = Integer.parseInt(line);

            TreeNode ret = new DeleteNodeInBst().deleteNode(root, key);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
