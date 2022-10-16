package com.licslan.interview.hot100;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * @author WEILIN
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的
 * 最大值。这条路径可能穿过也可能不穿过根结点
 */
public class DiameterOfBinaryTree543 {


    //遍历每一个节点，以每一个节点为中心点计算最长路径（左子树边长+右子树边长），更新全局变量max

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        //遍历左子树
        int leftSize = root.left == null ? 0 : dfs(root.left) + 1;

        //遍历右子树
        int rightSize = root.right == null ? 0 : dfs(root.right) + 1;

        max = Math.max(max, leftSize + rightSize);

        return Math.max(leftSize, rightSize);
    }


    public int diameterOfBinaryTreeV2(TreeNode root) {
        if (root != null) {
            //遍历每一个节点,求出此节点作为根的树的深度,那么,左子树深度加右子树深度的最大值即是答案
            setDepth(root);
            return max;
        }
        return 0;
    }

    public int setDepth(TreeNode root) {
        if (root != null) {
            int right = setDepth(root.right);
            int left = setDepth(root.left);
            if (right + left > max) {
                max = right + left;
            }
            return Math.max(right, left) + 1;
        }
        return 0;
    }
}
