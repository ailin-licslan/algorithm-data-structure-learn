package com.licslan.interview.hot100;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * @author WEILIN
 * 相关企业
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 思路
 * 1.怎么判断一棵树是不是对称二叉树？ 答案：如果所给根节点，为空，那么是对称。
 * 如果不为空的话，当他的左子树与右子树对称时，他对称  （左子树 右子树 里面的值要相等）
 * <p>
 * 2.那么怎么知道左子树与右子树对不对称呢？在这我直接叫为左树和右树
 * 答案：如果左树的左孩子与右树的右孩子对称，左树的右孩子与右树的左孩子对称，那么这个左树和右树就对称。
 */
public class IsSymmetric101 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {

        //1.空的话 对称
        if ((left == null && right == null)) {
            return true;
        }

        //2.此情况不对称
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        //递归判断 反正只要不是上面2的情况那么就是对称的
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
