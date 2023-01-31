package com.licslan.interview.leetcode500.tree;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * @author licslan
 * LeetCode 专栏  ♥  NO145
 * 判断二叉树是否对称
 */
public class IsSymmetric101 {


    private boolean isSym(TreeNode root) {

        if (root == null) {
            return true;
        }

        return checkSym(root.left, root.right);

    }

    private boolean checkSym(TreeNode rootLeft, TreeNode rootRight) {

        //终止条件 遍历后都为空  遍历到最后了  都为空了  说明对称
        if (rootLeft == null && rootRight == null) {
            return true;
        }

        //终止条件 有一个为空  不对称
        if (rootLeft == null || rootLeft == null) {
            return false;
        }

        //终止条件 对应的节点的值不相等  不对称
        if (rootLeft.val != rootLeft.val) {
            return false;
        }

        //左节点的左子树 == 右节点的右子树        左节点的右子树 == 右节点的左子树
        return checkSym(rootLeft.left, rootRight.right) &&
                checkSym(rootLeft.right, rootRight.left);

    }


}
